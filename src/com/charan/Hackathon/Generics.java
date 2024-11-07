package com.charan.Hackathon;

import java.util.*;

class Box<t> {
    private t data;

    public Box(t data) {
        this.data = data;
    }

    public t getdata() {
        return data;
    }
}

class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Box<Integer> bi = new Box<>(n);
        System.out.println(bi.getdata());
        String str = sc.nextLine();
        Box<String> bs = new Box<>(str);
        System.out.println(bs.getdata());
    }
}