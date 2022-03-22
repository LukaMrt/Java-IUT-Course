package com.lukamaret.course.projetTP.seanceTD6.documents;

import java.util.ArrayList;

public class CD extends DocBibliotheque {

    private final ArrayList<String> tracks;

    public CD(String archiveCode, String title, ArrayList<String> author, int publicationYear, ArrayList<String> tracks) {
        super(archiveCode, title, author.get(0), publicationYear);
        this.tracks = tracks;
    }

}
