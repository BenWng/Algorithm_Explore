package LeetCode;

import java.util.Arrays;
import java.util.*;

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
        LinkedList<String> list=new LinkedList<>(Arrays.asList(StringOnlyLetterNumber));
        Iterator itrFoward=list.iterator();
        Iterator itrBackward=list.descendingIterator();

    }
    public static void main(String[] agrs){

    }
}
