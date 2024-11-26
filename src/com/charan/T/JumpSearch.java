package com.charan.T;

public class JumpSearch {

    // Method to perform Jump Search
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n)); // Block size to jump
        int prev = 0;

        // Finding the block where the target may be present
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1; // Target not found
            }
        }

        // Perform linear search in the identified block
        while (arr[prev] < target) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1; // Target not found
            }
        }

        // Check if the target is found
        if (arr[prev] == target) {
            return prev; // Return the index of the target
        }

        return -1; // Target not found
    }

    // Main method to test the Jump Search
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 15;

        int index = jumpSearch(sortedArray, target);

        if (index != -1) {
            System.out.println("Element " + target + " is found at index: " + index);
        } else {
            System.out.println("Element " + target + " is not found in the array.");
        }
    }
}
