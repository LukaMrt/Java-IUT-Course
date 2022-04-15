package com.lukamaret.course.projetTP.seanceTD10;

import com.lukamaret.course.projetTP.seanceTD10.documents.DocBibliotheque;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpeedClassTest {

    public static void main(String[] args) {

        execute(new ArrayList<>(), "ArrayList");
        execute(new LinkedList<>(), "LinkedList");

    }

    private static void execute(List<DocBibliotheque> documents, String type) {

        DocBibliotheque[] docs = new DocBibliotheque[10000];

        for (int i = 0; i < 10000; i++) {
            docs[i] = new DocBibliotheque("" + i, "" + i, "" + i, i);
        }

        CatalogueBibliotheque catalogue = new CatalogueBibliotheque(documents);

        long start = System.currentTimeMillis();
        for (DocBibliotheque doc : docs) {
            catalogue.add(doc);
        }
        long end = System.currentTimeMillis();
        System.out.println("Temps d'exécution pour l'ajout (" + type + ") : " + (end - start) + " ms");

        start = System.currentTimeMillis();
        for (DocBibliotheque doc : docs) {
            catalogue.get(Integer.parseInt(doc.getTitle()));
        }
        end = System.currentTimeMillis();
        System.out.println("Temps d'exécution pour la recherche (" + type + ") : " + (end - start) + " ms");

    }

}
