package com.lukamaret.course.ihm.projetTP.seance5.action;

import com.lukamaret.course.ihm.projetTP.seance5.model.ModeleComboPlayword;
import com.lukamaret.course.ihm.projetTP.seance5.view.PlayWordInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CopyToComboAction extends AbstractAction {

    private final PlayWordInterface frame;
    private final int index;

    public CopyToComboAction(PlayWordInterface frame, int index) {
        this.frame = frame;
        this.index = index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ModeleComboPlayword comboBox = frame.getBaseCombo();
        ModeleComboPlayword destination = frame.getComboBox(index);

        String selectedItem = (String) comboBox.getSelectedItem();

        if (selectedItem == null || selectedItem.isEmpty()) {
            return;
        }

        destination.ajDebutEtSelec(selectedItem);
        comboBox.supprSelectionne();
        destination.setSelectedItem(selectedItem);
        frame.pushAction(destination);
    }

}
