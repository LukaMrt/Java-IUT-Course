package com.lukamaret.course.projetTD.td5;

public class Agency {

    private final int count;
    private final House[] houses;

    public Agency(int count) {
        this.count = count;
        houses = new House[count];
    }

    public boolean addHouse(House house) {
        for (int i = 0; i < count; i++) {
            if (houses[i] == null) {
                houses[i] = house;
                return true;
            }
        }
        return false;
    }

    public void printHouses() {
        for (int i = 0; i < count; i++) {
            if (houses[i] != null) {
                System.out.println(houses[i]);
            }
        }
    }

    public int searchById(int houseId) {
        for (int i = 0; i < count; i++) {
            if (houses[i] != null && houses[i].getHouseId() == houseId) {
                return i;
            }
        }
        return -1;
    }

    public int removeById(int houseId) {
        for (int i = 0; i < count; i++) {
            if (houses[i] != null && houses[i].getHouseId() == houseId) {
                houses[i] = null;
                return i;
            }
        }
        return -1;
    }


}
