package LeetCode;

import java.util.*;

/**
 * Created by ben on 1/13/16.
 */

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 */



public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        //inner class to decide if second string can be converted to from the first string
        class connected{
            boolean connected(String first, String second){
                char[] f=first.toCharArray();
                char[] g=second.toCharArray();
                int unequal=0;
                boolean result=false;
                for(int i=0;i<f.length;i++){
                    if(f[i]!=g[i]){
                        unequal++;
                    }
                }
                if(unequal==1){
                    result=true;
                }
                return result;
            }
        }

        Queue <String> queue=new LinkedList<>();
        queue.add(beginWord);
        wordList.remove(beginWord);
        wordList.remove(endWord);
        LinkedList<String> wordDict=new LinkedList<>(wordList);

        int stepNum=0;

        if (beginWord.equals(endWord)){
            stepNum=1;
            return stepNum;
        }

        connected con=new connected();

        //build the map(tree) and breath first search at the same time
        while(queue.peek()!=null){
            String top=queue.poll();
            if(!wordList.isEmpty()){
                Iterator<String> itr=wordDict.linkedIterator();
                boolean newLayerFlag=false;
                while(itr.hasNext()){
                    String child=itr.next();
                    wordList.remove(child);
                    if(child.equals(endWord)){
                        return ++stepNum;
                    }

                    if(con.connected(top,child)){
                        newLayerFlag=true;
                        queue.add(child);
                    }
                }
                if(newLayerFlag){
                    stepNum++;
                }
            }
        }
        return stepNum;
    }
    public static void main(String[] args){
        String [] wordList ={"hot","dot","dog","lot","log"};
        Set<String> wordList2=new HashSet<String>(Arrays.asList(wordList));
        String beginWord="hit";
        String endWord="cog";
        System.out.println(ladderLength(beginWord,endWord,wordList2));
    }
}
