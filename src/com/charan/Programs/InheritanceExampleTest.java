package com.charan.Programs;


abstract class Vehicle {
    abstract void start();
    abstract void stop();
    void fuelType(){

    }


}
class Car extends Vehicle {
    public void start() {
        System.out.println("Car start");
    }
    public void stop() {
        System.out.println("Car stop");
    }
    public void fuelType() {
        System.out.println("Car fuel Type");
    }
}

class Bike extends Vehicle {
    public void start() {
        System.out.println("bike start");

    }
    public void stop() {
        System.out.println("bike stop");
    }
}

class main{
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.stop();
        car.fuelType();
        Bike bike = new Bike();
        bike.start();
        bike.stop();
    }
}
