package com.charan.Programs;

public class GenericsSumEvenOdd {

    public static <T extends Number> void calculateSumEvenOdd(T[] array) {
        double sumEven = 0;
        double sumOdd = 0;

        for (T element : array) {
            int value = element.intValue();
            if (value % 2 == 0) {
                sumEven += value;
            } else {
                sumOdd += value;
            }
        }

        System.out.println("Even: " + sumEven);
        System.out.println("Odd:" + sumOdd);
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6};
        calculateSumEvenOdd(intArray);

        Double[] doubleArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        calculateSumEvenOdd(doubleArray);

        Long[] longArray = {10L, 15L, 20L, 25L};
        calculateSumEvenOdd(longArray);
    }
}
