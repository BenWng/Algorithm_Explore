package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

/*
340. Longest Substring with At Most K Distinct Characters
Total Accepted: 11962
Total Submissions: 30929
Difficulty: Hard
Contributors: Admin
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.
 */


/**
 * Created by Ben_Big on 11/20/16.
 */
public class LongestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Integer,TreeSet<Integer>> charToOccurances=new HashMap<>();
        for (int i=0;i<s.length();i++){
            int character=(int)s.charAt(i);
            if (charToOccurances.containsKey(character)){
                TreeSet<Integer>Occurances=charToOccurances.get(character);
                Occurances.add(i);
            }
            else{
                TreeSet<Integer>newOccurances= new TreeSet<>();
                newOccurances.add(i);
                charToOccurances.put(character,newOccurances);
            }
        }
        int result=0;
        int headPointer=0;
        int tailPointer=0;
        int numDistinctCharactersInBetween=1;
        while(headPointer<s.length() && tailPointer<s.length() && numDistinctCharactersInBetween<=k){
            int len=tailPointer-headPointer+1;
            result=result>len?result:len;
            if (tailPointer==s.length()-1){
                break;
            }
            tailPointer++;
            int characterAtTail=(int) s.charAt(tailPointer);
            SortedSet<Integer> occurancesInBetween=charToOccurances.get(characterAtTail).subSet(headPointer,tailPointer);
            if (numDistinctCharactersInBetween<k){
                if (occurancesInBetween.isEmpty()){
                    numDistinctCharactersInBetween++;
                }
            }
            else if (numDistinctCharactersInBetween==k){
                if (!occurancesInBetween.isEmpty()){
                    continue;
                }
                numDistinctCharactersInBetween++;
                while(numDistinctCharactersInBetween>k){
                    int characterAtPreviousHead=(int) s.charAt(headPointer);
                    headPointer++;
                    SortedSet<Integer> newOccurancesInBetween=charToOccurances.get(characterAtPreviousHead).subSet(headPointer,tailPointer);
                    if(newOccurancesInBetween.isEmpty()) numDistinctCharactersInBetween--;
                }
            }
        }
        return result;
    }


    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        if (s.isEmpty() || k==0){
            return 0;
        }

        HashMap<Integer,LinkedList<Integer>> charToOccurances=new HashMap<>();

        int result=0;
        int headPointer=0;
        int tailPointer=0;
        int numDistinctCharactersInBetween=1;

        int firstCharacter=(int) s.charAt(0);
        LinkedList<Integer> firstOccurance=new LinkedList<>();
        firstOccurance.addLast(0);
        charToOccurances.put(firstCharacter,firstOccurance);


        while(headPointer<s.length() && tailPointer<s.length() && numDistinctCharactersInBetween<=k){
            int len=tailPointer-headPointer+1;
            result=result>len?result:len;
            if (tailPointer==s.length()-1){
                break;
            }
            tailPointer++;
            int characterAtTail=(int) s.charAt(tailPointer);
            LinkedList<Integer> occurancesInBetween=charToOccurances.get(characterAtTail);
            if (occurancesInBetween==null){
                occurancesInBetween=new LinkedList<>();
                occurancesInBetween.addLast(tailPointer);
                charToOccurances.put(characterAtTail,occurancesInBetween);
            }
            else{
                occurancesInBetween.addLast(tailPointer);
            }
            if (numDistinctCharactersInBetween<k){
                if (occurancesInBetween.size()==1){
                    numDistinctCharactersInBetween++;
                }
            }
            else if (numDistinctCharactersInBetween==k){
                if (occurancesInBetween.size()>1){
                    continue;
                }
                numDistinctCharactersInBetween++;
                while(numDistinctCharactersInBetween>k){
                    int characterAtPreviousHead=(int) s.charAt(headPointer);
                    headPointer++;
                    LinkedList newOccurancesInBetween=charToOccurances.get(characterAtPreviousHead);
                    newOccurancesInBetween.removeFirst();
                    if (newOccurancesInBetween.size()==0){
                        numDistinctCharactersInBetween--;
                        charToOccurances.remove(characterAtPreviousHead);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[]args){
        LongestSubstringwithAtMostKDistinctCharacters lsam=new LongestSubstringwithAtMostKDistinctCharacters();
        System.out.println(lsam.lengthOfLongestSubstringKDistinct2("",2));
    }

}
