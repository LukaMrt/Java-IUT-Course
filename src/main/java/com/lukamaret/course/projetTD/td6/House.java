package com.lukamaret.course.projetTD.td6;

public class House {

    private static int id = 1;

    protected final int houseId;
    protected final String description;
    protected final int area;
    protected boolean rented;
    protected boolean onSale;
    protected final int areaPrice;
    protected Owner owner;
    protected Tenant tenant;

    public House(String description, int area, int areaPrice, Owner owner) {
        this.houseId = House.id++;
        this.description = description;
        this.area = area;
        this.rented = false;
        this.onSale = false;
        this.areaPrice = areaPrice;
        this.owner = owner;
    }

    public double computeTax(float localRate) {
        return Math.round(area * areaPrice * localRate * 300.0) / 100.0;
    }

    public void onSale() {
        this.onSale = true;
    }

    public void sell(Owner owner) {
        this.owner = owner;
        this.onSale = false;
    }

    public void freeRent() {
        this.rented = false;
    }

    public void rent(Tenant tenant) {
        this.tenant = tenant;
        this.rented = true;
    }

    public int getArea() {
        return area;
    }

    public int getAreaPrice() {
        return areaPrice;
    }

    public String getDescription() {
        return description;
    }

    public boolean isOwnedBy(Owner owner1) {
        return this.owner == owner1;
    }

    public int getHouseId() {
        return houseId;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseId=" + houseId +
                ", description='" + description + '\'' +
                ", area=" + area +
                ", rented=" + rented +
                ", onSale=" + onSale +
                ", areaPrice=" + areaPrice +
                ", owner=" + owner +
                ", tenant=" + tenant +
                '}';
    }

}
