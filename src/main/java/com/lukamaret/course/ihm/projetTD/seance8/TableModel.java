package com.lukamaret.course.ihm.projetTD.seance8;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel {

    private String[] columns;
    private Object[][] data;

    public TableModel(String[] columns, Object[][] data) {
        this.columns = columns;
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public String getColumnName(int column) {
        return columns[column];
    }

    public void setColumnName(int column, String name) {
        columns[column] = name;
    }

    public void addColumn(String name) {
        String[] newColumns = new String[columns.length + 1];
        System.arraycopy(columns, 0, newColumns, 0, columns.length);
        newColumns[columns.length] = name;
        columns = newColumns;

        Object[][] newData = new Object[data.length][columns.length];

        for (int i = 0; i < data.length; i++) {
            System.arraycopy(data[i], 0, newData[i], 0, data[i].length);
            newData[i][columns.length - 1] = "";
        }

        data = newData;

        fireTableDataChanged();
        fireTableStructureChanged();
        fireTableRowsUpdated(0, data.length - 1);
        fireTableRowsInserted(0, data.length - 1);
    }

    public void remplirTable(List<Etudiant> etudiants) {

        for (Etudiant etudiant : etudiants) {

            Object[] row = new Object[columns.length];
            row[0] = etudiant.getNom();
            row[1] = etudiant.getPrenom();
            row[2] = etudiant.getIdentifiant();

            addRow(row);

        }

    }

    private void addRow(Object[] row) {
        Object[][] newData = new Object[data.length + 1][columns.length];
        System.arraycopy(data, 0, newData, 0, data.length);
        newData[data.length] = row;
        data = newData;

        fireTableDataChanged();
        fireTableStructureChanged();
        fireTableRowsUpdated(0, data.length - 1);
        fireTableRowsInserted(0, data.length - 1);
    }

}
