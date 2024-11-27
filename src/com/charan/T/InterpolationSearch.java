package com.charan.T;

public class InterpolationSearch {
    public static int interpolationSearch(int[] array, int low, int high, int key) {
        while (low <= high && key >= array[low] && key <= array[high]) {
            int pos = low + ((key - array[low]) * (high - low)) / (array[high] - array[low]);

            if (array[pos] == key) {
                return pos;
            } else if (array[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int key = 30;
        int result = interpolationSearch(array, 0, array.length - 1, key);
        System.out.println(result != -1 ? "Element found at index " + result : "Element not found");
    }
}

