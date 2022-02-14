package com.lukamaret.course.TPBiblio;

public class Document2 {

    private final String archiveCode;
    private final String title;
    private final String author;
    private final int publicationYear;
    private Status status;
    private boolean reserved;
    private String reserveName;

    public Document2(String archiveCode, String title, String author, int publicationYear) {
        this.archiveCode = archiveCode;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.reserved = false;
        this.status = Status.AVAILABLE;
        this.reserveName = "";
    }

    public boolean borrow(String name) {

        boolean result;

        if (this.status == Status.WAITING_RESERVE) {

            result = this.borrowReserved(name);

        } else if (status != Status.AVAILABLE) {

            result = this.reserve(name);

        } else {

            this.status = Status.BORROWED;
            this.reserved = false;
            this.reserveName = "";
            result = true;

        }

        return result;
    }

    public boolean borrowReserved(String name) {

        boolean result;

        if (this.status != Status.WAITING_RESERVE || !this.reserveName.equals(name)) {

            result = false;

        } else {

            this.status = Status.BORROWED;
            this.reserved = false;
            this.reserveName = "";
            result = true;

        }

        return result;
    }

    public boolean returnDocument() {

        boolean result;

        if (this.status != Status.BORROWED) {

            result = false;

        } else if (reserved) {

            this.status = Status.WAITING_RESERVE;
            result = true;

        } else {

            this.status = Status.RETURNED;
            result = true;

        }

        return result;
    }

    public boolean store() {

        boolean result;

        if (this.status != Status.RETURNED) {

            result = false;

        } else {

            this.status = Status.AVAILABLE;
            result = true;

        }

        return result;
    }

    public boolean reserve(String name) {

        boolean result;

        if (this.reserved) {

            result = false;

        } else if (this.status == Status.AVAILABLE) {

            this.status = Status.WAITING_RESERVE;
            result = false;

        } else {

            this.reserveName = name;
            this.reserved = true;
            result = true;

        }

        return result;
    }

    public boolean cancelReserve(String name) {

        boolean result;

        if (this.status != Status.WAITING_RESERVE || !this.reserveName.equals(name)) {

            result = false;

        } else {

            this.reserved = false;
            this.status = Status.RETURNED;
            result = true;

        }

        return result;
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
                ", reserveName='" + reserveName + '\'' +
                '}';
    }

}