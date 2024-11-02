package com.charan.UPS_Trainer_Programs;

import java.util.ArrayList;

public class StreamCount {
    public static void main(String[] args) {
        ArrayList<Integer> lst=new ArrayList<>();
        lst.add(4);
        lst.add(8);
        lst.add(9);
        lst.add(10);
        System.out.println(lst.stream().count());
    }
}