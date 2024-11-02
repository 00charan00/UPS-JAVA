package com.charan.Dinesh_Sir_Tasks;

import java.util.*;

class Box<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> get() {
        return items;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.add(123);
        integerBox.add(515);
        integerBox.add(55);
        System.out.println("Integer Box contains: " + integerBox.get());

        Box<String> stringBox = new Box<>();
        stringBox.add("Hello, Generics!");
        System.out.println("String Box contains: " + stringBox.get());
    }
}
