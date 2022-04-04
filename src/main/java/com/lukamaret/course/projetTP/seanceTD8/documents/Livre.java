package com.lukamaret.course.projetTP.seanceTD8.documents;

public class Livre extends DocBibliotheque {

    private final int pageCount;
    private final String editor;
    private final String isbn;

    public Livre(String archiveCode, String title, String author, int publicationYear, int pageCount, String editor, String isbn) {
        super(archiveCode, title, author, publicationYear);
        this.pageCount = pageCount;
        this.editor = editor;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() + "Livre{" +
                "pageCount=" + pageCount +
                ", editor='" + editor + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

}
