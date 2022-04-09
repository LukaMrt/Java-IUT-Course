package com.lukamaret.course.projetTP.seanceTD9.membres;

import com.lukamaret.course.projetTP.seanceTD9.documents.DocBibliotheque;

public class MembrePersonnel extends MembreBibliotheque {

    public MembrePersonnel(String firstName, String lastName, String phone, String address) {
        super(firstName, lastName, phone, address);
    }

    @Override
    public boolean canBorrow() {
        return super.borrowedDocuments < 8;
    }

    @Override
    public void docDisponible(DocBibliotheque document) {
        System.out.println("Le document " + document.getTitle() + " qui a été réservé par le membre du personnel "
                + this.getName() + " est désormais disponible à l’emprunt au bureau des réservations");
    }

}
