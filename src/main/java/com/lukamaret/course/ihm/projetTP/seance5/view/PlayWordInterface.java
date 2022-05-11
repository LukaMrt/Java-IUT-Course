package com.lukamaret.course.ihm.projetTP.seance5.view;

import com.lukamaret.course.ihm.projetTP.seance5.action.CopyFromComboAction;
import com.lukamaret.course.ihm.projetTP.seance5.action.CopyToComboAction;
import com.lukamaret.course.ihm.projetTP.seance5.model.ModeleComboPlayword;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class PlayWordInterface extends JFrame {

    private final Stack<ModeleComboPlayword> actions = new Stack<>();
    private final JMenuItem cancelAction = new JMenuItem("Cancel last operation");
    private final ModeleComboPlayword comboBox1 = new ModeleComboPlayword("Geocaching", "Geocaching", "Scutelliphily", "Alnager", "Mixology", "Catchpole", "Topiary");
    private final ModeleComboPlayword comboBox2 = new ModeleComboPlayword();
    private final ModeleComboPlayword comboBox3 = new ModeleComboPlayword();
    private final ModeleComboPlayword comboBox4 = new ModeleComboPlayword();

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
        menuItem.addActionListener(new CopyToComboAction(this, 2));
        menu.add(menuItem);
        menuItem = new JMenuItem("Copy to Indoor Hobbies");
        menuItem.addActionListener(new CopyToComboAction(this, 3));
        menu.add(menuItem);
        menuItem = new JMenuItem("Copy to Outdoor Hobbies");
        menuItem.addActionListener(new CopyToComboAction(this, 4));
        menu.add(menuItem);
        menuBar.add(menu);
        menu = new JMenu("Cancel & Quit");
        cancelAction.setEnabled(false);
        cancelAction.addActionListener(new CopyFromComboAction(this));
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

        JComboBox<String> comboBox = new JComboBox<>(comboBox1);
        panel2.add(comboBox);
        comboBox1.elimCopies();

        comboBox = new JComboBox<>(comboBox2);
        panel2.add(comboBox);

        comboBox = new JComboBox<>(comboBox3);
        panel2.add(comboBox);

        comboBox = new JComboBox<>(comboBox4);
        panel2.add(comboBox);

        panel2.add(new JPanel());

        JButton button = new JButton("Copy here");
        button.addActionListener(new CopyToComboAction(this, 2));
        panel2.add(button);

        button = new JButton("Copy here");
        button.addActionListener(new CopyToComboAction(this, 3));
        panel2.add(button);

        button = new JButton("Copy here");
        button.addActionListener(new CopyToComboAction(this, 4));
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

    public ModeleComboPlayword getBaseCombo() {
        return this.comboBox1;
    }

    public ModeleComboPlayword getComboBox(int index) {
        return switch (index) {
            case 3 -> this.comboBox3;
            case 4 -> this.comboBox4;
            default -> this.comboBox2;
        };
    }

    public void pushAction(ModeleComboPlayword destination) {
        actions.push(destination);
        cancelAction.setEnabled(true);
    }

    public ModeleComboPlayword popAction() {
        cancelAction.setEnabled(actions.size() > 1);
        return actions.pop();
    }

}
