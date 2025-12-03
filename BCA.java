/* import java.awt.*;
import java.awt.event.*;

class BCA implements ActionListener {
    Frame fr;
    Label l1, l2, l3, l4, l5;
    TextField t1, t2, t3, t4, t5;
    Button b1, b2, b3;
    String di;
    double pe;

    BCA() {
        fr = new Frame("Student");

        l1 = new Label("Roll");
        l2 = new Label("Name");
        l3 = new Label("Mobt");
        l4 = new Label("Div");
        l5 = new Label("Per");

        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t4 = new TextField();
        t5 = new TextField();

        b1 = new Button("Calculate");
        b2 = new Button("Clear");
        b3 = new Button("Close");

        l1.setBounds(20, 40, 100, 40);
        t1.setBounds(140, 40, 100, 40);
        l2.setBounds(20, 100, 100, 40);
        t2.setBounds(140, 100, 100, 40);
        l3.setBounds(20, 160, 100, 40);
        t3.setBounds(140, 160, 100, 40);
        l4.setBounds(20, 220, 100, 40);
        t4.setBounds(140, 220, 100, 40);
        l5.setBounds(20, 280, 100, 40);
        t5.setBounds(140, 280, 100, 40);

        b1.setBounds(50, 350, 100, 40);
        b2.setBounds(170, 350, 100, 40);
        b3.setBounds(100, 410, 100, 40);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        fr.add(l1); fr.add(t1);
        fr.add(l2); fr.add(t2);
        fr.add(l3); fr.add(t3);
        fr.add(l4); fr.add(t4);
        fr.add(l5); fr.add(t5);
        fr.add(b1); fr.add(b2); fr.add(b3);

        fr.setSize(500, 500);
        fr.setLayout(null);
        fr.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                int roll = Integer.parseInt(t1.getText());
                int m = Integer.parseInt(t3.getText());
                if (roll < 1 || roll > 120) {
                    clearFields();
                    return;
                }
                if (m >= 540) {
                    di = "First";
                } else if (m >= 480) {
                    di = "Second";
                } else if (m >= 420) {
                    di = "Third";
                } else {
                    di = "Fail";
                }

                pe = (m * 100) / 900.0;
                t4.setText(di);
                t5.setText(String.valueOf(pe));

            } catch (NumberFormatException ex) {
                clearFields();
            }
        }

        if (e.getSource() == b2) {
            clearFields();
        }

        if (e.getSource() == b3) {
            fr.dispose();
        }
    }

    private void clearFields() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
    }

    public static void main(String args[]) {
        new BCA();
    }
} */
/* import java.util.*;
class BCA {
    public static void main(String[] args) {
        LinkedList<String> li = new LinkedList<>();
        li.add("Java");
        li.add("Python");
        li.addFirst("C++");
        for(int i = 0; i < li.size(); i++)
            System.out.println(li.get(i));
        for(String st : li)
            System.out.println(st);
    }
} */
import java.util.*;
class BCA {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("BCA");
        al.add("MCA");
        al.add(1, "BBA");
        System.out.println(al);
        al.remove(0);
        System.out.println(al);
        al.set(1, "BBM");
        System.out.println(al);
    }
}