package com.lukamaret.course.projetTD.td2;

public class Client {

    private String name;
    private String lastName;
    private String nationalId;

    public Client(String name, String lastName, String nationalId) {
        this.name = name;
        this.lastName = lastName;
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

}
