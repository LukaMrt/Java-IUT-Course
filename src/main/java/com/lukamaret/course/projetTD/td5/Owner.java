package com.lukamaret.course.projetTD.td5;

public class Owner {

    private final String firstName;
    private final String lastName;
    private String primaryAddress;
    private boolean secondAddress;
    private double livingTax;

    public Owner(String firstName, String lastName, String primaryAddress, boolean secondAddress, double livingTax) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryAddress = primaryAddress;
        this.secondAddress = secondAddress;
        this.livingTax = livingTax;
    }

    public void addPrimaryAddress(House house) {
        this.primaryAddress = house.getDescription();
    }

    public void addSecondAddress(House house) {
        this.secondAddress = true;
        this.livingTax = house.computeTax(0.14f);
    }

    public void removeSecondaryAddress() {
        this.secondAddress = false;
        this.livingTax = 0;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", primaryAddress='" + primaryAddress + '\'' +
                ", secondAddress=" + secondAddress +
                ", livingTax=" + livingTax +
                '}';
    }

}
