package com.lukamaret.course.tp1;

public class Somme {

    public int nFirstNumbers(int n) {

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        return sum;
    }

}
