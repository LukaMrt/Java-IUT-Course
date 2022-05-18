package com.lukamaret.course.ihm.projetTD.seance6;

import javax.swing.*;

public class Exercice2 {

    public static void main(String[] args) {

        float a = Float.parseFloat(JOptionPane.showInputDialog("Entrez le premier nombre"));
        float b = Float.parseFloat(JOptionPane.showInputDialog("Entrez le deuxième nombre"));
        char sign = JOptionPane.showInputDialog("Entrez le signe").charAt(0);

        float result = switch (sign) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };

        JOptionPane.showMessageDialog(null, "Le résultat est : " + result);
    }

}
