package com.lukamaret.course.ihm.projetTP.seance2.view;

import javax.swing.*;
import java.awt.*;

public class StringFenetrePrincipale extends JFrame {

    public StringFenetrePrincipale() {
        this.setTitle("Jouons avec les mots !");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setSize(500, 400);
        panel.add(Box.createVerticalGlue());
        this.add(panel);
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        JLabel label = new JLabel("Bienvenue sur l'application de manipulation des chaînes de caractères !", SwingConstants.CENTER);
        label.setMaximumSize(new Dimension(450, 400));
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(label);
        label = new JLabel("Cliquez sur l'activité de votre choix.", SwingConstants.CENTER);
        label.setMaximumSize(new Dimension(450, 400));
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(label);
        panel.add(Box.createVerticalGlue());

        JButton btn = new JButton("Opérations sur les chaînes de caractères");
        btn.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(btn);

        panel.add(Box.createVerticalGlue());

        btn = new JButton("Manipulation de dates et d'heures");
        btn.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(btn);

        panel.add(Box.createVerticalGlue());


        btn = new JButton("Playing with English words");
        btn.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(btn);

        panel.add(Box.createVerticalGlue());

        this.setVisible(true);
    }

}
