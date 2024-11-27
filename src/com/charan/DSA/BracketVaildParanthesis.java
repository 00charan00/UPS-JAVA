package com.charan.DSA;

import java.util.ArrayList;
import java.util.Scanner;

public class BracketVaildParanthesis {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str= sc.next();
        chekerParanthesis(str);
    }
    public static void chekerParanthesis(String str){
        int count=0;
        int c=0,x=0;
        ArrayList<String> arrayList=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                arrayList.add("(");
            } else if (str.charAt(i)==')') {
                arrayList.removeFirst();
                count++;
                if(arrayList.isEmpty()){
                    x=Math.max(c,count);
                    c=count;
                    count=0;
                }
                System.out.println("C: "+x);
            }
        }
        System.out.println(x*2+":End");
        System.out.println(arrayList);


    }
}
