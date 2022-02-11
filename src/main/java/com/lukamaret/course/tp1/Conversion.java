package com.lukamaret.course.tp1;

public class Conversion {

    public void convert(char c) {

        if (Character.isUpperCase(c)) {
            System.out.println("Le caractère minuscule correspondant à c est : " + Character.toLowerCase(c));
        }

        if (Character.isLowerCase(c)) {
            System.out.println("Le caractère majuscule correspondant à c est : " + Character.toUpperCase(c));
        }

        if (!Character.isLetter(c)) {
            System.out.println("c n'est pas une lettre");
        }

    }

}
