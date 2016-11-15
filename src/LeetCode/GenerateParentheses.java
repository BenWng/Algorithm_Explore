/*
    22. Generate Parentheses
Total Accepted: 116193
Total Submissions: 283808
Difficulty: Medium
Contributors: Admin
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 */
package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Ben_Big on 11/14/16.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        return helper("",n,0);
    }

    public List<String> helper(String pre,int completeParLeft, int rightParLeft){
        List<String> comboOne=new ArrayList<>();
        List<String> comboTwo=new ArrayList<>();
        if (rightParLeft>0){
            comboOne=helper(pre+")",completeParLeft,rightParLeft-1);
        }
        if (completeParLeft>0){
            comboTwo=helper(pre+"(",completeParLeft-1,rightParLeft+1);
        }
        if (completeParLeft==0 && rightParLeft==0){
            comboOne.add(pre);
        }
        comboOne.addAll(comboTwo);
        return comboOne;
    }

    public static void main(String[] args){
        GenerateParentheses gp=new GenerateParentheses();
        System.out.println(gp.generateParenthesis(4));

        HashSet<String> s=new HashSet<>();
        String[] mine={"()()()()", "()()(())", "()(())()", "()(()())", "()((()))", "(())()()", "(())(())", "(()())()", "(()()())", "(()(()))", "((()))()", "((())())", "((()()))", "(((())))"};

        for (String m : mine){
            if (s.contains(m)){
                System.out.println(m);
            }
            s.add(m);
        }
        String[] standard={"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"};
        for (String str : standard){
            if (!s.contains(str)){
                System.out.println(str);
            }
        }
    }
}
