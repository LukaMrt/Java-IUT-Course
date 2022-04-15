package com.lukamaret.course.projetTP.seanceTD10.documents;

public class Comparator implements java.util.Comparator<DocBibliotheque> {

    @Override
    public int compare(DocBibliotheque o1, DocBibliotheque o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }

}
