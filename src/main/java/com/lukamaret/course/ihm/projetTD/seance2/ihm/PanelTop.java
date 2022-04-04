package com.lukamaret.course.ihm.projetTD.seance2.ihm;

import javax.swing.*;
import java.awt.*;

public class PanelTop extends JPanel {

    public PanelTop() {
        this.setLayout(new FlowLayout());
        this.add(new JButton("Cliquez ici !"));
        this.add(new JButton("Ou là !"));
    }

}
