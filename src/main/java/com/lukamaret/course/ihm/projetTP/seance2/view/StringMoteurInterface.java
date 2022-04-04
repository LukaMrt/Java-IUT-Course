package com.lukamaret.course.ihm.projetTP.seance2.view;

import javax.swing.*;
import java.awt.*;

public class StringMoteurInterface extends JFrame {

    public StringMoteurInterface() {
        super("StringMoteur");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.add(Box.createVerticalGlue());
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Pour réaliser une opération sur une chaînes de caractères, veuillez tout d'abord en entrer une avant d'appuyer sur le bouton correspondant à l'opération.");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        panel.add(Box.createVerticalGlue());

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel2.add(new JLabel("Entrez votre chaîne de caractères : "));
        panel2.add(Box.createHorizontalGlue());
        JTextField field = new JTextField();
        field.setMaximumSize(new Dimension(100000, 30));
        panel2.add(field);
        panel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(panel2);
        panel.add(Box.createVerticalGlue());

        label = new JLabel("Choisir l'opération : ");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel3.add(Box.createHorizontalGlue());
        panel3.add(new JButton("MAJUSCULES"));
        panel3.add(Box.createHorizontalGlue());
        panel3.add(new JButton("minuscules"));
        panel3.add(Box.createHorizontalGlue());
        panel3.add(new JButton("AjoutDébut"));
        panel3.add(Box.createHorizontalGlue());
        panel3.add(new JButton("AjoutFin"));
        panel3.add(Box.createHorizontalGlue());
        panel3.add(new JButton("AfficheMots"));
        panel3.add(Box.createHorizontalGlue());
        panel3.add(new JButton("TailleSansEspaces"));
        panel3.add(Box.createHorizontalGlue());
        panel3.add(new JButton("CalculSimple"));
        panel3.add(Box.createHorizontalGlue());
        panel3.add(new JButton("InitialesEnMajuscules"));
        panel3.add(Box.createHorizontalGlue());
        panel3.add(new JButton("Quitter"));
        panel3.add(Box.createHorizontalGlue());
        panel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(panel3);

        panel.add(Box.createVerticalGlue());
        panel.add(Box.createVerticalGlue());
        panel.add(Box.createVerticalGlue());

        JPanel panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
        panel4.add(new JLabel("Entrez votre chaîne de caractères : "));
        panel4.add(Box.createHorizontalGlue());
        panel4.add(new JLabel("Les Chaussettes De L'archiduchesse Sont Sèches"));
        panel.add(panel4);
        panel.add(Box.createVerticalGlue());

        this.setVisible(true);
    }

}
