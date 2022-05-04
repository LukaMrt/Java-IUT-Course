package com.lukamaret.course.ihm.projetTD.seance4;

import javax.swing.*;

public class MyJPanel extends JPanel {

    public MyJPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JComboBox<String> comboBox1 = new JComboBox<>();
        JComboBox<String> comboBox2 = new JComboBox<>();

        add(buildMenu(comboBox1, comboBox2));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        add(panel1);

        comboBox1.addItem("Élément 1");
        comboBox1.addItem("Élément 2");
        comboBox1.addItem("Élément 3");

        panel1.add(comboBox1);
        panel1.add(comboBox2);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        add(panel2);

    }

    private JMenuBar buildMenu(JComboBox<String> comboBox1, JComboBox<String> comboBox2) {
        JMenu menu = new JMenu("Menu");
        JMenuItem item = new JMenuItem("Copier");
        item.addActionListener(new CopyAction(comboBox1, comboBox2));
        menu.add(item);

        item = new JMenuItem("Enlever");
        item.addActionListener(new RemoveAction(comboBox2));
        menu.add(item);

        item = new JMenuItem("Vider");
        item.addActionListener(new ClearAction(comboBox2));
        menu.add(item);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        return menuBar;
    }

}
