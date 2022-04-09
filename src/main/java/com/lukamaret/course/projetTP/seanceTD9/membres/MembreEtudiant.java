package com.lukamaret.course.projetTP.seanceTD9.membres;

import com.lukamaret.course.projetTP.seanceTD9.documents.DocBibliotheque;

import java.util.Scanner;

public class MembreEtudiant extends MembreBibliotheque {

    private static final Scanner SCANNER = new Scanner(System.in);

    public MembreEtudiant(String firstName, String lastName, String phone, String address) {
        super(firstName, lastName, phone, address);
    }

    @Override
    public boolean canBorrow() {
        return super.borrowedDocuments < 4;
    }

    @Override
    public void docDisponible(DocBibliotheque document) {

        System.out.println("Le document " + document.getTitle() + " qui a été réservé par le membre du personnel "
                + this.getName() + " est désormais disponible à l’emprunt au bureau des réservations");
        System.out.println("Voulez-vous l'emprunter ? (O/N)");

        if (SCANNER.nextLine().toUpperCase().charAt(0) == 'O') {
            document.borrow(this);
        }

    }

}
