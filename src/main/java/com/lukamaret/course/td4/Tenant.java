package com.lukamaret.course.td4;

public class Tenant {

    private final String firstName;
    private final String lastName;
    private final String address;
    private double amount;
    private House house;

    public Tenant(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.amount = 0;
    }

    public void rent(House house) {
        this.house = house;
        this.amount = house.getArea() * house.getAreaPrice();
    }

    public void freeRent() {
        this.house = null;
        this.amount = 0;
    }

    public boolean isRenter(House house) {
        return this.house == house;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", house=" + house +
                '}';
    }

}
