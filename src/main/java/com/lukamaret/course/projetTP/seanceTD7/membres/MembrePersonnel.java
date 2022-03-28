package com.lukamaret.course.projetTP.seanceTD7.membres;

public class MembrePersonnel extends MembreBibliotheque {

    public MembrePersonnel(String firstName, String lastName, String phone, String address) {
        super(firstName, lastName, phone, address);
    }

    @Override
    public boolean canBorrow() {
        return super.borrowedDocuments < 8;
    }

}
