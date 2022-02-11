package com.lukamaret.course.tp2;

public class House {

    private static int id = 1;

    private int houseId;
    private String description;
    private int area;
    private boolean rented;
    private boolean onSale;
    private int areaPrice;

    public House(String description, int area, boolean rented, boolean onSale, int areaPrice) {
        this.houseId = House.id++;
        this.description = description;
        this.area = area;
        this.rented = rented;
        this.onSale = onSale;
        this.areaPrice = areaPrice;
    }

    public double computeTax(float localRate) {
        return Math.round(area * areaPrice * localRate * 300.0) / 100.0;
    }

    public static int compareTaxes(double tax1, double tax2) {

        if (tax1 > tax2) {
            return 1;
        }

        if (tax1 == tax2) {
            return 0;
        }

        return -1;
//        return Double.compare(tax1, tax2);
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        House.id = id;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public int getAreaPrice() {
        return areaPrice;
    }

    public void setAreaPrice(int areaPrice) {
        this.areaPrice = areaPrice;
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
                "}";
    }

}
