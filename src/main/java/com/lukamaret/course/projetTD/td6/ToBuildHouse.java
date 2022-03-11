package com.lukamaret.course.projetTD.td6;

public class ToBuildHouse extends House {

    private final boolean viable;
    private final float priceToViable;

    public ToBuildHouse(String description, int area, int areaPrice, Owner owner, boolean viable, float priceToViable) {
        super(description, area, areaPrice, owner);
        this.viable = viable;
        this.priceToViable = priceToViable;
        this.tenant = null;
    }

    @Override
    public double computeTax(float localRate) {
        return Math.round(area * areaPrice * localRate * 300.0 * 1.25 * 10 * super.area) / 100.0;
    }

    @Override
    public void rent(Tenant tenant) {
    }

    public boolean isViable() {
        return viable;
    }

    public float getPriceToViable() {
        return priceToViable;
    }

    @Override
    public String toString() {
        return "ToBuildHouse{" +
                "viable=" + viable +
                ", priceToViable=" + priceToViable +"'," +
                "house=" + super.toString() +
                '}';
    }

}
