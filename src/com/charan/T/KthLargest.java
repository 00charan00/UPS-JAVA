package com.charan.T;

import java.util.Arrays;
import java.util.Scanner;

public class KthLargest {
    public static int findKthLargest(int[] array, int k) {
        Arrays.sort(array);
        return array[array.length - k];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        if (k > 0 && k <= n) {
            int result = findKthLargest(array, k);
            System.out.println("The " + k + "th largest element is: " + result);
        } else {
            System.out.println("Invalid value of k.");
        }
    }
}