package com.lukamaret.course.projetTD.td6;

public class InvestmentHouse extends House {

    private final float taxReduction;

    public InvestmentHouse(String description, int area, int areaPrice, Owner owner, float taxReduction) {
        super(description, area, areaPrice, owner);
        this.taxReduction = taxReduction;
    }

    public float getTaxReduction() {
        return taxReduction;
    }

    @Override
    public String toString() {
        return "InvestmentHouse{" +
                "taxReduction=" + taxReduction +"'," +
                "house=" + super.toString() +
                '}';
    }

}
