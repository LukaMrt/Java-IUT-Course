package com.lukamaret.course.projetTP.seanceTD8.documents;

import com.lukamaret.course.projetTP.seanceTD8.Status;
import com.lukamaret.course.projetTP.seanceTD8.exceptions.ActionImpossibleException;
import com.lukamaret.course.projetTP.seanceTD8.membres.MembreBibliotheque;
import com.lukamaret.course.projetTP.seanceTD8.notification.Notifiable;

public class DocBibliotheque {

    private static int borrowed = 0;
    private static int returned = 0;
    private static int waitingReserve = 0;

    private final String archiveCode;
    private final String title;
    private final String author;
    private final int publicationYear;

    private Status status;
    private MembreBibliotheque borrower;
    private Notifiable reserver;

    public DocBibliotheque(String archiveCode, String title, String author, int publicationYear) {
        this.archiveCode = archiveCode;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.status = Status.AVAILABLE;
    }

    public boolean borrow(MembreBibliotheque member) {

        boolean result = false;

        if (this.status == Status.AVAILABLE || (this.status == Status.WAITING_RESERVE && this.reserver == member)) {

            if (this.status == Status.WAITING_RESERVE) {
                DocBibliotheque.waitingReserve--;
            }

            this.status = Status.BORROWED;
            this.reserver = null;
            this.borrower = member;
            DocBibliotheque.borrowed++;
            result = true;

        }

        if (!result) {
            throw new ActionImpossibleException();
        }

        return true;
    }

    public boolean returnDocument() {

        boolean result = false;

        if (this.status == Status.BORROWED) {

            this.status = Status.RETURNED;
            DocBibliotheque.returned++;
            DocBibliotheque.borrowed--;

            if (this.reserver != null) {
                this.status = Status.WAITING_RESERVE;
                DocBibliotheque.waitingReserve++;
                DocBibliotheque.returned--;
                this.reserver.docDisponible(this);
            }

            result = true;
        }

        if (!result) {
            throw new ActionImpossibleException();
        }

        return true;
    }

    public boolean store() {

        boolean result = false;

        if (this.status == Status.RETURNED) {
            this.status = Status.AVAILABLE;
            DocBibliotheque.returned--;
            result = true;
        }

        if (!result) {
            throw new ActionImpossibleException();
        }

        return true;
    }

    public boolean reserve(Notifiable member) {

        boolean result = false;

        if (this.status == Status.BORROWED && this.reserver == null) {
            this.reserver = member;
            result = true;
        }

        if (!result) {
            throw new ActionImpossibleException();
        }

        return true;
    }

    public boolean cancelReserve(Notifiable member) {

        boolean result = false;

        if (this.reserver == member) {

            this.reserver = null;

            if (this.status == Status.WAITING_RESERVE) {
                this.status = Status.RETURNED;
                DocBibliotheque.returned++;
                DocBibliotheque.waitingReserve--;
            }

            result = true;
        }

        if (!result) {
            throw new ActionImpossibleException();
        }

        return true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getStatus() {

        if (isBorrowed()) {
            return "R??serv?? par " + getReserver();
        }

        return switch (this.status) {
            case AVAILABLE -> "Disponible";
            case BORROWED -> "Emprunt?? par " + getBorrower();
            case WAITING_RESERVE -> "R??serv?? par une personne inconnue";
            case RETURNED -> "Retourn??";
        };

    }

    public boolean isBorrowed() {
        return this.status == Status.BORROWED;
    }

    public MembreBibliotheque getBorrower() {
        return this.borrower;
    }

    public Notifiable getReserver() {
        return this.reserver;
    }

    public static int getBorrowedCount() {
        return borrowed;
    }

    public static int getReturnedCount() {
        return returned;
    }

    public static int getWaitingReserveCount() {
        return waitingReserve;
    }

    @Override
    public String toString() {
        return title + " ??crit en " + publicationYear + " par " + author + " (code " + archiveCode + ")";
    }

}
