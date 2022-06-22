package com.lukamaret.course.ihm.projetTD.seance8;

import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        JTextField textField = new JTextField();

        JFrame jFrame = new JFrame("JFrame");

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
        jFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        jFrame.add(panel);


        String[] columns = {"Nom", "Prénom", "Identifiant"};
        JTable table = new JTable();
        TableModel model = new TableModel(columns, new String[][]{});
        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        List<Etudiant> students = List.of(
                new Etudiant("1", "Maret", "Luka"),
                new Etudiant("2", "Chavot", "Vincent"),
                new Etudiant("3", "Borie", "Yanis"),
                new Etudiant("4", "Naudts", "Angelo")
        );
        model.remplirTable(students);

        table.addMouseListener(new MyMouseListener(panel, table, model, textField));

        panel.add(textField);

        jFrame.setVisible(true);
    }

}
