package com.lukamaret.course.TPBiblio;

public class Member {

    private static int id = 1;

    private final int memberId;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String address;


    public Member(String firstName, String lastName, String phone, String address) {
        this.memberId = id++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
