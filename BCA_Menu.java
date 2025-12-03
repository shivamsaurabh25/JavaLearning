import java.awt.*;
import java.awt.event.*;
class BCA_Menu {
    Frame fr;
    MenuBar mb;
    Menu m1, m2, m3;
    MenuItem mi1, mi2, mi3, mi4, mi5, mi6;
    MenuShortcut ms;
    BCA_Menu() {
        fr = new Frame("BCA Notepad");
        mb = new MenuBar();
        m1 = new Menu("File");
        m2 = new Menu("Save");
        m3 = new Menu("Edit");
        mi1 = new MenuItem("New");
        mi2 = new MenuItem("Open");
        m1.add(mi1);
        m1.add(mi2);
        mi3 = new MenuItem("Save as");
        mi4 = new MenuItem("Save as webpage");
        m2.add(mi3);
        m2.add(mi4);
        mi5 = new MenuItem("Cut");
        ms = new MenuShortcut(KeyEvent.VK_C, true);
        mi6 = new MenuItem("Copy", ms);
        m3.add(mi5);
        m3.add(mi6);
        fr.setMenuBar(mb);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        fr.setSize(300, 300);
        fr.setLayout(null);
        fr.setVisible(true);
    }
    public static void main(String args[]) {
        new BCA_Menu();
    }
}