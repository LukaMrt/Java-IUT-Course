package com.lukamaret.course.ihm.projetTD.seance3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnPanel extends JPanel implements ActionListener {

    public BtnPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JButton btn = new JButton("Ici");
        btn.addActionListener(e -> System.out.println("Ici !"));
        btn.addActionListener(new Interne("Ici !"));
        btn.addActionListener(this);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ici !");
            }
        });
        add(btn);

        add(Box.createGlue());

        btn = new JButton("Là");
        btn.addActionListener(e -> System.out.println("Là !"));
        btn.addActionListener(new Interne("Là !"));
        btn.addActionListener(this);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Là !");
            }
        });
        add(btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).getText().equals("Ici")) {
            System.out.println("Ici !");
        }

        if (((JButton) e.getSource()).getText().equals("Là")) {
            System.out.println("Là !");
        }
    }

    private class Interne implements ActionListener {

        private final String text;

        private Interne(String text) {
            this.text = text;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(text);
        }

    }

}
