import java.awt.*;
import java.awt.event.*;
class Rad implements ItemListener{
    Frame fr;
    Label l1, l2, l3;
    Checkbox c1, c2, c3;
    CheckboxGroup cg;
    String str;
    Rad(){
        fr = new Frame("Radio Button");
        l1 = new Label("Gender");
        l2 = new Label("Gender Selected: ");
        l3 = new Label();
        cg = new CheckboxGroup();
        c1 = new Checkbox("Male", false, cg);
        c2 = new Checkbox("Female", false, cg);
        c3 = new Checkbox("Transgender", false, cg);
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
        l1.setBounds(20, 40, 80, 40);
        c1.setBounds(30, 100, 120, 40);
        c2.setBounds(30, 160, 120, 40);
        c3.setBounds(30, 220, 120, 40);
        l2.setBounds(30, 280, 200, 40);
        l3.setBounds(250, 280, 100, 40);
        fr.add(l1); fr.add(c1); fr.add(c2); fr.add(c3);
        fr.add(l2); fr.add(l3);
        fr.setLayout(null);
        fr.setSize(400, 400);
        fr.setVisible(true);
    }
    public void itemStateChanged(ItemEvent e){
        if(c1.getState() == true)
            str = "Male";
        if(c2.getState() == true)
            str = "Female";
        if(c3.getState() == true)
            str = "Transgender";
        l3.setText(str);
    }
    public static void main(String args[]){
        new Rad();
    }
}