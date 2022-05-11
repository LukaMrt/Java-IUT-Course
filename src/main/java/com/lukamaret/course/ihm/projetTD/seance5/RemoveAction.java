package com.lukamaret.course.ihm.projetTD.seance5;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RemoveAction extends AbstractAction {

    private final ModeleCBString comboBox;

    public RemoveAction(ModeleCBString comboBox) {
        this.comboBox = comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        comboBox.effaceElement(comboBox.getSelectedItem().toString());
    }

}
