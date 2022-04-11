package com.lukamaret.course.ihm.projetTD.seance3;

import javax.swing.*;

public class CalcFrame extends JFrame {

    public CalcFrame() {
        super("Calculatrice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setContentPane(new CalcPanel());
        setVisible(true);
    }

}
