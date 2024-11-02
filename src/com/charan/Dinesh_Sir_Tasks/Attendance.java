package com.charan.Dinesh_Sir_Tasks;


import java.util.HashSet;
import java.util.Set;

public class Attendance {
    private Set<Integer> checkedInAttendees = new HashSet<>();

    public void checkIn(int id) {
        checkedInAttendees.add(id);
    }

    public boolean isCheckedIn(int id) {
        return checkedInAttendees.contains(id);
    }

    public void removeCheckIn(int id) {
        checkedInAttendees.remove(id);
    }

    public void displayAllCheckedIn() {
        System.out.println("Checked-in Attendees: " + checkedInAttendees);
    }

    public static void main(String[] args) {
        Attendance manager = new Attendance();

        manager.checkIn(101);
        manager.checkIn(102);
        manager.checkIn(103);

        System.out.println("Is attendee 101 checked in? " + manager.isCheckedIn(101));

//        manager.removeCheckIn(102);

        manager.displayAllCheckedIn();
    }
}
