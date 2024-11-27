package com.charan.T;

interface Animal {
    void bark();
}

class Dogs implements Animal {
    @Override
    public void bark() {
        System.out.println("Dog is barking");
    }
}

public class Dog {
    public static void main(String[] args) {
        Animal obj = new Dogs();

        obj.bark();
    }
}
