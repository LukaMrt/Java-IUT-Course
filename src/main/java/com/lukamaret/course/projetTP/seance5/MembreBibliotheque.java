package com.lukamaret.course.projetTP.seance5;

public class MembreBibliotheque {

    private static int id = 1;

    private final int memberId;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String address;

    protected int borrowedDocuments = 0;


    public MembreBibliotheque(String firstName, String lastName, String phone, String address) {
        this.memberId = id++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public void addBorrowedDocument() {
        this.borrowedDocuments++;
    }

    public void removeBorrowedDocument() {
        this.borrowedDocuments--;
    }

    public boolean canBorrow() {
        return true;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
