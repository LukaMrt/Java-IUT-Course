package com.lukamaret.course.ihm.projetTD.seance7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class TestFileWriter {

    public static void main(String[] args) {

//        exercice1();
        new MyJFrame();

    }

    private static void exercice1() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter a file name: ");
            String fileName = reader.readLine();
            String entry = "";

            int i = 1;
            FileWriter writer = new FileWriter(fileName, true);
            while (!entry.equals("end")) {
                System.out.println("Enter a line (or 'end') : ");
                entry = reader.readLine();
                if (!entry.equals("end")) {
                    writer.write(i++ + " - " + entry + "\n");
                    writer.flush();
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        reader = new BufferedReader(new InputStreamReader(System.in));
        char[] buffer = new char[1024];

        try {
            System.out.println("Enter a file name: ");
            String fileName = reader.readLine();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            char c;
            int i = 0;

            while ((c = (char) fileReader.read()) != (char) -1) {
                buffer[i++] = c;
            }

            for (int i1 = 0; i1 < i; i1++) {
                System.out.print(buffer[i1]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
