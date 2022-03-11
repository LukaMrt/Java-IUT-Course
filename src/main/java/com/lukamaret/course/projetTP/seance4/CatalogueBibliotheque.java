package com.lukamaret.course.projetTP.seance4;

import java.util.ArrayList;

public class CatalogueBibliotheque {

    private final ArrayList<DocBibliotheque> documents;

    public CatalogueBibliotheque() {
        documents = new ArrayList<>();
    }

    public boolean add(DocBibliotheque doc) {
        boolean result = false;

        if (!documents.contains(doc)) {
            documents.add(doc);
            result = true;
        }

        return result;
    }

    public boolean remove(DocBibliotheque doc) {
        boolean result = false;

        if (documents.contains(doc)) {
            documents.remove(doc);
            result = true;
        }

        return result;
    }

    public DocBibliotheque get(int index) {
        return documents.get(index);
    }

    public void displayAllDocuments() {
        for (int i = 0; i < documents.size(); i++) {
            System.out.println((i + 1) + " - " + documents.get(i));
        }
    }

    public void displayAllBorrowedDocuments() {
        for (DocBibliotheque doc : documents) {
            if (doc.isBorrowed()) {
                System.out.println(doc);
            }
        }
    }

    public boolean borrow(int index, MembreBibliotheque member) {
        return documents.get(index).borrow(member);
    }

    public boolean reserve(int index, MembreBibliotheque member) {
        return documents.get(index).reserve(member);
    }

    public boolean cancelReservation(int index, MembreBibliotheque member) {
        return documents.get(index).cancelReserve(member);
    }

    public boolean returnDocument(int index) {
        return documents.get(index).returnDocument();
    }

    public boolean store(int index) {
        return documents.get(index).store();
    }

}
