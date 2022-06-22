package com.lukamaret.course.ihm.projetTD.seance8;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

    private final JPanel panel;
    private final JTable table;
    private final TableModel model;
    private final JTextField textField;

    public MyMouseListener(JPanel panel, JTable table, TableModel model, JTextField textField) {
        this.panel = panel;
        this.table = table;
        this.model = model;
        this.textField = textField;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.getSelectedRow();
        String value = model.getValueAt(row, 0).toString() + " " + model.getValueAt(row, 1).toString() + " " + model.getValueAt(row, 2).toString();
        textField.setText(value);
        panel.updateUI();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
