package com.lukamaret.course.projetTD.td6;

public class CommercialHouse extends House {

    private final String usage;

    public CommercialHouse(String description, int area, int areaPrice, Owner owner, String usage) {
        super(description, area, areaPrice, owner);
        this.usage = usage;
    }

    public String getUsage() {
        return usage;
    }

    @Override
    public String toString() {
        return "CommercialHouse{" +
                "usage='" + usage + "'," +
                "house=" + super.toString() +
                '}';
    }

}
