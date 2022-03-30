package com.lukamaret.course.ihm.projetTD.seance1.ihm;

import javax.swing.*;

public class CalculatorPanel extends JPanel {

    public CalculatorPanel() {

        this.add(new InputField());
        this.add(new SymbolsComboBox());
        this.add(new InputField());
        this.add(new JButton("Valider"));
        this.add(new Label());

    }

}
