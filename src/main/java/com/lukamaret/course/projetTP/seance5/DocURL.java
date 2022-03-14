package com.lukamaret.course.projetTP.seance5;

public class DocURL extends DocBibliotheque {

    private final String url;

    public DocURL(String archiveCode, String title, String author, int publicationYear, String url) {
        super(archiveCode, title, author, publicationYear);
        this.url = url;
    }

    @Override
    public boolean borrow(MembreBibliotheque member) {
        return false;
    }

    @Override
    public boolean returnDocument() {
        return false;
    }

    @Override
    public boolean reserve(MembreBibliotheque member) {
        return false;
    }

    @Override
    public boolean cancelReserve(MembreBibliotheque member) {
        return false;
    }

}
