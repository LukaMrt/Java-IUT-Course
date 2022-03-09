package com.lukamaret.course.td5;

import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        Owner owner1 = new Owner("Mathis", "Toinon", "INSA", true, 130);
        Owner owner2 = new Owner("Melvyn", "Delpree", "FAC", true, 100);

        Tenant tenant1 = new Tenant("Luka", "Maret", "IUT");
        Tenant tenant2 = new Tenant("Vincent", "Chavot", "IUT");

        House house1 = new House("house 1", 100, 10, owner1);
        House house2 = new House("house 2", 97, 9, owner1);

        Agency agency = new Agency(10);
        agency.addHouse(house1);
        agency.addHouse(house2);

        System.out.println(agency.searchById(1));
        System.out.println(agency.searchById(2));

        agency.printHouses();

        System.out.println(agency.removeById(1));

        agency.printHouses();

        owner1.addPrimaryAddress(house1);
        owner1.addSecondAddress(house2);

        house1.rent(tenant1);
        tenant1.rent(house1);

        house2.onSale();
        house2.sell(owner2);
        house2.rent(tenant2);
        tenant2.rent(house2);
        owner2.removeSecondaryAddress();

        house1.freeRent();
        tenant1.freeRent();

        String entry = "";

        while (!entry.equals("exit")) {

            System.out.println("Menu :");
            System.out.println("1 : Display house information");
            System.out.println("2 : Display tenant information");
            System.out.println("3 : Display owner information");
            System.out.println("4 : House status");
            System.out.println("5 : Change house status");

            entry = SCANNER.nextLine();

            switch (entry) {

                case "1":
                    System.out.println("Enter house number (1 or 2) :");
                    System.out.println((SCANNER.nextLine().equals("1") ? house1 : house2));
                    break;

                case "2":
                    System.out.println("Enter tenant number (1 or 2) :");
                    System.out.println((SCANNER.nextLine().equals("1") ? tenant1 : tenant2));
                    break;

                case "3":
                    System.out.println("Enter owner number (1 or 2) :");
                    System.out.println((SCANNER.nextLine().equals("1") ? owner1 : owner2));
                    break;

                case "4":
                    System.out.println("Enter house number (1 or 2) :");
                    House house = (SCANNER.nextLine().equals("1") ? house1 : house2);
                    if (tenant1.isRenter(house) || tenant2.isRenter(house)) {
                        System.out.println("House is rented");
                        break;
                    }
                    if (house.isOwnedBy(owner1) || house.isOwnedBy(owner2)) {
                        System.out.println("House is rented");
                        break;
                    }
                    System.out.println("House is available");
                    break;

                case "5":
                    System.out.println("Enter house number (1 or 2) :");
                    house = (SCANNER.nextLine().equals("1") ? house1 : house2);

                    System.out.println("Enter the action (rent or sell) :");
                    String action = SCANNER.nextLine();

                    if (action.equals("rent")) {
                        System.out.println("Enter the tenant number (1 or 2) :");
                        Tenant tenant = (SCANNER.nextLine().equals("1") ? tenant1 : tenant2);
                        house.rent(tenant);
                        tenant.rent(house);
                        break;
                    }

                    if (action.equals("sell")) {
                        System.out.println("Enter the owner number (1 or 2) :");
                        Owner owner = (SCANNER.nextLine().equals("1") ? owner1 : owner2);
                        house.sell(owner);
                        owner.addPrimaryAddress(house);
                        break;
                    }

            }

            System.out.println();

        }

    }

}
