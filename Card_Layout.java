import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Card_Layout implements ActionListener {
    JFrame fr;
    Container co;
    CardLayout cl;
    Card_Layout() {
        fr = new JFrame("Card Layout");
        co = fr.getContentPane();
        cl = new CardLayout(20, 20);
        Button b1 = new Button("OK");
        Button b2 = new Button("Cancel");
        Button b3 = new Button("Print");
        co.add(b1);
        co.add(b2);
        co.add(b3);
        co.setLayout(cl);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        fr.setLayout(cl);
        fr.setSize(200, 200);
        fr.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        cl.next(co);
    }
    public static void main(String args[]) {
        new Card_Layout();
    }
}