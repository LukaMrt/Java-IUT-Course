package com.lukamaret.course.td3;

public class Main {

    public static void main(String[] args) {

        Owner owner1 = new Owner("Mathis", "Toinon", "INSA", true, 130);
        Owner owner2 = new Owner("Melvyn", "Delpree", "FAC", true, 100);

        Tenant tenant1 = new Tenant("Luka", "Maret", "IUT");
        Tenant tenant2 = new Tenant("Vincent", "Chavot", "IUT");

        House house1 = new House("house 1", 100, 10, owner1);
        House house2 = new House("house 2", 97, 9, owner1);

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

    }

}
