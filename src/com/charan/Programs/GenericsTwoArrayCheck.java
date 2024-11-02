package com.charan.Programs;

import java.util.*;

public class GenericsTwoArrayCheck {

    public static <T> boolean genericCheck(T[] array1, T[] array2) {
        if (array1 == array2) {
            return true;
        }

        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }

        return Arrays.equals(array1, array2);
    }

    public static void main(String[] args) {
        Object[] objarr1={1,2,"hello"};
        Object[] objarr2={1,2,"hello"};
        System.out.println(genericCheck(objarr1, objarr2));
    }

}
