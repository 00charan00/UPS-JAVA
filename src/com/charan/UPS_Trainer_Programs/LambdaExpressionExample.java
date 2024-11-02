package com.charan.UPS_Trainer_Programs;


interface MyFunctionalInterface {
    void displayMessage();
}

public class LambdaExpressionExample {
    public static void main(String[] args) {
        MyFunctionalInterface message = () -> {
            System.out.println("Hello World");
        };
        message.displayMessage();
    }
}
