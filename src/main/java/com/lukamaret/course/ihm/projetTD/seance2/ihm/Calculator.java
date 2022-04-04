package com.lukamaret.course.ihm.projetTD.seance2.ihm;

import javax.swing.*;

public class Calculator extends JFrame {

    public Calculator() {

        this.setTitle("Composition de Dispositions");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(new Panel());
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    }

    public void display() {
        this.setVisible(true);
    }

}
