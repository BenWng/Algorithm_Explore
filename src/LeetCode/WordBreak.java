package LeetCode;
import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by ben on 2/16/16.
 */

/**139.
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */

//ToDo: needs to be revisited

/*
//Recursive Solution:

public class  WordBreak{
    HashMap<Integer,LinkedList<String>> firstLetterTable =new HashMap<>();
    HashMap<Integer,Boolean> recursiveResult=new HashMap<>();

    public boolean wordBreak(String s, Set<String> wordDict) {
        Iterator<String> itr=wordDict.iterator();
        while (itr.hasNext()){
            String word=itr.next();
            LinkedList<String> bucket=firstLetterTable.get((int)word.charAt(0));
            if (bucket!=null){
                bucket.add(word);
            }
            else{
                bucket=new LinkedList<>();
                bucket.add(word);
                firstLetterTable.put((int)word.charAt(0),bucket);
            }
        }

        return recursiveCall(s);
    }

    public boolean recursiveCall(String s){
        if (recursiveResult.containsKey(s.length())){
            return recursiveResult.get(s.length()).booleanValue();
        }
        LinkedList<String>bucket=firstLetterTable.get((int)s.charAt(0));
        boolean result=false;
        if (bucket==null){
            return false;
        }
        Iterator<String> itr=bucket.iterator();
        while(result==false && itr.hasNext()){
            String word=itr.next();
            if (word.length()<=s.length()){
                boolean match=false;
                for (int i=0;i<=word.length();i++){
                    if (i==word.length()){
                        match=true;
                        break;
                    }
                    if(word.charAt(i)!=s.charAt(i)){
                        break;
                    }
                }
                if (match){
                    if (s.length()==word.length()){
                        return true;
                    }
                    result=result || recursiveCall(s.substring(word.length()));
                }
            }
        }
        recursiveResult.put(s.length(),result);
        return result;
    }
    public static void main(String[] args){
        WordBreak wb=new WordBreak();
        String test1="LLLLL";
        HashSet test1Set=new HashSet();
        test1Set.add("LO");test1Set.add("L");
        //test1Set.add("LeetCode");test1Set.add("Coe");test1Set.add("Codke");
        System.out.println(wb.wordBreak(test1,test1Set));
    }


}*/

//Iterative solution
public class WordBreak{
    public boolean wordBreak(String s, Set<String> wordDict) {
        // The array to store the result for dynamic programming
        boolean[] c=new boolean[s.length()+1];
        c[0]=true;
        for (int i=1;i<c.length;i++){
               for (int j=i-1;j>=0;j--){
                   String subString=s.substring(j,i);
                   if (c[j]==true && wordDict.contains(subString)){
                       c[i]=true;
                       break;
                   }
               }
        }
        return c[c.length-1];
    }

    public static void main(String[] args){
        WordBreak wb=new WordBreak();
        String test1="LeetCode";
        HashSet test1Set=new HashSet();
       // test1Set.add("LO");test1Set.add("L");
        test1Set.add("Leetode");test1Set.add("Code");test1Set.add("Leet");
        System.out.println(wb.wordBreak(test1,test1Set));
    }
}
