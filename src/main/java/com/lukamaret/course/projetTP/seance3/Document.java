package com.lukamaret.course.projetTP.seance3;

public class Document {

    private static int borrowed = 0;
    private static int returned = 0;
    private static int waitingReserve = 0;

    private final String archiveCode;
    private final String title;
    private final String author;
    private final int publicationYear;

    private Status status;
    private Member borrower;
    private Member reserver;

    public Document(String archiveCode, String title, String author, int publicationYear) {
        this.archiveCode = archiveCode;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.status = Status.AVAILABLE;
    }

    public boolean borrow(Member member) {

        boolean result = false;

        if (this.status == Status.AVAILABLE || (this.status == Status.WAITING_RESERVE && this.reserver == member)) {

            if (this.status == Status.WAITING_RESERVE) {
                Document.waitingReserve--;
            }

            this.status = Status.BORROWED;
            this.reserver = null;
            this.borrower = member;
            Document.borrowed++;
            result = true;

        }

        return result;
    }

    public boolean returnDocument() {

        boolean result = false;

        if (this.status == Status.BORROWED) {

            this.status = Status.RETURNED;
            Document.returned++;
            Document.borrowed--;

            if (this.reserver != null) {
                this.status = Status.WAITING_RESERVE;
                Document.waitingReserve++;
                Document.returned--;
            }

            result = true;
        }

        return result;
    }

    public boolean store() {

        boolean result = false;

        if (this.status == Status.RETURNED) {
            this.status = Status.AVAILABLE;
            Document.returned--;
            result = true;
        }

        return result;
    }

    public boolean reserve(Member member) {

        boolean result = false;

        if (this.status == Status.BORROWED && this.reserver == null) {
            this.reserver = member;
            result = true;
        }

        return result;
    }

    public boolean cancelReserve(Member member) {

        boolean result = false;

        if (this.reserver == member) {

            this.reserver = null;

            if (this.status == Status.WAITING_RESERVE) {
                this.status = Status.RETURNED;
                Document.returned++;
                Document.waitingReserve--;
            }

            result = true;
        }

        return result;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getStatus() {

        if (isBorrowed()) {
            return "Réservé par " + getReserver();
        }

        return switch (this.status) {
            case AVAILABLE -> "Disponible";
            case BORROWED -> "Emprunté par " + getBorrower();
            case WAITING_RESERVE -> "Réservé par une personne inconnue";
            case RETURNED -> "Retourné";
        };

    }

    public boolean isBorrowed() {
        return this.status == Status.BORROWED;
    }

    public Member getBorrower() {
        return this.borrower;
    }

    public Member getReserver() {
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
        return title + " écrit en " + publicationYear + " par " + author + " (code " + archiveCode + ")";
    }

}
