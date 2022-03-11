package com.lukamaret.course.projetTD.td2;

public class Main {

    public static void main(String[] args) {

        House house1 = new House("Maison 1", 100, false, true, 14);
        House house2 = new House("Maison 2", 77, true, false, 15);

        double tax1 = house1.computeTax(0.24F);
        double tax2 = house2.computeTax(0.21F);

        int compare = house1.compareTaxes(house2, 0.24F);

        System.out.println("Maison 1 : " + tax1);
        System.out.println("Maison 2 : " + tax2);

        if (compare == 0) {
            System.out.println("Les taxes sont égales");
        } else if (compare > 0) {
            System.out.println("La taxe de la maison 1 est plus élevée");
        } else {
            System.out.println("La taxe de la maison 2 est plus élevée");
        }

        System.out.println(house1.getDescription());

    }

}
