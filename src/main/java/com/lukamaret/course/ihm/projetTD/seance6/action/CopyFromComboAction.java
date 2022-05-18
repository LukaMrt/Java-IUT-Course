package com.lukamaret.course.ihm.projetTD.seance6.action;

import com.lukamaret.course.ihm.projetTD.seance6.model.ModeleComboPlayword;
import com.lukamaret.course.ihm.projetTD.seance6.view.PlayWordInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CopyFromComboAction extends AbstractAction {

    private final PlayWordInterface frame;

    public CopyFromComboAction(PlayWordInterface frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ModeleComboPlayword comboBox = frame.getBaseCombo();
        ModeleComboPlayword source = frame.popAction();


        String selectedItem = (String) source.getSelectedItem();
        if (selectedItem == null || selectedItem.isEmpty()) {
            return;
        }

        comboBox.ajDebutEtSelec(selectedItem);
        source.supprSelectionne();
        comboBox.setSelectedItem(selectedItem);
    }

}
