package com.lukamaret.course.ihm.projetTD.seance5;

import javax.swing.*;

public class MyJFrame extends JFrame {

    public MyJFrame() {

        setTitle("Fenêtre permettant de copier");
        setSize(500, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(new MyJPanel());
        setVisible(true);

    }

}
