package com.lukamaret.course.projetTP.seanceTD6;

import com.lukamaret.course.projetTP.seanceTD6.documents.CD;
import com.lukamaret.course.projetTP.seanceTD6.documents.DocBibliotheque;
import com.lukamaret.course.projetTP.seanceTD6.documents.Livre;
import com.lukamaret.course.projetTP.seanceTD6.membres.MembreBibliotheque;

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

        if (index < 0 || documents.size() <= index) {
            throw new IndexOutOfBoundsException();
        }

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

        boolean result = false;

        if (member.canBorrow()) {
            result = documents.get(index).borrow(member);
        }

        if (result) {
            member.addBorrowedDocument();
        }

        return result;
    }

    public boolean reserve(int index, MembreBibliotheque member) {
        return documents.get(index).reserve(member);
    }

    public boolean cancelReservation(int index, MembreBibliotheque member) {
        return documents.get(index).cancelReserve(member);
    }

    public boolean returnDocument(int index) {
        DocBibliotheque docBibliotheque = documents.get(index);
        MembreBibliotheque borrower = docBibliotheque.getBorrower();
        boolean result = docBibliotheque.returnDocument();

        if (result) {
            borrower.removeBorrowedDocument();
        }

        return result;
    }

    public boolean store(int index) {
        return documents.get(index).store();
    }

    public int countBooks() {
        int count = 0;

        for (DocBibliotheque doc : documents) {
            if (doc instanceof Livre) {
                count++;
            }
        }

        return count;
    }

    public int counCd() {
        int count = 0;

        for (DocBibliotheque doc : documents) {
            if (doc instanceof CD) {
                count++;
            }
        }

        return count;
    }

}
