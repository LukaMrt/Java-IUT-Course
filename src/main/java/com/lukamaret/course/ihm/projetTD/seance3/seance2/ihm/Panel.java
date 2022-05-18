package com.lukamaret.course.ihm.projetTD.seance3.seance2.ihm;

import javax.swing.*;

public class Panel extends JPanel {

    public Panel() {

        PanelTop top = new PanelTop();
        this.add(top);

        PanelMiddle middle = new PanelMiddle();
        this.add(middle);

        PanelBottom bottom = new PanelBottom();
        this.add(bottom);

    }

}
