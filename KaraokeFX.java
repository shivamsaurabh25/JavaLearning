/** /**
 * PalPalKaraokeFX.java
 *
 * JavaFX karaoke app:
 *  - plays an audio file (mp3/ogg/etc)
 *  - displays typed lyrics synchronized to timestamps
 *  - animated background (particles + gradient)
 *  - colored lines and smooth fade/typewriter animations
 *  - optional .lrc file auto-load if placed next to audio file with same base name
 *
 * How to run (example):
 *  1) Install Java 11+ and JavaFX SDK.
 *  2) Compile:
 *     javac --release 11 --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.media,javafx.graphics PalPalKaraokeFX.java
 *  3) Run (give audio path as first argument or choose file at startup):
 *     java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.media,javafx.graphics PalPalKaraokeFX "/path/to/song.mp3"
 *
 * Notes:
 *  - If you pass an audio file, the app will try to find a .lrc file with same base name in the same folder.
 *    If not found, it will fall back to built-in timestamps & lyrics (the Pal Pal arrays).
 *  - Make sure file URIs are accessible (no spaces issue handled by using toURI()).
 

import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.media.*;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class PalPalKaraokeFX extends Application {

    // Typewriter & UI timing
    private static final int CHAR_DELAY_MS = 22;     // smaller -> smoother/faster typing
    private static final int LINE_FADE_MS = 300;     // fade-in for each line
    private static final int POLL_MS = 60;           // how often we check media time for next line (ms)

    // Colors to cycle through for lyric lines (CSS-compatible colors)
    private static final Color[] COLORS = new Color[] {
            Color.web("#ff6b6b"), // coral red
            Color.web("#51cf66"), // green
            Color.web("#ffd43b"), // yellow
            Color.web("#4dabf7"), // blue
            Color.web("#b197fc"), // purple
            Color.web("#63e6be"), // mint
            Color.web("#ffa8a8"), // soft red
            Color.web("#b2f2bb"), // soft green
    };

    // Fallback timestamps & lyrics (same as you gave)
    private static final String[] TIMES_FALLBACK = {
        "00:17.71","00:20.17","00:22.10","00:24.75","00:26.84","00:29.25",
        "00:31.68","00:33.87","00:36.14","00:38.28","00:40.28","00:44.89",
        "00:49.54","00:54.24","00:58.78","01:03.56","01:08.02","01:12.87",
        "01:15.73","01:18.07","01:22.41","01:25.08","01:27.24","01:31.37",
        "01:33.36","01:35.11","01:37.99","01:40.13","01:42.12","01:44.67",
        "01:46.93","01:49.06","01:51.96","01:54.47","01:56.78","01:58.36",
        "02:00.47","02:03.05","02:05.52","02:08.46","02:12.68","02:17.36",
        "02:21.88","02:26.88","02:30.93","02:35.59","02:40.60","02:46.71",
        "02:48.93","02:51.31","02:53.61","02:55.96","02:58.01","03:00.29","03:02.69"
    };

    private static final String[] LYRICS_FALLBACK = {
        "Pal pal jeena muhal","Mera tere bina","Ye sary nashe bekaar","Teri ankhon kay siwa",
        "Ghar nahi jata mein bahar","Rehta tera intazar","Mere, khwabon mein aa na","Kakry sola singhaar",
        "Mein ab kyu hosh mein ata ni","Sukoon ye dil kyu pata ni","Kyu toru khud say jo thy wade kay ab ye ishq nibahana nahi",
        "Mein moru tumsy jo ye chehra dubara nazar milana nahi","Ye duniya janay mera dard tujhe ye nazar kyu ata nahi",
        "Soneya yu tera sharmana meri jaan na lele","Kaan ke peechy zulf chupana meri jan kya kehnay",
        "Zalima toba tera nakhra iske war kya kehne","Tham ky bethe dil ko ghayal kaheen har na bethein",
        "Teri nazrien mujhsy kya kehti hen","Inme wafa bethi hay","Thori thori si razi thori si khafa rehti hein",
        "Log hein zalim bary","Inme jafa dekhi hay","Ye duniya teri nahi mene tunjmy haya dekhi hay",
        "Jeena muhal","Mera tere bina","Ye sary nashe bekaar","Teri ankhon kay siwa",
        "Ghar nahi jata mein bahar","Rehta tera intazar","Mere, khwabon mein aa na","Kakry sola singhaar",
        "Tera mera afsana","Pura huya na jana","Hua band kamre which kalla","fir bhi dis da ye pareshwa",
        "Saare puch de ne menue","Keyon main gallan nain kardan","Kinnay sohne ne chehre ethe","Dil kyun naeee ay bharda",
        "Je naa deedaar hoya","Ohna chirr din naiyo charhda","Dil karay dildaariyan","Bina gallan saareyaan naa larrda",
        "Jidaan rang milde ne odha he aapan mil jaana","Jidaan phull khilde ne odha he donaa khill jaana",
        "Jidaan rang milde ne odha he aapan mil jaana","Jidaan phull khilde ne odha he donaa khill jaana",
        "Tera mera afsana","Pal pal jeena muhaal","Poora hoya naa jaana","Saaray nashay bekaar",
        "Hovaan band kamray vich kalla","Ghar nahi jaata, mein bahar","Kinnay sohne ne chehre ethe","Kar ke solah singhaar"
    };

    // UI nodes that we will update
    private Text lyricText;
    private Text subText;
    private MediaPlayer mediaPlayer;
    private Slider progressSlider;
    private Label timeLabel;
    private Button playPauseBtn;

    // lyric timing lists (ms)
    private List<Long> offsetsMs;
    private List<String> lyrics;

    // pointer to next lyric index
    private int nextIndex = 0;

    // Timeline for polling current time and triggering lines
    private AnimationTimer lyricTimer;

    // Typewriter timeline reference for canceling current typing
    private Timeline currentTypingTimeline;

    // particle system for background
    private final List<Particle> particles = new ArrayList<>();
    private AnimationTimer particleTimer;

    // Stage primary
    private Stage primaryStageRef;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStageRef = primaryStage;

        // top layout
        BorderPane root = new BorderPane();
        root.setPrefSize(1000, 600);

        // Canvas for animated background
        Canvas canvas = new Canvas(1000, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // overlay for subtle blur glow
        StackPane centerPane = new StackPane();
        centerPane.getChildren().add(canvas);

        // Lyric display (center)
        VBox lyricBox = new VBox(6);
        lyricBox.setAlignment(Pos.CENTER);
        lyricBox.setPadding(new Insets(40));
        lyricText = new Text("");
        lyricText.setTextAlignment(TextAlignment.CENTER);
        lyricText.setFont(Font.font("Segoe UI Variable", FontWeight.BOLD, 36));
        lyricText.setWrappingWidth(900);
        lyricText.setEffect(new DropShadow(12, Color.rgb(0,0,0,0.6)));

        subText = new Text("");
        subText.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 16));
        subText.setFill(Color.web("#ffffffaa"));

        lyricBox.getChildren().addAll(lyricText, subText);
        centerPane.getChildren().add(lyricBox);

        // controls bottom bar
        HBox controls = new HBox(12);
        controls.setPadding(new Insets(10));
        controls.setAlignment(Pos.CENTER);
        controls.setStyle("-fx-background-color: rgba(0,0,0,0.35);");

        playPauseBtn = new Button("►");
        playPauseBtn.setPrefWidth(56);

        progressSlider = new Slider();
        progressSlider.setMin(0);
        progressSlider.setMax(1000);
        progressSlider.setMinWidth(400);
        progressSlider.setMaxWidth(Double.MAX_VALUE);

        timeLabel = new Label("00:00 / 00:00");
        Button openBtn = new Button("Open File");

        controls.getChildren().addAll(playPauseBtn, progressSlider, timeLabel, openBtn);
        HBox.setHgrow(progressSlider, Priority.ALWAYS);

        root.setCenter(centerPane);
        root.setBottom(controls);

        // Styling and scene
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("PalPal Karaoke — JavaFX");
        primaryStage.show();

        // make canvas size responsive
        scene.widthProperty().addListener((obs, oldV, newV) -> {
            canvas.setWidth(newV.doubleValue());
        });
        scene.heightProperty().addListener((obs, oldV, newV) -> {
            canvas.setHeight(newV.doubleValue());
        });

        // Initialize particles
        initParticles(canvas.getWidth(), canvas.getHeight());

        // Start particle animation
        startParticleAnimation(gc, canvas);

        // Load default fallback lyrics
        loadFallbackLyrics();

        // Play / Pause button behavior (initially disabled until media loaded)
        playPauseBtn.setOnAction(e -> {
            if (mediaPlayer == null) return;
            MediaPlayer.Status s = mediaPlayer.getStatus();
            if (s == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
                playPauseBtn.setText("►");
            } else {
                mediaPlayer.play();
                playPauseBtn.setText("❚❚");
            }
        });

        // Open audio file button
        openBtn.setOnAction(e -> chooseAndLoadAudio(primaryStage));

        // progress slider seeking
        progressSlider.setOnMousePressed(e -> {
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        });
        progressSlider.setOnMouseReleased(e -> {
            if (mediaPlayer != null) {
                double pos = progressSlider.getValue() / 1000.0;
                Duration d = mediaPlayer.getTotalDuration();
                if (d != null && !d.isUnknown()) {
                    mediaPlayer.seek(d.multiply(pos));
                }
                mediaPlayer.play();
                playPauseBtn.setText("❚❚");
            }
        });

        // If user passed audio path as program arg, try to load it
        Parameters params = getParameters();
        List<String> raw = params.getRaw();
        if (!raw.isEmpty()) {
            String audioPath = raw.get(0);
            Platform.runLater(() -> loadAudioFile(new File(audioPath)));
        }
    }

    // -------------------------
    // Audio & Lyrics Loading
    // -------------------------
    private void chooseAndLoadAudio(Stage owner) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open audio file (mp3/wav/ogg...)");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Audio Files", "*.mp3", "*.wav", "*.aac", "*.m4a", "*.ogg")
        );
        File f = chooser.showOpenDialog(owner);
        if (f != null) {
            loadAudioFile(f);
        }
    }

    private void loadAudioFile(File audioFile) {
        try {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.dispose();
                mediaPlayer = null;
            }
            URI uri = audioFile.toURI();
            Media media = new Media(uri.toString());
            mediaPlayer = new MediaPlayer(media);

            // attach listeners for UI updates
            mediaPlayer.setOnReady(() -> {
                Duration total = media.getDuration();
                progressSlider.setDisable(false);
                updateTimeLabel(Duration.ZERO, total);
                attachProgressBinding();
                // try to find .lrc file next to audio
                File lrc = tryFindLrc(audioFile);
                if (lrc != null) {
                    try {
                        parseLrcFile(lrc);
                    } catch (Exception ex) {
                        // fallback to built-in if parse fails
                        loadFallbackLyrics();
                    }
                } else {
                    // keep fallback already loaded
                }
                resetLyricState();
            });

            mediaPlayer.setOnEndOfMedia(() -> {
                playPauseBtn.setText("►");
                // optionally restart
                // mediaPlayer.seek(Duration.ZERO);
            });

            // update time label as it plays
            mediaPlayer.currentTimeProperty().addListener((obs, oldT, newT) -> {
                if (mediaPlayer == null) return;
                Duration total = mediaPlayer.getTotalDuration();
                if (total != null && !total.isUnknown()) {
                    updateTimeLabel(newT, total);
                    double frac = newT.toMillis() / total.toMillis();
                    progressSlider.setValue(frac * 1000.0);
                }
            });

            // start polling for lyrics (AnimationTimer)
            startLyricTimer();

            // autoplay
            mediaPlayer.play();
            playPauseBtn.setText("❚❚");

        } catch (Exception ex) {
            ex.printStackTrace();
            showError("Failed to load audio: " + ex.getMessage());
        }
    }

    private File tryFindLrc(File audioFile) {
        try {
            String base = audioFile.getName();
            int idx = base.lastIndexOf('.');
            if (idx > 0) base = base.substring(0, idx);
            File parent = audioFile.getParentFile();
            if (parent == null) return null;
            File lrc = new File(parent, base + ".lrc");
            if (lrc.exists()) return lrc;
            // case-insensitive search
            for (File f : parent.listFiles((dir, name) -> name.toLowerCase().endsWith(".lrc"))) {
                if (f.getName().toLowerCase().startsWith(base.toLowerCase())) return f;
            }
        } catch (Exception ignored) {}
        return null;
    }

    private void parseLrcFile(File lrc) throws IOException {
        List<String> lines = Files.readAllLines(lrc.toPath(), StandardCharsets.UTF_8);
        List<Long> times = new ArrayList<>();
        List<String> texts = new ArrayList<>();
        for (String raw : lines) {
            String line = raw.trim();
            if (line.isEmpty()) continue;
            // LRC lines can have multiple time tags: [mm:ss.xx]text
            while (line.startsWith("[")) {
                int close = line.indexOf(']');
                if (close < 0) break;
                String timeTag = line.substring(1, close);
                long ms = parseTimestampToMs(timeTag);
                String rest = line.substring(close + 1).trim();
                if (!rest.isEmpty()) {
                    times.add(ms);
                    texts.add(rest);
                }
                line = rest.isEmpty() ? "" : line.substring(close + 1);
                break; // handle simple [time]text format
            }
        }
        if (times.isEmpty()) throw new IOException("No valid lyric tags found in .lrc");
        // assign
        offsetsMs = times.stream().map(Long::valueOf).collect(Collectors.toList());
        lyrics = new ArrayList<>(texts);
    }

    private void loadFallbackLyrics() {
        offsetsMs = new ArrayList<>();
        lyrics = new ArrayList<>();
        for (int i = 0; i < TIMES_FALLBACK.length && i < LYRICS_FALLBACK.length; i++) {
            offsetsMs.add(parseTimestampToMs(TIMES_FALLBACK[i]));
            lyrics.add(LYRICS_FALLBACK[i]);
        }
    }

    // reset index and hide text
    private void resetLyricState() {
        nextIndex = 0;
        Platform.runLater(() -> {
            lyricText.setText("");
            subText.setText("");
            lyricText.setOpacity(0);
        });
    }

    // --------------------------
    // Lyric sync & typewriter
    // --------------------------
    private void startLyricTimer() {
        if (lyricTimer != null) lyricTimer.stop();
        lyricTimer = new AnimationTimer() {
            private long lastPoll = 0;
            @Override
            public void handle(long nowNano) {
                if (mediaPlayer == null) return;
                long nowMs = System.currentTimeMillis();
                if (nowMs - lastPoll < POLL_MS) return;
                lastPoll = nowMs;

                Duration cur = mediaPlayer.getCurrentTime();
                long curMs = (long) cur.toMillis();

                // trigger lines whose offsets <= curMs
                while (nextIndex < offsetsMs.size() && offsetsMs.get(nextIndex) <= curMs + 50) { // +50ms tolerance
                    String line = lyrics.get(nextIndex);
                    int colorIndex = nextIndex % COLORS.length;
                    Color c = COLORS[colorIndex];
                    showLyricLine(line, c, nextIndex);
                    nextIndex++;
                }
            }
        };
        lyricTimer.start();
    }

    private void showLyricLine(String line, Color color, int index) {
        // Cancel current typing (if any)
        if (currentTypingTimeline != null) {
            currentTypingTimeline.stop();
            currentTypingTimeline = null;
        }
        // Prepare nodes
        Platform.runLater(() -> {
            // set subtext with index/time if you want small info
            subText.setText(String.format("Line %d / %d", index + 1, Math.max(1, lyrics.size())));
            lyricText.setFill(color);

            // create typewriter timeline
            final String full = line;
            lyricText.setText("");
            lyricText.setOpacity(1.0);

            currentTypingTimeline = new Timeline();
            int len = full.length();
            for (int i = 0; i <= len; i++) {
                final int count = i;
                KeyFrame kf = new KeyFrame(Duration.millis(i * CHAR_DELAY_MS), ev -> {
                    lyricText.setText(full.substring(0, count));
                });
                currentTypingTimeline.getKeyFrames().add(kf);
            }
            // add fade-in on start
            lyricText.setOpacity(0);
            Timeline fadeIn = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(lyricText.opacityProperty(), 0)),
                    new KeyFrame(Duration.millis(LINE_FADE_MS), new KeyValue(lyricText.opacityProperty(), 1))
            );

            // play fade + typing in parallel
            ParallelTransition pt = new ParallelTransition(fadeIn, currentTypingTimeline);
            pt.play();
        });
    }

    // -------------------------
    // Particle background
    // -------------------------
    private void initParticles(double w, double h) {
        particles.clear();
        Random rnd = new Random();
        int count = 40;
        for (int i = 0; i < count; i++) {
            particles.add(new Particle(rnd.nextDouble() * w, rnd.nextDouble() * h,
                    10 + rnd.nextDouble() * 30, // radius
                    -0.2 + rnd.nextDouble() * 0.4, // vx
                    -0.2 + rnd.nextDouble() * 0.4, // vy
                    0.06 + rnd.nextDouble() * 0.2 // drift
            ));
        }
    }

    private void startParticleAnimation(GraphicsContext gc, Canvas canvas) {
        if (particleTimer != null) particleTimer.stop();

        particleTimer = new AnimationTimer() {
            private long lastTime = 0;
            @Override
            public void handle(long now) {
                double w = canvas.getWidth();
                double h = canvas.getHeight();
                if (lastTime == 0) lastTime = now;
                double dt = (now - lastTime) / 1_000_000_000.0;
                lastTime = now;

                // background gradient
                Stop[] stops = new Stop[] {
                        new Stop(0, Color.web("#0f172a")),
                        new Stop(1, Color.web("#001219"))
                };
                gc.setFill(new LinearGradient(0, 0, w, h, false, CycleMethod.NO_CYCLE, stops));
                gc.fillRect(0, 0, w, h);

                // faint moving radial highlights
                double cx = (Math.sin(System.currentTimeMillis() / 2000.0) * 0.5 + 0.5) * w;
                double cy = (Math.cos(System.currentTimeMillis() / 2500.0) * 0.5 + 0.5) * h;
                RadialGradient rg = new RadialGradient(0, 0, cx/w, cy/h, Math.max(w,h)/2, true,
                        CycleMethod.NO_CYCLE, new Stop(0, Color.web("#ffffff10"), 0.0), new Stop(1, Color.web("#ffffff00"), 1.0));
                gc.setGlobalAlpha(0.12);
                gc.setFill(rg);
                gc.fillRect(0,0,w,h);
                gc.setGlobalAlpha(1.0);

                // draw moving particles
                for (Particle p : particles) {
                    p.update(dt, w, h);
                    double r = p.radius;
                    // glow circle
                    RadialGradient g2 = new RadialGradient(0,0, p.x/w, p.y/h, r, true, CycleMethod.NO_CYCLE,
                            new Stop(0, Color.web("#ffffff44")), new Stop(1, Color.web("#ffffff00")));
                    gc.setFill(g2);
                    gc.fillOval(p.x - r, p.y - r, r*2, r*2);

                    // core color depending on index
                    gc.setFill(Color.web("#ffffff", 0.14));
                    gc.fillOval(p.x - r*0.35, p.y - r*0.35, r*0.7, r*0.7);
                }
            }
        };

        particleTimer.start();
    }

    // -------------------------
    // Utilities
    // -------------------------
    private void attachProgressBinding() {
        // already handled by currentTime listener
    }

    private void updateTimeLabel(Duration cur, Duration total) {
        String c = formatMs((long) cur.toMillis());
        String t = formatMs((long) total.toMillis());
        Platform.runLater(() -> timeLabel.setText(c + " / " + t));
    }

    private String formatMs(long ms) {
        long totalSec = ms / 1000;
        long min = totalSec / 60;
        long sec = totalSec % 60;
        return String.format("%02d:%02d", min, sec);
    }

    private void showError(String msg) {
        Platform.runLater(() -> {
            Alert a = new Alert(Alert.AlertType.ERROR, msg, ButtonType.OK);
            a.initOwner(primaryStageRef);
            a.showAndWait();
        });
    }

    // parse mm:ss.xx -> milliseconds
    private static long parseTimestampToMs(String t) {
        try {
            String s = t.trim();
            if (s.startsWith("[")) {
                int end = s.indexOf(']');
                if (end > 0) s = s.substring(1, end);
            }
            String[] parts = s.split(":");
            int minutes = Integer.parseInt(parts[0]);
            String[] secParts = parts[1].split("\\.");
            int seconds = Integer.parseInt(secParts[0]);
            int centi = 0;
            if (secParts.length > 1) {
                String frac = secParts[1];
                if (frac.length() == 1) frac += "0";
                if (frac.length() > 2) frac = frac.substring(0, 2);
                centi = Integer.parseInt(frac);
            }
            long ms = (minutes * 60_000L) + (seconds * 1_000L) + (centi * 10L);
            return ms;
        } catch (Exception e) {
            return 0;
        }
    }

    // -------------------------
    // Helper: simple particle class
    // -------------------------
    private static class Particle {
        double x, y;
        double radius;
        double vx, vy;
        double drift; // small random wiggle
        Random rnd = new Random();
        Particle(double x, double y, double radius, double vx, double vy, double drift) {
            this.x = x; this.y = y; this.radius = radius; this.vx = vx; this.vy = vy; this.drift = drift;
        }
        void update(double dt, double w, double h) {
            x += vx * dt * 60 + Math.sin(System.currentTimeMillis() * 0.001 + x) * drift;
            y += vy * dt * 60 + Math.cos(System.currentTimeMillis() * 0.001 + y) * drift;
            // wrap around edges
            if (x < -radius) x = w + radius;
            if (x > w + radius) x = -radius;
            if (y < -radius) y = h + radius;
            if (y > h + radius) y = -radius;
        }
    }
} */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.*;

