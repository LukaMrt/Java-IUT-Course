package com.lukamaret.course.ihm.projetTD.seance6;

import javax.swing.*;

public class Exercice1 {

    public static void main(String[] args) {

        String surname = JOptionPane.showInputDialog("Entrez votre prénom").substring(0, 2);
        String name = JOptionPane.showInputDialog("Entrez votre nom de famille").substring(0, 3);
        String motherName = JOptionPane.showInputDialog("Entrez le nom de jeune fille de votre mère").substring(0, 2);
        String city = JOptionPane.showInputDialog("Entrez le nom de votre ville de naissance").substring(0, 3);

        JOptionPane.showMessageDialog(null, "Votre nom Star Wars est : " + name + surname + " " + motherName + city);

    }

}
