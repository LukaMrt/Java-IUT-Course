package com.lukamaret.course.ihm.projetTD.seance3;

import javax.swing.*;

public class BtnFrame extends JFrame {

    public BtnFrame() {
        setTitle("Boutons");
        setSize(300, 60);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(new BtnPanel());
        setVisible(true);
    }

}
