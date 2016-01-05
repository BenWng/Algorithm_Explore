package Cracking_Interview.Ch1_Arrays_And_String;
import java.util.*;
/**
 * Created by Ben_Big on 1/5/16.
 */

// TODO: Redo


/**
 *  Is Unique: Implement an algorithm to determine
 *  if a string has an unique characters.
 *  What If you cannot use additional data structures?
 */


/**
 *  Reviews: I completely misunderstood what the question is
 *  asking,
 */



public class Q_1_1 {
    /*
    public static void main(String args[]){
        String testSubject="Hello World";
        String [] letters={"H","o", "l"};
        System.out.println(ContainsAll(testSubject,letters));
    }
    public static boolean ContainsAll(String s, String [] l ){
        String [] sArray=s.split("(?!^)");
        HashSet<String> sHash=new HashSet<String>();
        for(String sElem: sArray){
            sHash.add(sElem);
        }
        for(String lElem: l){
            if (! sHash.contains(lElem)){
                return false;
            }
        }
        return true;
    }*/

    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }


    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }

    /*
    public static boolean isUniqueChars(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';

            // 1<< val: val=3 -> 1000, val=5 -> 100000

            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val); // this is equal to checker = checker | (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }
   */
}
