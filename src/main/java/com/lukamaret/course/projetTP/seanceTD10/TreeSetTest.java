package com.lukamaret.course.projetTP.seanceTD10;

import com.lukamaret.course.projetTP.seanceTD10.documents.Comparator;
import com.lukamaret.course.projetTP.seanceTD10.documents.DocBibliotheque;

import java.util.*;

public class TreeSetTest {

    public static void main(String[] args) {

        Set<DocBibliotheque> bibliotheque = new TreeSet<>();

        bibliotheque.add(new DocBibliotheque("978-2-1234-5678-9", "1", "Antoine de Saint-Exupéry", 2020));
        bibliotheque.add(new DocBibliotheque("5-5-214-566-3", "2", "Antoine de Saint-Exupéry", 2020));
        bibliotheque.add(new DocBibliotheque("6765-2-1234-5678-9", "3", "Antoine de Saint-Exupéry", 2020));
        bibliotheque.add(new DocBibliotheque("978-2-1234-53-9", "4", "Antoine de Saint-Exupéry", 2020));

        bibliotheque.forEach(System.out::println);

        List<DocBibliotheque> bibliotheque2 = new ArrayList<>();
        System.out.println("\n\n");

        bibliotheque2.add(new DocBibliotheque("978-2-1234-5678-9", "1", "Antoine de Saint-Exupéry", 2020));
        bibliotheque2.add(new DocBibliotheque("5-5-214-566-3", "3", "Antoine de Saint-Exupéry", 2020));
        bibliotheque2.add(new DocBibliotheque("6765-2-1234-5678-9", "4", "Antoine de Saint-Exupéry", 2020));
        bibliotheque2.add(new DocBibliotheque("978-2-1234-53-9", "2", "Antoine de Saint-Exupéry", 2020));

        bibliotheque2.forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
        bibliotheque2.sort(new Comparator());
        bibliotheque2.forEach(System.out::println);

        Map<String, DocBibliotheque> map1 = new TreeMap<>();
        Map<String, DocBibliotheque> map2 = new HashMap<>();

        map1.put("978-2-1234-5678-9", new DocBibliotheque("978-2-1234-5678-9", "1", "Antoine de Saint-Exupéry", 2020));
        map1.put("5-5-214-566-3", new DocBibliotheque("5-5-214-566-3", "2", "Antoine de Saint-Exupéry", 2020));
        map1.put("6765-2-1234-5678-9", new DocBibliotheque("6765-2-1234-5678-9", "3", "Antoine de Saint-Exupéry", 2020));
        map1.put("978-2-1234-53-9", new DocBibliotheque("978-2-1234-53-9", "4", "Antoine de Saint-Exupéry", 2020));

        map2.put("978-2-1234-5678-9", new DocBibliotheque("978-2-1234-5678-9", "1", "Antoine de Saint-Exupéry", 2020));
        map2.put("5-5-214-566-3", new DocBibliotheque("5-5-214-566-3", "2", "Antoine de Saint-Exupéry", 2020));
        map2.put("6765-2-1234-5678-9", new DocBibliotheque("6765-2-1234-5678-9", "3", "Antoine de Saint-Exupéry", 2020));
        map2.put("978-2-1234-53-9", new DocBibliotheque("978-2-1234-53-9", "4", "Antoine de Saint-Exupéry", 2020));

        System.out.println("\n\n");

        map1.entrySet().forEach(System.out::println);
        System.out.println("\n\n");
        map2.entrySet().forEach(System.out::println);

    }

}
