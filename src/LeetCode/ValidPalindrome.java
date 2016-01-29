package LeetCode;

import java.util.Arrays;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by ben on 1/14/16.
 */

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */


public class ValidPalindrome {
    static boolean isPalindrome(String s) {
        String[] StringOnlyLetterNumber=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase().split("");
        int ascendIndex=0;
        int descendIndex=StringOnlyLetterNumber.length-1;
        if (descendIndex==0){
            return true;
        }

        for(int i=0,j=ascendIndex,k=descendIndex;k>=j;i++,j=ascendIndex+i,k=descendIndex-i){
            if(!StringOnlyLetterNumber[j].equals(StringOnlyLetterNumber[k])){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] agrs){
        String test="A man, a plan, a canal: Panama";
        String test2="race a car";
        System.out.print(isPalindrome(test2));
    }
}
