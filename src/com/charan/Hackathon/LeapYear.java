package com.charan.Hackathon;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Year: ");
        int year= sc.nextInt();
        System.out.println(leapyearChecker(year));
    }
    static String leapyearChecker(int year){
        if(year<0){
            return (year+" : Invalid Year");

        }
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return(year+ " : Leap Year");
        }

        else {
            return(year+ " : Not a Leap Year");
        }
    }
}
