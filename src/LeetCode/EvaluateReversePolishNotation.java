package LeetCode;

/**
 * Created by ben on 9/30/16.
 */

import java.util.DoubleSummaryStatistics;
import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation  QuestionEditorial Solution  My Submissions
 Total Accepted: 74955
 Total Submissions: 298969
 Difficulty: Medium
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) throws IllegalArgumentException {
        Stack<String> numberStorage=new Stack<>();
        for (int i=0;i<tokens.length;i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num2 = Integer.parseInt(numberStorage.pop());
                int num1 = Integer.parseInt (numberStorage.pop());
                switch (tokens[i]) {
                    case "+":
                        numberStorage.add(Integer.toString(num1 + num2));
                        break;
                    case "-":
                        numberStorage.add(Integer.toString(num1 - num2));
                        break;
                    case "*":
                        numberStorage.add(Integer.toString(num1 * num2));
                        break;
                    case "/":
                        numberStorage.add(Integer.toString(num1 / num2));
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
            else{
                numberStorage.add(tokens[i]);
            }
        }

        return  Integer.parseInt(numberStorage.pop());
    }

    public static void main(String[] args){
        EvaluateReversePolishNotation erpn=new EvaluateReversePolishNotation();
        String[] test1= {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(erpn.evalRPN(test1));


    }
}