public class KaraokeFX extends Application {

    private VBox lyricsBox;
    private MediaPlayer player;
    private List<LrcLine> parsedLines = new ArrayList<>();
    private Timeline karaokeTimeline;
    private ScrollPane scroll;

    @Override
    public void start(Stage stage) {

        // ★ Animated background layer
        Pane background = new Pane();
        background.setStyle("-fx-background-color: linear-gradient(to bottom, #151515, #202020);");

        Timeline bgAnim = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(background.opacityProperty(), 0.75)),
                new KeyFrame(Duration.seconds(4),
                        new KeyValue(background.opacityProperty(), 1.0))
        );
        bgAnim.setCycleCount(Animation.INDEFINITE);
        bgAnim.setAutoReverse(true);
        bgAnim.play();

        // ★ Lyrics container
        lyricsBox = new VBox(30);
        lyricsBox.setAlignment(Pos.CENTER);
        lyricsBox.setStyle("-fx-padding: 40;");

        scroll = new ScrollPane(lyricsBox);
        scroll.setFitToWidth(true);
        scroll.setStyle("-fx-background: transparent; -fx-background-color: transparent;");

        // ★ Controls
        Button loadSongBtn = new Button("🎵 Load Song");
        Button loadLrcBtn = new Button("📝 Paste LRC");
        Button playBtn = new Button("▶ Play");

        loadSongBtn.setPrefWidth(140);
        loadLrcBtn.setPrefWidth(140);
        playBtn.setPrefWidth(140);

        HBox topControls = new HBox(15, loadSongBtn, loadLrcBtn, playBtn);
        topControls.setAlignment(Pos.CENTER);
        topControls.setStyle("-fx-padding: 15;");

        // ★ Layout with correct background layering
        StackPane stack = new StackPane();
        BorderPane ui = new BorderPane();

        ui.setTop(topControls);
        ui.setCenter(scroll);

        stack.getChildren().addAll(background, ui);

        Scene scene = new Scene(stack, 900, 700, Color.BLACK);

        // ---------------- BUTTON ACTIONS ----------------

        loadSongBtn.setOnAction(e -> {
            try {
                FileChooser chooser = new FileChooser();
                chooser.getExtensionFilters().add(
                        new FileChooser.ExtensionFilter("Audio Files", "*.mp3", "*.wav")
                );
                File selected = chooser.showOpenDialog(stage);

                if (selected != null) {
                    if (player != null) player.stop();
                    player = new MediaPlayer(new Media(selected.toURI().toString()));
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        loadLrcBtn.setOnAction(e -> loadLrcPopup());
        playBtn.setOnAction(e -> startKaraoke());

        // Show stage
        stage.setTitle("🎤 JavaFX Karaoke Player");
        stage.setScene(scene);
        stage.show();
    }

    // -----------------------------------------------------
    // 🎵 LOAD LRC POPUP
    // -----------------------------------------------------
    private void loadLrcPopup() {
        Stage popup = new Stage();
        TextArea area = new TextArea();
        area.setPrefSize(500, 400);

        Button ok = new Button("Load Lyrics");

        ok.setOnAction(e -> {
            parseLrc(area.getText());
            displayLyrics();
            popup.close();
        });

        VBox box = new VBox(10, new Label("Paste LRC text:"), area, ok);
        box.setAlignment(Pos.CENTER);
        box.setStyle("-fx-padding: 20;");

        popup.setScene(new Scene(box));
        popup.show();
    }

    // -----------------------------------------------------
    // 🎵 LRC PARSER
    // -----------------------------------------------------
    private void parseLrc(String raw) {
        parsedLines.clear();
        String[] lines = raw.split("\n");

        for (String line : lines) {
            try {
                if (line.startsWith("[")) {

                    String time = line.substring(1, 9);
                    String text = line.substring(10);

                    long ms = parseTime(time);
                    parsedLines.add(new LrcLine(ms, text));
                }
            } catch (Exception ignore) {}
        }

        parsedLines.sort(Comparator.comparingLong(l -> l.time));
    }

    // -----------------------------------------------------
    // 🎵 DISPLAY LYRICS AS TEXTFLOW
    // -----------------------------------------------------
    private void displayLyrics() {
        lyricsBox.getChildren().clear();

        for (LrcLine l : parsedLines) {

            TextFlow flow = new TextFlow();
            flow.setUserData(l);
            flow.setTextAlignment(TextAlignment.CENTER);

            for (String w : l.text.split(" ")) {
                Text t = new Text(w + " ");
                t.setFont(Font.font("Poppins", FontWeight.BOLD, 34));
                t.setFill(Color.web("#777777"));
                flow.getChildren().add(t);
            }

            lyricsBox.getChildren().add(flow);
        }
    }

    // -----------------------------------------------------
    // 🎵 START KARAOKE
    // -----------------------------------------------------
    private void startKaraoke() {
        if (player == null || parsedLines.isEmpty()) return;

        player.stop();
        player.play();

        if (karaokeTimeline != null) karaokeTimeline.stop();

        karaokeTimeline = new Timeline(
                new KeyFrame(Duration.millis(15), e -> updateKaraoke())
        );
        karaokeTimeline.setCycleCount(Animation.INDEFINITE);
        karaokeTimeline.play();
    }

    // -----------------------------------------------------
    // 🎵 UPDATE KARAOKE WORD HIGHLIGHT
    // -----------------------------------------------------
    private void updateKaraoke() {

        long currentMs = (long) player.getCurrentTime().toMillis();

        for (int i = 0; i < parsedLines.size(); i++) {

            LrcLine line = parsedLines.get(i);
            long nextTime =
                    (i < parsedLines.size() - 1)
                            ? parsedLines.get(i + 1).time
                            : line.time + 3000;

            if (currentMs >= line.time && currentMs < nextTime) {

                TextFlow flow = (TextFlow) lyricsBox.getChildren().get(i);

                long lineDuration = nextTime - line.time;
                double progress = (double) (currentMs - line.time) / lineDuration;

                int words = flow.getChildren().size();
                int highlightCount = (int) (progress * words);

                for (int w = 0; w < words; w++) {
                    Text t = (Text) flow.getChildren().get(w);

                    if (w < highlightCount)
                        t.setFill(Color.web("#00ff80"));
                    else
                        t.setFill(Color.web("#777777"));
                }

                // ⭐ Smooth scroll to active line
                scroll.setVvalue((double) i / parsedLines.size());
                break;
            }
        }
    }

    // -----------------------------------------------------
    // ⏱ mm:ss.xx → milliseconds
    // -----------------------------------------------------
    private long parseTime(String t) {
        try {
            int m = Integer.parseInt(t.substring(0, 2));
            int s = Integer.parseInt(t.substring(3, 5));
            int cs = Integer.parseInt(t.substring(6));

            return (m * 60000L) + (s * 1000L) + (cs * 10L);

        } catch (Exception e) {
            return 0;
        }
    }

    // -----------------------------------------------------
    // DATA MODEL
    // -----------------------------------------------------
    private static class LrcLine {
        long time;
        String text;

        LrcLine(long t, String s) {
            time = t;
            text = s;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}