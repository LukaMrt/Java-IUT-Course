package com.lukamaret.course.sudoku;

import javax.swing.*;
import java.awt.*;

/**
 * @author Luka Maret
 * @version 1.0
 */
public class SFrame extends JFrame {

    public SFrame() throws HeadlessException {
        this.setTitle("Sudoku solver");
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(new SPanel());
        this.setVisible(true);
    }

}
