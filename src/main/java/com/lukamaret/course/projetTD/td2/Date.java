package com.lukamaret.course.projetTD.td2;

public class Date {

    private int day;
    private int month;
    private int year;

    public String formattedDate() {
        return day + "/" + month + "/" + year;
//        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
