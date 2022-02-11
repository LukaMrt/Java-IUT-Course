package com.lukamaret.course.TPBiblio;

public class Library {

    public static void main(String[] args) {

        Document doc1 = new Document("004. 178 K20PM", "Introduction à Java", "J. Leblanc", 2015);
        Document doc2 = new Document("967. 4987 T248O", "Structures de Données", "M. Machin", 2017);

        System.out.println(" > Emprunt du document '" + doc1.getTitle() + "' par John");
        if (doc1.borrow("John")) {
            System.out.println("Document " + doc1.getTitle() + " emprunté");
        }
        System.out.println();

        System.out.println(" > Document " + doc1.getTitle() + " : " + doc1.getStatus());
        System.out.println();

        System.out.println(" > réservation du document '" + doc1.getTitle() + "' par Bob");
        if (doc1.reserve("Bob")) {
            System.out.println("Document " + doc2.getTitle() + " réservé");
        } else {
            System.out.println("Impossible pour vous de réserver ce document");
        }
        System.out.println();

        System.out.println(" > Retour du document '" + doc1.getTitle() + "'");
        if (doc1.returnDocument()) {
            System.out.println("Document " + doc1.getTitle() + " retourné");
        } else {
            System.out.println("Impossible de retourner ce document");
        }
        System.out.println();

        System.out.println(" > Document '" + doc1.getTitle() + "' : " + doc1.getStatus());
        System.out.println();

        System.out.println(" > Emprunt du document '" + doc1.getTitle() + "' par John");
        if (doc1.borrow("John")) {
            System.out.println("Document " + doc1.getTitle() + " emprunté");
        }
        System.out.println();

        System.out.println(" > Emprunt du document '" + doc1.getTitle() + "' par Bob");
        if (doc1.borrowReserved("Bob")) {
            System.out.println("Document " + doc1.getTitle() + " emprunté");
        } else {
            System.out.println("Impossible pour vous d'emprunter ce document");
        }
        System.out.println();

        System.out.println(" > Réservation du document '" + doc2.getTitle() + "' par John");
        if (doc2.reserve("John")) {
            System.out.println("Document " + doc2.getTitle() + " réservé");
        } else {
            System.out.println("Impossible pour vous de réserver ce document");
        }
        System.out.println();

        System.out.println(" > Annulation de la réservation du document '" + doc2.getTitle() + "' par John");
        if (doc2.cancelReserve("John")) {
            System.out.println("Réservation du document " + doc2.getTitle() + " annulée");
        } else {
            System.out.println("Impossible pour vous d'annuler la réservation");
        }
        System.out.println();

        System.out.println(" > Statut emprunt document '" + doc2.getTitle() + "' : " + (doc2.isBorrowed() ? "emprunté" : "disponible"));
        System.out.println();

        System.out.println(" > Retour dans les rayons du document '" + doc1.getTitle() + "'");
        if (doc1.store()) {
            System.out.println("Document " + doc1.getTitle() + " disponible");
        } else {
            System.out.println("Impossible de remettre ce document sur les étagères");
        }
        System.out.println();

        System.out.println(" > Document '" + doc1.getTitle() + "' : " + doc1.getStatus());

    }

}
