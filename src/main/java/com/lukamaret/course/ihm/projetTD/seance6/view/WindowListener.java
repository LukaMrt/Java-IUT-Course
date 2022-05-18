package com.lukamaret.course.ihm.projetTD.seance6.view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowListener extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent we) {
        int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?",
                "Online Examination System", JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE, null, new String[]{"Yes", "No"}, "No");

        if (PromptResult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }


}
