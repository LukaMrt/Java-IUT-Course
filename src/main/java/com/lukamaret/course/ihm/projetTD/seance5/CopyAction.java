package com.lukamaret.course.ihm.projetTD.seance5;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CopyAction extends AbstractAction {

    private final ModeleCBString comboBox1;
    private final ModeleCBString comboBox2;

    public CopyAction(ModeleCBString comboBox1, ModeleCBString comboBox2) {
        this.comboBox1 = comboBox1;
        this.comboBox2 = comboBox2;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        comboBox2.effaceElement(comboBox1.getSelectedItem().toString());
        comboBox2.ajoutElement(comboBox1.getSelectedItem().toString());
        comboBox2.setSelectedItem(comboBox1.getSelectedItem());
    }

}
