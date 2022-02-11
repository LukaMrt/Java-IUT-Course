package com.lukamaret.course.TPBiblio;

public class Document {

    private String archiveCode;
    private String title;
    private String author;
    private int publicationYear;
    private Status status;
    private boolean reserved;
    private String reserveName;

    public Document(String archiveCode, String title, String author, int publicationYear) {
        this.archiveCode = archiveCode;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.reserved = false;
        this.status = Status.AVAILABLE;
        this.reserveName = "";
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
        this.reserveName = "";
        return true;
    }

    public boolean borrowReserved(String name) {

        if (this.status != Status.WAITING_RESERVE || !this.reserveName.equals(name)) {
            return false;
        }

        this.status = Status.BORROWED;
        this.reserved = false;
        this.reserveName = "";
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

        this.reserveName = name;
        this.reserved = true;
        return true;
    }

    public boolean cancelReserve(String name) {

        if (this.status != Status.WAITING_RESERVE || !this.reserveName.equals(name)) {
            return false;
        }

        this.reserved = false;
        this.status = Status.RETURNED;
        return true;
    }

    public String getArchiveCode() {
        return archiveCode;
    }

    public void setArchiveCode(String archiveCode) {
        this.archiveCode = archiveCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getReserveName() {
        return reserveName;
    }

    public void setReserveName(String reserveName) {
        this.reserveName = reserveName;
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
