package com.lukamaret.course.sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * @author Luka Maret
 * @version 1.0
 */
public class SPanel extends JPanel implements ActionListener {

    private String file = "";

    public SPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        update();
    }

    private void update() {
        this.removeAll();

        this.add(Box.createVerticalGlue());
        this.add(Box.createVerticalGlue());
        JButton btn = new JButton("Choisir le fichier");
        btn.addActionListener(this);
        btn.setAlignmentX(CENTER_ALIGNMENT);
        this.add(btn);

        if (file != null && !file.equals("")) {
            JLabel label = new JLabel("Fichier : " + file);
            label.setAlignmentX(CENTER_ALIGNMENT);
            this.add(label);
            try {
                displaySolution();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.add(Box.createVerticalGlue());
        this.add(Box.createVerticalGlue());
        this.add(Box.createVerticalGlue());
        this.add(Box.createVerticalGlue());
        this.add(Box.createVerticalGlue());
        this.updateUI();
    }

    private void displaySolution() throws Exception {
        File file = new File(this.file);
        FileReader rd = new FileReader(file);

        Grid grid = Grid.create(rd);
        if (grid == null) {
            return;
        }

        List<Grid> solutions = SudokuSolver.solve(grid);

        for (Grid solution : solutions) {

            this.add(Box.createVerticalGlue());

            JLabel label = new JLabel("Solution :");
            label.setAlignmentX(CENTER_ALIGNMENT);
            this.add(label);

            for (String line : solution.toString().split("\n")) {
                JLabel l = new JLabel(line);
                l.setAlignmentX(CENTER_ALIGNMENT);
                this.add(l);
            }

            this.add(Box.createVerticalGlue());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser("./");

        if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.file = jFileChooser.getSelectedFile().getName();
            update();
        }

    }

}
