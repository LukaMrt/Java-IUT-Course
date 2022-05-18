package com.lukamaret.course.ihm.projetTD.seance7;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MyJFrame extends JFrame {

    private final JLabel codeLabel = new JLabel("Code du module : ");
    private final JLabel numLabel = new JLabel("Numéro du cours : ");

    public MyJFrame() {

        this.setTitle("Cours");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());

        JPanel superPanel = new JPanel();
        superPanel.setLayout(new BoxLayout(superPanel, BoxLayout.X_AXIS));
        superPanel.add(Box.createHorizontalGlue());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());
        JLabel label = new JLabel("Enregistrement : ");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        panel.add(Box.createVerticalGlue());
        label = new JLabel("Code du module");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        JTextField code = new JTextField();
        code.setAlignmentX(Component.CENTER_ALIGNMENT);
        code.setPreferredSize(new Dimension(200, 20));
        code.setMaximumSize(new Dimension(200, 20));
        panel.add(code);
        panel.add(Box.createVerticalGlue());
        label = new JLabel("Numéro du cours");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        JTextField num = new JTextField();
        num.setAlignmentX(Component.CENTER_ALIGNMENT);
        num.setPreferredSize(new Dimension(200, 20));
        num.setMaximumSize(new Dimension(200, 20));
        panel.add(num);
        panel.add(Box.createVerticalGlue());
        JButton button = new JButton("Enregistrer");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> write(code.getText(), num.getText()));
        panel.add(button);
        panel.add(Box.createVerticalGlue());
        superPanel.add(panel);

        superPanel.add(Box.createHorizontalGlue());

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(Box.createVerticalGlue());
        JLabel label2 = new JLabel("Lecture : ");
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(label2);
        panel2.add(Box.createVerticalGlue());
        codeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(codeLabel);
        panel2.add(Box.createVerticalGlue());
        numLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(numLabel);
        panel2.add(Box.createVerticalGlue());
        JButton button2 = new JButton("Lire");
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.addActionListener(e -> read(superPanel));
        panel2.add(button2);
        panel2.add(Box.createVerticalGlue());
        superPanel.add(panel2);

        superPanel.add(Box.createHorizontalGlue());
        this.add(superPanel);

        this.setVisible(true);

    }

    private void write(String code, String num) {

        Cours cours = new Cours();
        cours.setCodeModule(code);
        cours.setNumCours(num);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cours.txt"));
            oos.writeObject(cours);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void read(JPanel panel) {

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cours.txt"));
            Cours cours = (Cours) ois.readObject();
            this.codeLabel.setText("Code du module : " + cours.getCodeModule());
            this.numLabel.setText("Numéro du cours : " + cours.getNumCours());
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        panel.updateUI();
    }

}
