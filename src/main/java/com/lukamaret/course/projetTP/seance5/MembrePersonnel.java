package com.lukamaret.course.projetTP.seance5;

public class MembrePersonnel extends MembreBibliotheque {

    public MembrePersonnel(String firstName, String lastName, String phone, String address) {
        super(firstName, lastName, phone, address);
    }

    @Override
    public boolean canBorrow() {
        return super.borrowedDocuments < 8;
    }

}
