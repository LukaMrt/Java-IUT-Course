package com.lukamaret.course.projetTP.seanceTD6.documents;

import com.lukamaret.course.projetTP.seanceTD6.exceptions.ActionImpossibleException;
import com.lukamaret.course.projetTP.seanceTD6.membres.MembreBibliotheque;

public class DocURL extends DocBibliotheque {

    private final String url;

    public DocURL(String archiveCode, String title, String author, int publicationYear, String url) {
        super(archiveCode, title, author, publicationYear);
        this.url = url;
    }

    @Override
    public boolean borrow(MembreBibliotheque member) {
        throw new ActionImpossibleException();
    }

    @Override
    public boolean returnDocument() {
        throw new ActionImpossibleException();
    }

    @Override
    public boolean reserve(MembreBibliotheque member) {
        throw new ActionImpossibleException();
    }

    @Override
    public boolean cancelReserve(MembreBibliotheque member) {
        throw new ActionImpossibleException();
    }

}
