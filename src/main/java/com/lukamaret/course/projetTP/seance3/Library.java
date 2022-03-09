package com.lukamaret.course.projetTP.seance3;

import java.util.Scanner;

public class Library {

    private static final Document JAVA = new Document("004. 178 K20PM", "Introduction à Java", "J. Leblanc", 2015);
    private static final Document DATA = new Document("967. 4987 T248O", "Structures de Données", "M. Machin", 2017);

    private static final Member JOHN = new Member("John", "Doe", "1111111111", "1 rue de la paix");
    private static final Member BOB = new Member("Bob", "Dupond", "2222222222", "2 rue de la paix");

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        boolean result;
        Document currentDocument;
        Member currentMember;

        System.out.println("Bienvenue dans la bibliothèque de l'Université Lyon 1");

        do {

            System.out.println("\nMenu des actions possibles :");
            System.out.println("0 - Quitter");
            System.out.println("1 - Afficher les documents disponibles");
            System.out.println("2 - Afficher les membres");
            System.out.println("3 - Emprunter un document");
            System.out.println("4 - Rendre un document");
            System.out.println("5 - Ranger un document");
            System.out.println("6 - Décrire un document");
            System.out.println("7 - Réserver un document");
            System.out.println("8 - Annuler une réservation");
            System.out.println("9 - Afficher le nombre de documents empruntés");
            System.out.println("10 - Afficher le nombre de documents retournés");
            System.out.println("11 - Afficher le nombre de documents dans la sections spéciale");


            System.out.print("\nQue souhaitez-vous faire ? ");
            choice = SCANNER.nextInt();
            SCANNER.nextLine();

            switch (choice) {

                case 0 -> System.out.println("Au revoir !");

                case 1 -> printDocuments();

                case 2 -> printMembers();

                case 3 -> {
                    currentDocument = getDocument();
                    currentMember = getMember();
                    result = currentDocument.borrow(currentMember);
                    if (result) {
                        System.out.println("Le document a bien été emprunté");
                    } else {
                        System.out.println("Le document n'a pas pu être emprunté");
                    }
                }

                case 4 -> {
                    currentDocument = getDocument();
                    result = currentDocument.returnDocument();
                    if (result) {
                        System.out.println("Le document a bien été rendu");
                    } else {
                        System.out.println("Le document n'a pas pu être rendu");
                    }
                }

                case 5 -> {
                    currentDocument = getDocument();
                    result = currentDocument.store();
                    if (result) {
                        System.out.println("Le document a bien été rangé");
                    } else {
                        System.out.println("Le document n'a pas pu être rangé");
                    }
                }

                case 6 -> {
                    currentDocument = getDocument();
                    System.out.println("Le livre " + currentDocument.getTitle() + " est écrit par "
                            + currentDocument.getAuthor() + ". Il est actuellement " + currentDocument.getStatus());
                }

                case 7 -> {
                    currentDocument = getDocument();
                    printMembers();
                    currentMember = getMember();
                    result = currentDocument.reserve(currentMember);
                    if (result) {
                        System.out.println("Le document a bien été réservé");
                    } else {
                        System.out.println("Le document n'a pas pu être réservé");
                    }
                }

                case 8 -> {
                    currentDocument = getDocument();
                    currentMember = getMember();
                    result = currentDocument.cancelReserve(currentMember);
                    if (result) {
                        System.out.println("La réservation a bien été annulée");
                    } else {
                        System.out.println("La réservation n'a pas pu être annulée");
                    }
                }

                case 9 -> System.out.println("Le nombre de documents empruntés est de " + Document.getBorrowedCount());

                case 11 -> System.out.println("Le nombre de documents dans la section spéciale réservations est de "
                        + Document.getWaitingReserveCount());

                case 10 -> System.out.println("Le nombre de documents retournés est de " + Document.getReturnedCount());

                default -> System.out.println("Veuillez entrer un nombre valide");
            }

        } while (choice != 0);

    }

    private static void printDocuments() {
        System.out.println("\nListe des documents disponibles :");
        System.out.println("1 - " + JAVA);
        System.out.println("2 - " + DATA);
    }

    private static void printMembers() {
        System.out.println("\nListe des membres :");
        System.out.println("1 - " + JOHN);
        System.out.println("2 - " + BOB);
    }

    private static Document getDocument() {

        printDocuments();
        int choice;
        System.out.println("Quel document souhaitez-vous choisir ?");

        choice = SCANNER.nextInt();
        SCANNER.nextLine();

        Document currentDocument = JAVA;
        if (choice == 2) {
            currentDocument = DATA;
        }

        return currentDocument;
    }

    private static Member getMember() {

        printMembers();
        int choice;
        System.out.println("Qui êtes-vous ?");

        choice = SCANNER.nextInt();
        SCANNER.nextLine();

        Member currentMember = JOHN;
        if (choice == 2) {
            currentMember = BOB;
        }

        return currentMember;
    }

}
