package com.lukamaret.course.main;

import com.lukamaret.course.td1.Conversion;
import com.lukamaret.course.td1.Tax;
import com.lukamaret.course.td1.Somme;

import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        int n = SCANNER.nextInt();
        Somme somme = new Somme();
        System.out.println(somme.nFirstNumbers(n));

        int income = SCANNER.nextInt();
        Tax tax = new Tax();
        System.out.println(tax.computeTax(income));

        char c = SCANNER.next().charAt(0);
        Conversion conversion = new Conversion();
        conversion.convert(c);

    }

}
