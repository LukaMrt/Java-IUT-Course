package com.lukamaret.course.ihm.projetTD.seance5;

import javax.swing.*;

public class MyJPanel extends JPanel {

    public MyJPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JComboBox<String> comboBox1 = new JComboBox<>();
        JComboBox<String> comboBox2 = new JComboBox<>();
        ModeleCBString modele1 = new ModeleCBString("Élément 1", "Élément 2", "Élément 3");
        ModeleCBString modele2 = new ModeleCBString();
        comboBox1.setModel(modele1);
        comboBox2.setModel(modele2);

        add(buildMenu(modele1, modele2));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        add(panel1);

        panel1.add(comboBox1);
        panel1.add(comboBox2);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        add(panel2);

    }

    private JMenuBar buildMenu(ModeleCBString comboBox1, ModeleCBString comboBox2) {
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
