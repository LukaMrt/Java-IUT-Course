package com.lukamaret.course.projetTD.td6;

public class ImmobilisationHouse extends House {

    private final float price;

    public ImmobilisationHouse(String description, int area, int areaPrice, Owner owner, float price) {
        super(description, area, areaPrice, owner);
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ImmobilisationHouse{" +
                "price=" + price +"'," +
                "house=" + super.toString() +
                '}';
    }

}
