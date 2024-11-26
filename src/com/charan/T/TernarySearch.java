package com.charan.T;

import java.util.Arrays;
import java.util.Scanner;

public class TernarySearch {
    public static int ternarySearch(int[] arr, int target, int l, int r) {
        while(l<=r){
            int mid1=l+(r-l)/3;
            int mid2=r-(r-l)/3;

            if(arr[mid1]==target) return mid1;
            if(arr[mid2]==target) return mid2;

            if(target<arr[mid1]){
                r=mid1-1;

            }
            else if(target>arr[mid2]){
                l=mid2+1;
            }
            else {
                r=mid2-1;
                l=mid1+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();

        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i]= sc.nextInt();
        }
        int target = sc.nextInt();
        Arrays.sort(arr);

        int index = ternarySearch(arr, target, 0, arr.length - 1);

        if (index != -1) {
            System.out.println("Target found at index: " + index);
        } else {
            System.out.println("Target not found!");
        }
    }
}
