package com.lukamaret.course.ihm.projetTP.seance3.view;

import com.lukamaret.course.ihm.projetTP.seance3.ManipulationDate;

import javax.swing.*;
import java.awt.*;

public class ManipulationDateInterface extends JFrame {

    private final JTextField field1 = new JTextField();
    private final JTextField field2 = new JTextField();
    private final JLabel output1 = new JLabel();
    private final JLabel output2 = new JLabel();

    public ManipulationDateInterface() {
        this.setTitle("Manipulation Date");
        this.setSize(600, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        build();
    }

    private void build() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());
        JLabel label = new JLabel("Aujourd'hui nous sommes le " + new ManipulationDate().printDateTime());
        label.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label);
        panel.add(Box.createVerticalGlue());

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel2.add(Box.createHorizontalGlue());
        label = new JLabel("Dans ");
        panel2.add(label);
        field1.setMaximumSize(new Dimension(10000, 20));
        panel2.add(field1);
        label = new JLabel(" jours, on sera le ");
        panel2.add(label);
        JButton btn = new JButton("Cliquez pour découvrir !");
        btn.addActionListener(e -> this.setResult1(new ManipulationDate().addDays(Integer.parseInt(this.field1.getText()))));
        panel2.add(btn);
        panel2.add(output1);
        panel2.add(Box.createHorizontalGlue());
        panel.add(panel2);
        panel.add(Box.createVerticalGlue());

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        panel3.add(Box.createHorizontalGlue());
        label = new JLabel("Dans ");
        panel3.add(label);
        field2.setMaximumSize(new Dimension(10000, 20));
        panel3.add(field2);
        label = new JLabel(" heures, il sera ");
        panel3.add(label);
        btn = new JButton("Cliquez pour découvrir !");
        btn.addActionListener(e -> this.setResult2(new ManipulationDate().addHours(Integer.parseInt(this.field2.getText()))));
        panel3.add(btn);
        panel3.add(output2);
        panel3.add(Box.createHorizontalGlue());

        panel.add(panel3);
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    public void setResult1(String result1) {
        output1.setText(result1);
        output1.updateUI();
    }

    public void setResult2(String result2) {
        output2.setText(result2);
        output2.updateUI();
    }

}
