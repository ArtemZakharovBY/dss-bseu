package by.bseu.dss.presentationlayer.reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reader extends JFrame{
    JButton b1, b2;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2;
    int i, k;
    String a, b;

    public Reader(String s){
        super(s);
        setLayout(new FlowLayout());
        b1 = new JButton("Write a name of criteria: ");
        b2 = new JButton("Delete");
        l1 = new JLabel("Write: 1");
        l2 = new JLabel("Write: 2");
        l3 = new JLabel("Write: 3");
        l4 = new JLabel("Write: 4");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        add(b1);
        add(b2);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(l4);

    }
}
