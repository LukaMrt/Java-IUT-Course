package com.lukamaret.course.ihm.projetTP.seance4;

public class StringMoteur {

    public String upperCase(String str) {
        return str.toUpperCase();
    }

    public String lowerCase(String str) {
        return str.toLowerCase();
    }

    public String capitalizeWords(String str) {

        String[] args = str.split(" ");

        for (int i = 0; i < args.length; i++) {
            args[i] = args[i].substring(0, 1).toUpperCase() + args[i].substring(1);
        }

        StringBuilder result = new StringBuilder();

        for (String s : args) {
            if (!s.equals(" ")) {
                result.append(s).append(" ");
            }
        }

        return result.substring(0, result.length() - 1);
    }

    public String addAtStart(String str, String str2) {
        return str2 + str;
    }

    public String addAtEnd(String str, String str2) {
        return str + str2;
    }

    public String splitWordsWithComa(String str) {

        StringBuilder result = new StringBuilder();

        for (String s : str.split(" ")) {
            if (!s.isBlank()) {
                result.append(s).append(", ");
            }
        }

        return result.substring(0, result.length() - 2);
    }

    public String sizeWithoutSpace(String str) {
        return String.valueOf(str.replace(" ", "").length());
    }

    public String simpleOperation(String str) throws IllegalArgumentException {

        String[] args = str.split(" ");

        if (args.length != 3) {
            throw new IllegalArgumentException("Format incorrect");
        }

        double a;
        double b;

        try {
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Les arguments doivent être des nombres");
        }

        return String.valueOf(switch (args[1]) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("L'opérateur doit être +, -, * ou /");
        });
    }

}
