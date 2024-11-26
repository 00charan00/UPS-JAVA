package com.charan.Programs;

import java.util.*;

class Demo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int target=sc.nextInt();
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]= sc.nextInt();
        }
        Arrays.sort(arr);
        int index=ternary(arr,target,0,arr.length-1);
        if(index==-1){
            System.out.println("Not Found");
        }
        else{
            System.out.println("Element found at index "+ index);
        }
    }

    static int ternary(int[] arr,int target,int l,int r){
        while (l<=r){
            int m1=l+(r-l)/3;
            int m2=r-(r-l)/3;
            if(arr[m1]==target)return m1;
            if(arr[m2]==target)return m2;

            if(target<arr[m1]){
                r=m1-1;
            } else if (target>arr[m2]) {
                l=m2+1;
            }
            else{
                r=m2-1;
                l=m1+1;
            }
        }
        return -1;
    }
}
