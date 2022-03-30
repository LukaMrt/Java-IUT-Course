package com.lukamaret.course.ihm.projetTD.seance1.ihm;

import javax.swing.*;

public class Calculator extends JFrame {

    public Calculator() {

        this.setTitle("Calculatrice");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(new CalculatorPanel());
    }

    public void display() {
        this.setVisible(true);
    }

}
