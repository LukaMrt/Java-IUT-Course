package com.lukamaret.course.ihm.projetTD.seance4;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ClearAction extends AbstractAction {

    private final JComboBox<String> comboBox;

    public ClearAction(JComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        comboBox.setSelectedItem(null);
    }

}
