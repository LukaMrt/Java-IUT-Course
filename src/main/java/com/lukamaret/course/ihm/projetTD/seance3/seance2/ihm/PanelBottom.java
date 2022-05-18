package com.lukamaret.course.ihm.projetTD.seance3.seance2.ihm;

import javax.swing.*;
import java.awt.*;

public class PanelBottom extends JPanel {

    public PanelBottom() {
        this.setLayout(new BorderLayout());
        this.add(new Label("Sud-Ouest"), BorderLayout.WEST);
        this.add(new Label("Sud-Est"), BorderLayout.EAST);
    }

}
