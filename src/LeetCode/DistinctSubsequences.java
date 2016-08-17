package LeetCode;

/**
 * Created by Ben_Big on 5/28/16.
 */


import org.apache.commons.lang3.time.StopWatch;

/**
 * 115.
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

 A subsequence of a string is a new string which is formed from the original string by deleting
 some (can be none) of the characters without disturbing the relative positions of the remaining characters.
 (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Here is an example:
 S = "rabbbit", T = "rabbit"

 Return 3.
 */


// ToDo: needs to be done with Dynamic Programming, see note in Notability, the following is based on a discussion post on leetcode

public class DistinctSubsequences {


    public int numDistinct(String s, String t) {
        char [] sArr=s.toCharArray();
        char [] tArr=t.toCharArray();
        int[][] dp=new int[tArr.length+1][sArr.length+1];
        for (int i=0;i<=sArr.length;i++){
            dp[0][i]=1;
        }
        for (int i=1;i<=tArr.length;i++){
            for (int j=1;j<=sArr.length;j++){
                if (tArr[i-1]==sArr[j-1]){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[tArr.length][sArr.length];
    }

    public static void main(String[] args){


        //Test of the program
        DistinctSubsequences ds2=new DistinctSubsequences();
        System.out.println(ds2.numDistinct("rabbbit","rabbit")); //expecting 3

        DistinctSubsequences ds3=new DistinctSubsequences();
        System.out.println(ds3.numDistinct("aabb","abb"));//expecting 2


        DistinctSubsequences ds4=new DistinctSubsequences();
        System.out.println(ds4.numDistinct("A","ACE"));//expecting 0


        DistinctSubsequences ds5=new DistinctSubsequences();
        System.out.println(ds5.numDistinct("ACEEE","ACE"));//expecting 3



        DistinctSubsequences ds6=new DistinctSubsequences();
        System.out.println(ds6.numDistinct("","a"));//expecting 0




        DistinctSubsequences ds7=new DistinctSubsequences();
        System.out.println(ds7.numDistinct("ACE",""));//expecting 1

        StopWatch timer=new StopWatch();
        timer.start();
        DistinctSubsequences ds8=new DistinctSubsequences();
        System.out.println(ds8.numDistinct("aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe",
                "bddabdcae"));
        timer.stop();
        System.out.println("Time: "+timer.getNanoTime()/Math.pow(10,6));

    }

}
