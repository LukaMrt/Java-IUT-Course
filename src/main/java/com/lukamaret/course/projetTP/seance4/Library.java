package com.lukamaret.course.projetTP.seance4;

import java.util.Scanner;

public class Library {

    private static final CatalogueBibliotheque CATALOGUE = new CatalogueBibliotheque();
    private static final ListeMembres MEMBERS = new ListeMembres();

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        CATALOGUE.add(new DocBibliotheque("004. 178 K20PM", "Introduction à Java", "J. Leblanc", 2015));
        CATALOGUE.add(new DocBibliotheque("967. 4987 T248O", "Structures de Données", "M. Machin", 2017));
        CATALOGUE.add(new DocBibliotheque("967. 4447 TK48O", "Cours de C", "S. Dubard", 2020));
        CATALOGUE.add(new DocBibliotheque("117. 4937 UI489", "Etudes des algorithmes", "G. Lauriol", 2019));

        MEMBERS.addMember(new MembreBibliotheque("John", "Doe", "1111111111", "1 rue de la paix"));
        MEMBERS.addMember(new MembreBibliotheque("Bob", "Dupond", "2222222222", "2 rue de la paix"));

        int choice;
        boolean result;
        int currentDocBibliotheque;
        MembreBibliotheque currentMember;

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
            System.out.println("12 - Afficher les documents empruntés");


            System.out.print("\nQue souhaitez-vous faire ? ");
            choice = SCANNER.nextInt();
            SCANNER.nextLine();

            switch (choice) {

                case 0 -> System.out.println("Au revoir !");

                case 1 -> printDocuments();

                case 2 -> printMembers();

                case 3 -> {
                    currentDocBibliotheque = getDocument();
                    currentMember = getMember();
                    result = CATALOGUE.borrow(currentDocBibliotheque, currentMember);
                    if (result) {
                        System.out.println("Le document a bien été emprunté");
                    } else {
                        System.out.println("Le document n'a pas pu être emprunté");
                    }
                }

                case 4 -> {
                    currentDocBibliotheque = getDocument();
                    result = CATALOGUE.returnDocument(currentDocBibliotheque);
                    if (result) {
                        System.out.println("Le document a bien été rendu");
                    } else {
                        System.out.println("Le document n'a pas pu être rendu");
                    }
                }

                case 5 -> {
                    currentDocBibliotheque = getDocument();
                    result = CATALOGUE.store(currentDocBibliotheque);
                    if (result) {
                        System.out.println("Le document a bien été rangé");
                    } else {
                        System.out.println("Le document n'a pas pu être rangé");
                    }
                }

                case 6 -> {
                    currentDocBibliotheque = getDocument();
                    DocBibliotheque docBibliotheque = CATALOGUE.get(currentDocBibliotheque);
                    System.out.println("Le livre " + docBibliotheque.getTitle() + " est écrit par "
                            + docBibliotheque.getAuthor() + ". Il est actuellement " + docBibliotheque.getStatus());
                }

                case 7 -> {
                    currentDocBibliotheque = getDocument();
                    currentMember = getMember();
                    result = CATALOGUE.reserve(currentDocBibliotheque, currentMember);
                    if (result) {
                        System.out.println("Le document a bien été réservé");
                    } else {
                        System.out.println("Le document n'a pas pu être réservé");
                    }
                }

                case 8 -> {
                    currentDocBibliotheque = getDocument();
                    currentMember = getMember();
                    result = CATALOGUE.cancelReservation(currentDocBibliotheque, currentMember);
                    if (result) {
                        System.out.println("La réservation a bien été annulée");
                    } else {
                        System.out.println("La réservation n'a pas pu être annulée");
                    }
                }

                case 9 -> System.out.println("Le nombre de documents empruntés est de " + DocBibliotheque.getBorrowedCount());

                case 10 -> System.out.println("Le nombre de documents retournés est de " + DocBibliotheque.getReturnedCount());

                case 11 -> System.out.println("Le nombre de documents dans la section spéciale réservations est de "
                        + DocBibliotheque.getWaitingReserveCount());

                case 12 -> CATALOGUE.displayAllBorrowedDocuments();

                default -> System.out.println("Veuillez entrer un nombre valide");
            }

        } while (choice != 0);

    }

    private static void printDocuments() {
        System.out.println("\nListe des documents disponibles :");
        CATALOGUE.displayAllDocuments();
    }

    private static void printMembers() {
        System.out.println("\nListe des membres :");
        MEMBERS.displayMembers();
    }

    private static int getDocument() {

        printDocuments();
        int choice;
        System.out.println("Quel document souhaitez-vous choisir ?");

        choice = SCANNER.nextInt();
        SCANNER.nextLine();

        return choice;
    }

    private static MembreBibliotheque getMember() {

        printMembers();
        int choice;
        System.out.println("Qui êtes-vous ?");

        choice = SCANNER.nextInt();
        SCANNER.nextLine();

        return MEMBERS.getMember(choice - 1);
    }

}
