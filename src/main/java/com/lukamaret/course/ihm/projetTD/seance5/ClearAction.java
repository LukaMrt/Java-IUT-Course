package com.lukamaret.course.ihm.projetTD.seance5;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ClearAction extends AbstractAction {

    private final ModeleCBString comboBox;

    public ClearAction(ModeleCBString comboBox) {
        this.comboBox = comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        comboBox.effaceTout();
    }

}
