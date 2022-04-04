package com.lukamaret.course.ihm.projetTP.seance2.view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class ManipulationDateInterface extends JFrame {

    public ManipulationDateInterface() {
        this.setTitle("Manipulation Date");
        this.setSize(600, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LocalDateTime date = LocalDateTime.now();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());
        JLabel label = new JLabel("Aujourd'hui nous sommes le " + date.getDayOfMonth() + " " + date.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE) + " et il est " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond());
        label.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label);
        panel.add(Box.createVerticalGlue());

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel2.add(Box.createHorizontalGlue());
        label = new JLabel("Dans ");
        panel2.add(label);
        JTextField textField = new JTextField("10", 5);
        textField.setMaximumSize(new Dimension(20, 20));
        panel2.add(textField);
        label = new JLabel(" jours, on sera le ");
        panel2.add(label);
        JButton btn = new JButton("Cliquez pour découvrir !");
        panel2.add(btn);
        date = date.plusDays(10);
        label = new JLabel(date.getDayOfMonth() + " " + date.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE) + " " + date.getYear());
        panel2.add(label);
        panel2.add(Box.createHorizontalGlue());
        panel.add(panel2);
        panel.add(Box.createVerticalGlue());

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        panel3.add(Box.createHorizontalGlue());
        label = new JLabel("Dans ");
        panel3.add(label);
        textField = new JTextField("10", 5);
        textField.setMaximumSize(new Dimension(20, 20));
        panel3.add(textField);
        label = new JLabel(" heures, il sera ");
        panel3.add(label);
        btn = new JButton("Cliquez pour découvrir !");
        panel3.add(btn);
        date = date.minusDays(10);
        date = date.plusHours(10);
        label = new JLabel(date.getHour() + ":" + date.getMinute() + ":" + date.getSecond());
        panel3.add(label);
        panel3.add(Box.createHorizontalGlue());

        panel.add(panel3);
        panel.add(Box.createVerticalGlue());

        this.add(panel);
        this.setVisible(true);
    }

}
