package LeetCode;

import java.util.*;

/**
 * Created by Ben_Big on 11/22/16.
 */

/*
140. Word Break II   QuestionEditorial Solution  My Submissions
Total Accepted: 72710
Total Submissions: 334172
Difficulty: Hard
Contributors: Admin
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 */


public class WordBreakII {
    HashSet<Integer> wordSizes=new HashSet<>();
    Set<String> wordDict=new HashSet<>();
    HashMap<String,ArrayList<String>> stringToSentence=new HashMap<>();
    Set<Integer> charDict=new HashSet<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String> result=new ArrayList<>();
        if (s.length()==0) {
            result.add(s);
            return result;
        }
        for (String word : wordDict){
            wordSizes.add(word.length());
            for (int i=0;i<word.length();i++){
                charDict.add((int)word.charAt(i));
            }
        }
        for (int i=0;i<s.length();i++){
            if (!charDict.contains((int)s.charAt(i))) return result;
        }
        this.wordDict=wordDict;
        return stringProcessor(s);
    }

    private ArrayList<String> stringProcessor(String str){
        if (stringToSentence.containsKey(str)){
            return stringToSentence.get(str);
        }
        ArrayList<String> returnValue=new ArrayList<>();
        for (int size : wordSizes){
            if (size==str.length() && wordDict.contains(str)){
                returnValue.add(str);
                continue;
            }
            else if (size>str.length()){
                continue;
            }
            String sub=str.substring(0,size);
            String rest=str.substring(size);
            if (!wordDict.contains(sub)) continue;
            ArrayList<String> combinationForRest=stringProcessor(rest);
            if (combinationForRest.size()==0) continue;
            for (String combination : combinationForRest){
                returnValue.add(sub+" "+combination);
            }
        }
        stringToSentence.put(str,returnValue);
        return returnValue;
    }
    public static void main(String[]args){
        String test1="catsanddog";
        Set<String> dict1=new HashSet<>();
        dict1.add("cat");dict1.add("cats");dict1.add("and");dict1.add("sand");dict1.add("dog");

        WordBreakII wb=new WordBreakII();
        System.out.println(wb.wordBreak(test1,dict1));

    }
}