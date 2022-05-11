package com.lukamaret.course.ihm.projetTP.seance4.view;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class PlayWordInterface extends JFrame {

    private final Stack<JComboBox<String>> actions = new Stack<>();
    private final JMenuItem cancelAction = new JMenuItem("Cancel last operation");
    private final JComboBox<String> comboBox1 = new JComboBox<>();
    private final JComboBox<String> comboBox2 = new JComboBox<>();
    private final JComboBox<String> comboBox3 = new JComboBox<>();
    private final JComboBox<String> comboBox4 = new JComboBox<>();

    public PlayWordInterface() {
        this.setTitle("Playing with English Words !");
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Copy operations");
        JMenuItem menuItem = new JMenuItem("Copy to professions");
        menuItem.addActionListener(e -> copyTo(comboBox2));
        menu.add(menuItem);
        menuItem = new JMenuItem("Copy to Indoor Hobbies");
        menuItem.addActionListener(e -> copyTo(comboBox3));
        menu.add(menuItem);
        menuItem = new JMenuItem("Copy to Outdoor Hobbies");
        menuItem.addActionListener(e -> copyTo(comboBox4));
        menu.add(menuItem);
        menuBar.add(menu);
        menu = new JMenu("Cancel & Quit");
        cancelAction.setEnabled(false);
        cancelAction.addActionListener(e -> copyFrom(actions.pop()));
        menu.add(cancelAction);
        menuItem = new JMenuItem("Quit");
        menuItem.addActionListener(e -> System.exit(0));
        menu.add(menuItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        JLabel label = new JLabel("Put each word of the first combo box into the corresponding category.");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        panel.add(Box.createGlue());

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        panel3.add(Box.createHorizontalGlue());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 4));

        label = new JLabel("Words");
        panel2.add(label);
        label = new JLabel("Professions");
        panel2.add(label);
        label = new JLabel("Indoor Hobbies");
        panel2.add(label);
        label = new JLabel("Outdoor Hobbies");
        panel2.add(label);

        comboBox1.addItem("Geocaching");
        comboBox1.addItem("Scutelliphily");
        comboBox1.addItem("Alnager");
        comboBox1.addItem("Mixology");
        comboBox1.addItem("Catchpole");
        comboBox1.addItem("Topiary");
        panel2.add(comboBox1);

        panel2.add(comboBox2);
        panel2.add(comboBox3);
        panel2.add(comboBox4);

        panel2.add(new JPanel());

        JButton button = new JButton("Copy here");
        button.addActionListener(e -> copyTo(comboBox2));
        panel2.add(button);

        button = new JButton("Copy here");
        button.addActionListener(e -> copyTo(comboBox3));
        panel2.add(button);

        button = new JButton("Copy here");
        button.addActionListener(e -> copyTo(comboBox4));
        panel2.add(button);

        panel3.add(panel2);
        panel3.add(Box.createGlue());
        panel.add(panel3);
        panel.add(Box.createVerticalGlue());

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.RED);
        panel4.setLayout(new GridLayout(2, 3));

        label = new JLabel("Professions");
        panel4.add(label);
        label = new JLabel("Indoor Hobbies");
        panel4.add(label);
        label = new JLabel("Outdoor Hobbies");
        panel4.add(label);

        JComboBox<String> comboBox5 = new JComboBox<>();
        comboBox5.addItem("Alnager");
        panel4.add(comboBox5);

        comboBox5 = new JComboBox<>();
        comboBox5.addItem("Scutelliphily");
        comboBox5.addItem("Mixology");
        panel4.add(comboBox5);

        comboBox5 = new JComboBox<>();
        comboBox5.addItem("Geocaching");
        comboBox5.addItem("Catchpole");
        comboBox5.addItem("Topiary");
        panel4.add(comboBox5);

        final JButton btn = new JButton("Show me the solution");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.addActionListener(e -> {
            panel.remove(btn);
            panel.add(panel4);
            panel.updateUI();
        });
        panel.add(btn);

        add(panel);
        setVisible(true);
    }

    private void copyTo(JComboBox<String> destination) {
        String selectedItem = (String) comboBox1.getSelectedItem();
        if (selectedItem == null || selectedItem.isEmpty()) {
            return;
        }
        destination.addItem(selectedItem);
        comboBox1.removeItem(selectedItem);
        destination.setSelectedItem(selectedItem);

        actions.push(destination);
        cancelAction.setEnabled(true);
    }

    private void copyFrom(JComboBox<String> source) {
        String selectedItem = (String) source.getSelectedItem();
        if (selectedItem == null || selectedItem.isEmpty()) {
            return;
        }
        comboBox1.addItem(selectedItem);
        source.removeItem(selectedItem);
        comboBox1.setSelectedItem(selectedItem);
        cancelAction.setEnabled(actions.size() > 0);
    }

}
