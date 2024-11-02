package com.charan.Hackathon;
import java.util.*;
public class Coin_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount: ");
        int num = sc.nextInt();
        System.out.print("Enter the no of Denominations: ");
        int n = sc.nextInt();
        System.out.print("Enter the Denominations: ");
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        int count = 0;
        Collections.sort(list);
        for(int i=list.size()-1;i>=0;i--){
            int val = list.get(i);
            if(num==0){
                break;
            }
            if(num%val==0){
                count += (num/val);
                break;
            }
            else{
                count+=(num/val);
                num = num%val;
            }
        }
        if(count==0||num>0){
            System.out.println("Not Possible");
        }
        else{
            System.out.println("Total Count: "+count);
        }
    }
}