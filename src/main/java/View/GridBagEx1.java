package View;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class GridBagEx1 extends JFrame {

    protected void makebutton(String name, GridBagLayout gridbag, GridBagConstraints c, JPanel p) {
        Button button = new Button(name);
        gridbag.setConstraints(button, c);
        p.add(button);
    }

    public GridBagEx1() throws HeadlessException {
        JPanel p = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        setFont(new Font("SansSerif", Font.PLAIN, 14));
        p.setLayout(gridbag);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        makebutton("Button1", gridbag, c, p);
        makebutton("Button2", gridbag, c,p);
        makebutton("Button3", gridbag, c,p);

        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        makebutton("Button4", gridbag, c,p);

        c.weightx = 0.0;                //reset to the default
        makebutton("Button5", gridbag, c,p); //another row

        c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last in row
        makebutton("Button6", gridbag, c,p);

        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        makebutton("Button7", gridbag, c,p);

        c.gridwidth = 1;                //reset to the default
        c.gridheight = 2;
        c.weighty = 1.0;
        makebutton("Button8", gridbag, c,p);

        c.weighty = 0.0;                //reset to the default
        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        c.gridheight = 1;               //reset to the default
        makebutton("Button9", gridbag, c,p);
        makebutton("Button10", gridbag, c,p);

        setSize(300, 100);


        setContentPane(p);
        setTitle("TestGrid");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String args[]) {JFrame f = new GridBagEx1();}
}
