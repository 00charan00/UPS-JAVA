package com.charan.UPS_Trainer_Programs;

import java.util.Comparator;
import java.util.TreeSet;

class Student {
    int id;
    String name;
    int grade;

    public Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }


    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Grade=" + grade + "]\n";
    }
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.grade != s2.grade) {
            return s2.grade - s1.grade;
        }
        return s1.name.compareTo(s2.name);
    }
}

public class StudentTreeSet {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>(new StudentComparator());


        students.add(new Student(2, "Vishnu", 85));
        students.add(new Student(3, "Shiva", 95));
        students.add(new Student(1, "Sen", 98));
        students.add(new Student(5, "Vishwa", 85));

        System.out.println(students);
    }
}
