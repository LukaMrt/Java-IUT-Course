package com.lukamaret.course.ihm.projetTD.seance3;

import javax.swing.*;
import java.awt.*;

public class CalcPanel extends JPanel {

    public CalcPanel() {

        setLayout(new GridLayout(4, 4));

        JButton btn1 = new JButton("1");
        btn1.addActionListener(e -> System.out.println("1"));
        JButton btn2 = new JButton("2");
        btn2.addActionListener(e -> System.out.println("2"));
        JButton btn3 = new JButton("3");
        btn3.addActionListener(e -> System.out.println("3"));
        JButton btn4 = new JButton("4");
        btn4.addActionListener(e -> System.out.println("4"));
        JButton btn5 = new JButton("5");
        btn5.addActionListener(e -> System.out.println("5"));
        JButton btn6 = new JButton("6");
        btn6.addActionListener(e -> System.out.println("6"));
        JButton btn7 = new JButton("7");
        btn7.addActionListener(e -> System.out.println("7"));
        JButton btn8 = new JButton("8");
        btn8.addActionListener(e -> System.out.println("8"));
        JButton btn9 = new JButton("9");
        btn9.addActionListener(e -> System.out.println("9"));
        JButton btn0 = new JButton("0");
        btn0.addActionListener(e -> System.out.println("0"));
        JButton btnPlus = new JButton("+");
        JButton btnMoins = new JButton("-");
        JButton btnMult = new JButton("*");
        JButton btnDiv = new JButton("/");
        JButton btnEgal = new JButton("=");
        JButton btnPoint = new JButton(".");

        add(btnPlus);
        add(btnMoins);
        add(btnMult);
        add(btnDiv);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        add(btn8);
        add(btn9);
        add(btn0);
        add(btnPoint);
        add(btnEgal);

    }

}
