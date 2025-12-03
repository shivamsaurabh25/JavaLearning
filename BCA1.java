import java.applet.Applet;
import java.awt.*;
public class BCA1 extends Applet {
    TextField ta;
    Button bl;
    Image img;
    public void init() {
        ta = new TextField();
        bl = new Button("Ok");
        add(ta);
        add(bl);
        img = getImage(getCodeBase(), "1.png");
    }
    public void paint(Graphics g) {
        g.drawImage(img, 100, 100, this);
        g.drawString("Applet with Image", 40, 60);
    }
}