package com.charan.UPS_Trainer_Programs;

import java.util.*;
public class Frequency {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] starr;
        starr=str.split(" ");

        Map<String, Integer> mp = new HashMap<>();
         for (String j : starr) {
            if (mp.containsKey(j)) {
                mp.put(j, mp.get(j) + 1);
            } else {
                mp.put(j, 1);
            }
        }
        System.out.println(mp);
    }
}
