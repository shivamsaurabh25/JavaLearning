import java.awt.*;
import java.awt.event.*;
class Library {
    int bno;
    String name;
    String author;
    float price;
    Library() {
        bno = 0;
        name = "";
        author = "";
        price = 0;
    }
}
public class LibraryGUI extends Frame implements ActionListener {
    Library[] books = new Library[10];
    int count = 0;
    MenuBar mb;
    Menu mAdd, mSearch, mModify;
    MenuItem addItem, searchItem, modifyItem;
    Label l1, l2, l3, l4;
    TextField t1, t2, t3, t4;
    Button addBtn;
    Label sl1;
    TextField st1;
    Button searchBtn;
    TextArea resultArea;
    Label ml1, ml2, ml3, ml4;
    TextField mt1, mt2, mt3, mt4;
    Button searchModBtn, modifyBtn;
    public LibraryGUI() {
        for (int i = 0; i < 10; i++)
            books[i] = new Library();

        setLayout(null);
        setTitle("Library Management - AWT Only");
        setSize(800, 800);
        mb = new MenuBar();
        mAdd = new Menu("Add");
        addItem = new MenuItem("Book_Add");
        mAdd.add(addItem);
        mSearch = new Menu("Search");
        searchItem = new MenuItem("Search_Book");
        mSearch.add(searchItem);
        mModify = new Menu("Modify");
        modifyItem = new MenuItem("Book_Modify");
        mModify.add(modifyItem);
        mb.add(mAdd);
        mb.add(mSearch);
        mb.add(mModify);
        setMenuBar(mb);
        addItem.addActionListener(this);
        searchItem.addActionListener(this);
        modifyItem.addActionListener(this);
        setupAddUI();
        setupSearchUI();
        setupModifyUI();
        hideAll();
        setVisible(true);
    }
    void setupAddUI() {
        l1 = new Label("Book No:");
        l1.setBounds(50, 80, 80, 25);
        t1 = new TextField();
        t1.setBounds(140, 80, 150, 25);
        l2 = new Label("Book Name:");
        l2.setBounds(50, 120, 80, 25);
        t2 = new TextField();
        t2.setBounds(140, 120, 150, 25);
        l3 = new Label("Author:");
        l3.setBounds(50, 160, 80, 25);
        t3 = new TextField();
        t3.setBounds(140, 160, 150, 25);
        l4 = new Label("Price:");
        l4.setBounds(50, 200, 80, 25);
        t4 = new TextField();
        t4.setBounds(140, 200, 150, 25);
        addBtn = new Button("ADD BOOK");
        addBtn.setBounds(140, 250, 150, 30);
        addBtn.addActionListener(this);
        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(l4); add(t4);
        add(addBtn);
    }
    void setupSearchUI() {
        sl1 = new Label("Enter Book No:");
        sl1.setBounds(330, 80, 100, 25);
        st1 = new TextField();
        st1.setBounds(440, 80, 100, 25);
        searchBtn = new Button("SEARCH");
        searchBtn.setBounds(440, 120, 100, 30);
        searchBtn.addActionListener(this);
        resultArea = new TextArea();
        resultArea.setBounds(330, 170, 210, 200);
        add(sl1); add(st1); add(searchBtn); add(resultArea);
    }
    void setupModifyUI() {
        ml1 = new Label("Book No:");
        ml1.setBounds(50, 320, 80, 25);
        mt1 = new TextField();
        mt1.setBounds(140, 320, 150, 25);
        searchModBtn = new Button("SEARCH");
        searchModBtn.setBounds(300, 320, 80, 30);
        searchModBtn.addActionListener(this);
        ml2 = new Label("New Name:");
        ml2.setBounds(50, 360, 80, 25);
        mt2 = new TextField();
        mt2.setBounds(140, 360, 150, 25);
        ml3 = new Label("New Author:");
        ml3.setBounds(50, 400, 80, 25);
        mt3 = new TextField();
        mt3.setBounds(140, 400, 150, 25);
        ml4 = new Label("New Price:");
        ml4.setBounds(50, 440, 80, 25);
        mt4 = new TextField();
        mt4.setBounds(140, 440, 150, 25);
        modifyBtn = new Button("MODIFY");
        modifyBtn.setBounds(140, 480, 150, 30);
        modifyBtn.addActionListener(this);
        add(ml1); add(mt1); add(searchModBtn);
        add(ml2); add(mt2); add(ml3); add(mt3);
        add(ml4); add(mt4); add(modifyBtn);
    }
    void hideAll() {
        Component[] comp = getComponents();
        for (Component c : comp)
            c.setVisible(false);
    }
    void showAddUI() {
        hideAll();
        l1.setVisible(true); t1.setVisible(true);
        l2.setVisible(true); t2.setVisible(true);
        l3.setVisible(true); t3.setVisible(true);
        l4.setVisible(true); t4.setVisible(true);
        addBtn.setVisible(true);
    }
    void showSearchUI() {
        hideAll();
        sl1.setVisible(true); st1.setVisible(true);
        searchBtn.setVisible(true); resultArea.setVisible(true);
    }
    void showModifyUI() {
        hideAll();
        ml1.setVisible(true); mt1.setVisible(true);
        searchModBtn.setVisible(true);
        ml2.setVisible(true); mt2.setVisible(true);
        ml3.setVisible(true); mt3.setVisible(true);
        ml4.setVisible(true); mt4.setVisible(true);
        modifyBtn.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addItem) showAddUI();
        if (e.getSource() == searchItem) showSearchUI();
        if (e.getSource() == modifyItem) showModifyUI();
        if (e.getSource() == addBtn) {
            if (count < 10) {
                books[count].bno = Integer.parseInt(t1.getText());
                books[count].name = t2.getText();
                books[count].author = t3.getText();
                books[count].price = Float.parseFloat(t4.getText());
                count++;
                System.out.println("Book Added Successfully!");
            } else {
                System.out.println("Only 10 books allowed!");
            }
        }
        if (e.getSource() == searchBtn) {
            int bn = Integer.parseInt(st1.getText());
            resultArea.setText("");

            for (int i = 0; i < count; i++) {
                if (books[i].bno == bn) {
                    resultArea.append("Book No: " + books[i].bno +
                            "\nName: " + books[i].name +
                            "\nAuthor: " + books[i].author +
                            "\nPrice: " + books[i].price);
                    return;
                }
            }
            resultArea.setText("Book Not Found!");
        }
        if (e.getSource() == searchModBtn) {
            int bn = Integer.parseInt(mt1.getText());
            for (int i = 0; i < count; i++) {
                if (books[i].bno == bn) {
                    mt2.setText(books[i].name);
                    mt3.setText(books[i].author);
                    mt4.setText("" + books[i].price);
                    return;
                }
            }
            System.out.println("Book Not Found!");
        }
        if (e.getSource() == modifyBtn) {
            int bn = Integer.parseInt(mt1.getText());
            for (int i = 0; i < count; i++) {
                if (books[i].bno == bn) {
                    books[i].name = mt2.getText();
                    books[i].author = mt3.getText();
                    books[i].price = Float.parseFloat(mt4.getText());
                    System.out.println("Book Modified Successfully!");
                    return;
                }
            }
            System.out.println("Book Not Found!");
        }
    }
    public static void main(String[] args) {
        new LibraryGUI();
    }
}