package com.charan.UPS_Trainer_Programs;

import java.util.Scanner;

public class PalindromeMinimum {
    public static int countPalindromicSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += expandAroundCenter(s, i, i);
            count += expandAroundCenter(s, i, i + 1);
        }

        return count;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int count = 0;


        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter String: ");
        String input = sc.next();
        int result = countPalindromicSubstrings(input);
        System.out.println("Total palindromic substrings: " + result);
    }
}
