package com.charan.Programs;

import java.util.*;

public class HotelCheckin {
    private Set<Integer> hmap = new HashSet<>();

    public void checkIn(int id) {
        hmap.add(id);
    }

    public boolean isCheckedIn(int id) {
        return hmap.contains(id);
    }

    public void removeCheckIn(int id) {
        hmap.remove(id);
    }

    public void displayAllCheckedIn() {
        System.out.println("Inside: " + hmap);
    }

    public static void main(String[] args) {
        HotelCheckin obj = new HotelCheckin();

        obj.checkIn(1);
        obj.checkIn(2);
        obj.checkIn(3);
        obj.displayAllCheckedIn();

    }
}
