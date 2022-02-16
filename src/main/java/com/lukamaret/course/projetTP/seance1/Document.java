package com.lukamaret.course.projetTP.seance1;

public class Document {

    private final String archiveCode;
    private final String title;
    private final String author;
    private final int publicationYear;
    private Status status;
    private boolean reserved;
    private String reserverName;

    public Document(String archiveCode, String title, String author, int publicationYear) {
        this.archiveCode = archiveCode;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.reserved = false;
        this.status = Status.AVAILABLE;
        this.reserverName = "";
    }

    public boolean borrow(String name) {

        if (this.status == Status.WAITING_RESERVE) {
            return this.borrowReserved(name);
        }

        if (status != Status.AVAILABLE) {
            return this.reserve(name);
        }

        this.status = Status.BORROWED;
        this.reserved = false;
        this.reserverName = "";
        return true;
    }

    public boolean borrowReserved(String name) {

        if (this.status != Status.WAITING_RESERVE || !this.reserverName.equals(name)) {
            return false;
        }

        this.status = Status.BORROWED;
        this.reserved = false;
        this.reserverName = "";
        return true;
    }

    public boolean returnDocument() {

        if (this.status != Status.BORROWED) {
            return false;
        }

        if (reserved) {
            this.status = Status.WAITING_RESERVE;
            return true;
        }

        this.status = Status.RETURNED;
        return true;
    }

    public boolean store() {

        if (this.status != Status.RETURNED) {
            return false;
        }

        this.status = Status.AVAILABLE;
        return true;
    }

    public boolean reserve(String name) {

        if (this.reserved) {
            return false;
        }

        if (this.status == Status.AVAILABLE) {
            this.status = Status.WAITING_RESERVE;
            return false;
        }

        this.reserverName = name;
        this.reserved = true;
        return true;
    }

    public boolean cancelReserve(String name) {

        if (this.status != Status.WAITING_RESERVE || !this.reserverName.equals(name)) {
            return false;
        }

        this.reserved = false;
        this.status = Status.RETURNED;
        return true;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {

        if (this.reserved && this.status != Status.AVAILABLE) {
            return "Réservé";
        }

        return switch (this.status) {
            case AVAILABLE -> "Disponible";
            case BORROWED -> "Emprunté";
            case WAITING_RESERVE -> "Réservé";
            case RETURNED -> "Retourné";
        };

    }

    public boolean isBorrowed() {
        return this.status == Status.BORROWED;
    }

    @Override
    public String toString() {
        return "Document{" +
                "archiveCode='" + archiveCode + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", status=" + status +
                ", reserved=" + reserved +
                ", reserverName='" + reserverName + '\'' +
                '}';
    }

}
