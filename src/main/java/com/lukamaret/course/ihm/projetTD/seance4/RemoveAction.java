package com.lukamaret.course.ihm.projetTD.seance4;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RemoveAction extends AbstractAction {

    private final JComboBox<String> comboBox;

    public RemoveAction(JComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        comboBox.removeItem(comboBox.getSelectedItem());
    }
}
