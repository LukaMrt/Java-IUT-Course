package com.lukamaret.course.TPBiblio;

public class Document3 {

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

    public Document3(String archiveCode, String title, String author, int publicationYear) {
        this.archiveCode = archiveCode;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.status = Status.AVAILABLE;
    }

    public boolean borrow(Member member) {

        if (this.status == Status.WAITING_RESERVE) {
            return this.borrowReserved(member);
        }

        if (status != Status.AVAILABLE) {
            return this.reserve(member);
        }

        this.status = Status.BORROWED;
        this.reserver = null;
        this.borrower = member;
        borrowed++;
        return true;
    }

    public boolean borrowReserved(Member member) {

        if (this.status != Status.WAITING_RESERVE || (this.reserver != null && !this.reserver.getName().equals(member.getName()))) {
            return false;
        }

        this.status = Status.BORROWED;
        this.reserver = null;
        this.borrower = member;
        borrowed++;
        waitingReserve--;
        return true;
    }

    public boolean returnDocument() {

        if (this.status != Status.BORROWED) {
            return false;
        }

        borrowed--;

        if (this.reserver != null) {
            this.status = Status.WAITING_RESERVE;
            waitingReserve++;
            return true;
        }

        this.status = Status.RETURNED;
        returned++;
        return true;
    }

    public boolean store() {

        if (this.status != Status.RETURNED) {
            return false;
        }

        this.status = Status.AVAILABLE;
        returned--;
        return true;
    }

    public boolean reserve(Member member) {

        if (this.reserver != null) {
            return false;
        }

        this.reserver = member;

        if (this.status == Status.AVAILABLE) {
            this.status = Status.WAITING_RESERVE;
            waitingReserve++;
            return true;
        }

        return true;
    }

    public boolean cancelReserve(Member member) {

        if (this.status != Status.WAITING_RESERVE || !this.reserver.getName().equals(member.getName())) {
            return false;
        }

        this.reserver = null;
        this.status = Status.RETURNED;
        returned++;
        waitingReserve--;
        return true;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {

        if (this.reserver != null && this.status != Status.AVAILABLE) {
            return "Réservé par " + this.reserver.getName();
        }

        return switch (this.status) {
            case AVAILABLE -> "Disponible";
            case BORROWED -> "Emprunté par " + this.borrower.getName();
            case WAITING_RESERVE -> "Réservé par une personne inconnue";
            case RETURNED -> "Retourné";
        };

    }

    public boolean isBorrowed() {
        return this.status == Status.BORROWED;
    }

    public String getBorrower() {
        return this.borrower.getName();
    }

    public String getReserver() {
        return this.reserver.getName();
    }

    @Override
    public String toString() {
        return "Document3{" +
                "archiveCode='" + archiveCode + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", borrower=" + borrower +
                ", reserver=" + reserver +
                ", status=" + status +
                '}';
    }

}
