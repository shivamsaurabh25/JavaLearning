import java.awt.*;
import java.awt.event.*;
class Restaurant implements ItemListener, ActionListener {
    Frame fr;
    Label l1, l2, l3;
    Checkbox c1, c2, c3;
    Button b1, b2, b3;
    int s = 0;
    Restaurant(){
        fr = new Frame("ABC Restaurant");
        l1 = new Label("Item List");
        c1 = new Checkbox("Paneer Chilli(120)");
        c2 = new Checkbox("Mushroom(180)");
        c3 = new Checkbox("Chowmin(80)");
        l2 = new Label("Payment");
        l3 = new Label(" ");
        b1 = new Button("Calculate");
        b2 = new Button("Clear");
        b3 = new Button("Close");
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        l1.setBounds(150, 40, 100, 40);
        c1.setBounds(30, 100, 150, 40);
        c2.setBounds(30, 160, 150, 40);
        c3.setBounds(30, 220, 150, 40);
        l2.setBounds(60, 280, 100, 40);
        l3.setBounds(180, 280, 100, 40);
        b1.setBounds(50, 350, 100, 40);
        b2.setBounds(170, 350, 100, 40);
        b3.setBounds(290, 350, 100, 40);
        fr.add(l1); fr.add(c1); fr.add(c2); fr.add(c3);
        fr.add(l2); fr.add(l3);
        fr.add(b1); fr.add(b2); fr.add(b3);
        fr.setLayout(null);
        fr.setSize(500,500);
        fr.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            if(c1.getState() == true){
                s = s + 120;
            }
            if(c2.getState() == true){
                s = s + 180;
            }
            if(c3.getState() == true){
                s = s + 80;
            }
            l3.setText(String.valueOf(s));
        }
        if(e.getSource()==b2){
            s = 0;
            l3.setText(" ");
            c1.setState(false);
            c2.setState(false);
            c3.setState(false);
        }
        if(e.getSource()==b3){
            fr.dispose();
        }
    }
    public void itemStateChanged(ItemEvent e){}
    public static void main(String[] args) {
        new Restaurant();
    }
}