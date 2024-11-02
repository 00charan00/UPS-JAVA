package com.charan.Programs;

import java.util.*;

class SmallestSubarraySum {

    public static int smallestSubarrayWithSum(int[] arr, int x) {
        int n = arr.length;
        int minLength = n + 1;
        int start = 0;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];


            while (currentSum >= x) {
                minLength = Math.min(minLength, i - start + 1);
                currentSum -= arr[start];
                start++;
            }
        }

        return (minLength == n + 1) ? 0 : minLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int result = smallestSubarrayWithSum(arr, x);
        System.out.println(result);
    }
}

