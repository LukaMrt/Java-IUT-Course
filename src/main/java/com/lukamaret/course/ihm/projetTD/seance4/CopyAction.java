package com.lukamaret.course.ihm.projetTD.seance4;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CopyAction extends AbstractAction {

    private final JComboBox<String> comboBox1;
    private final JComboBox<String> comboBox2;

    public CopyAction(JComboBox<String> comboBox1, JComboBox<String> comboBox2) {
        this.comboBox1 = comboBox1;
        this.comboBox2 = comboBox2;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        comboBox2.removeItem(comboBox1.getSelectedItem());
        comboBox2.addItem((String) comboBox1.getSelectedItem());
        comboBox2.setSelectedItem(comboBox1.getSelectedItem());
    }

}
