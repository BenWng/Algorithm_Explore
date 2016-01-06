package Cracking_Interview.Ch1_Arrays_And_String;
import java.util.*;

/**
 * Created by Ben_Big on 1/5/16.
 */

/**
 * Check Permutation: Given two strings, write a method to decide if one ls a permutation of the other.
 */

/**
 * Reviews: Permutation means any combination
 */


public class Q_1_2 {
    public static void main(String args[]){

        System.out.println(permutation("hello","eolHL"));
    }

    private static char[] sort(String arg1){
        char [] charArr=arg1.toCharArray();
        Arrays.sort(charArr);
        return charArr;
    }

    private static boolean permutation (String arg1, String arg2){
        return Arrays.equals(sort(arg1.toLowerCase()),sort(arg2.toLowerCase()));
    }

}
