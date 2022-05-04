package com.lukamaret.course.ihm.projetTD.seance3;

import javax.swing.*;
import java.awt.*;

public class CalcPanel extends JPanel {

    private String number = "";
    private boolean point = false;

    public CalcPanel() {

        setLayout(new GridLayout(4, 4));

        JButton btnPlus = new JButton("+");
        add(btnPlus);

        JButton btnMoins = new JButton("-");
        add(btnMoins);

        JButton btnMult = new JButton("*");
        add(btnMult);

        JButton btnDiv = new JButton("/");
        add(btnDiv);

        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i % 10));
            int finalI = i;
            btn.addActionListener(e -> {
                this.number += finalI % 10;
                System.out.println(this.number);
            });
            add(btn);
        }

        JButton btnPoint = new JButton(".");
        btnPoint.addActionListener(e -> {
            if (!point) {
                this.number += ".";
                point = true;
                System.out.println(this.number);
            }
        });
        add(btnPoint);

        JButton btnEgal = new JButton("=");
        add(btnEgal);
    }

}
