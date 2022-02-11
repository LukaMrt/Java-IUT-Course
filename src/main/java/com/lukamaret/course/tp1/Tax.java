package com.lukamaret.course.tp1;

public class Tax {

    public double computeTax(double income) {

        double impot = 0;

        if (income <= 20_000) {
            impot += income * 0.05;
        }

        if (income <= 40_000) {
            impot += (income - 20_000) * 0.1;
        }

        if (income <= 60_000) {
            impot += (income - 40_000) * 0.15;
        }

        if (60_000 < income) {
            impot += (income - 60_000) * 0.3;
        }

        return impot;
    }

}
