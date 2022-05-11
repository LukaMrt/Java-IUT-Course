package com.lukamaret.course.ihm.projetTP.seance4.view;

import com.lukamaret.course.ihm.projetTP.seance2.StringMoteur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StringMoteurInterface extends JFrame implements ActionListener {

    private String result = "";
    private final JTextField field = new JTextField();

    public StringMoteurInterface() {
        this.setTitle("StringMoteur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        build();
    }

    private void build() {
        getContentPane().removeAll();

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

        JButton btn = new JButton("MAJUSCULES");
        btn.addActionListener(new UppercaseListener(this, field));
        panel3.add(btn);

        panel3.add(Box.createHorizontalGlue());

        btn = new JButton("minuscules");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setResult(new StringMoteur().lowerCase(field.getText()));
            }
        });
        panel3.add(btn);

        panel3.add(Box.createHorizontalGlue());

        btn = new JButton("AjoutDébut");
        btn.addActionListener(this);
        panel3.add(btn);

        panel3.add(Box.createHorizontalGlue());

        btn = new JButton("AjoutFin");
        btn.addActionListener(e -> this.setResult(new StringMoteur().addAtEnd(getResult(), field.getText())));
        panel3.add(btn);

        panel3.add(Box.createHorizontalGlue());

        btn = new JButton("AfficheMots");
        btn.addActionListener(new PrintWords(this, field));
        panel3.add(btn);

        panel3.add(Box.createHorizontalGlue());

        btn = new JButton("TailleSansEspaces");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setResult(new StringMoteur().sizeWithoutSpace(field.getText()));
            }
        });
        panel3.add(btn);

        panel3.add(Box.createHorizontalGlue());

        btn = new JButton("CalculSimple");
        btn.addActionListener(this);
        panel3.add(btn);

        panel3.add(Box.createHorizontalGlue());

        btn = new JButton("InitialesEnMajuscules");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setResult(new StringMoteur().capitalizeWords(field.getText()));
            }
        });
        panel3.add(btn);

        panel3.add(Box.createHorizontalGlue());

        btn = new JButton("Quitter");
        btn.addActionListener(e -> System.exit(0));
        panel3.add(btn);

        panel3.add(Box.createHorizontalGlue());

        panel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(panel3);

        panel.add(Box.createVerticalGlue());
        panel.add(Box.createVerticalGlue());
        panel.add(Box.createVerticalGlue());

        JPanel panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
        panel4.add(new JLabel("Résultat : "));
        panel4.add(Box.createHorizontalGlue());
        panel4.add(new JLabel(result));

        panel.add(panel4);
        panel.add(Box.createVerticalGlue());

        panel.updateUI();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        build();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (((JButton) e.getSource()).getText()) {
            case "AjoutDébut" -> this.setResult(new StringMoteur().addAtStart(getResult(), field.getText()));
            case "CalculSimple" -> this.setResult(new StringMoteur().simpleOperation(field.getText()));
        }

    }

    private static class UppercaseListener implements ActionListener {

        private final StringMoteurInterface moteur;
        private final JTextField field;

        private UppercaseListener(StringMoteurInterface moteur, JTextField field) {
            this.moteur = moteur;
            this.field = field;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            moteur.setResult(new StringMoteur().upperCase(field.getText()));
        }

    }

    private static class PrintWords implements ActionListener {

        private final StringMoteurInterface moteur;
        private final JTextField field;

        private PrintWords(StringMoteurInterface moteur, JTextField field) {
            this.moteur = moteur;
            this.field = field;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            moteur.setResult(new StringMoteur().splitWordsWithComa(field.getText()));
        }

    }

}
