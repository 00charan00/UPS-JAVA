package com.charan.Hackathon;

import java.util.*;

class Box<T> {
    private T data;

    public Box(T data) {
        this.data = data;
    }

    public T getdata() {
        return data;
    }
}

class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Box<Integer> bi = new Box<>(n);
        System.out.println(bi.getdata());
        String str = sc.nextLine();
        Box<String> bs = new Box<>(str);
        System.out.println(bs.getdata());
    }
}