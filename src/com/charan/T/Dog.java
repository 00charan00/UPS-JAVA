package com.charan.T;

// Define the Animal interface
interface Animal {
    // Abstract method
    void bark();
}

// Dog class implementing the Animal interface
class Dogs implements Animal {
    // Override the bark method
    @Override
    public void bark() {
        System.out.println("Dog is barking");
    }
}

// Main class to test the implementation
public class Dog {
    public static void main(String[] args) {
        // Create an instance of Dog
        Animal obj = new Dogs();

        // Call the bark method
        obj.bark();
    }
}
