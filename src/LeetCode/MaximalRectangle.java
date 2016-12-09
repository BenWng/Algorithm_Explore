package LeetCode;

/**
 * Created by Ben_Big on 12/10/16.
 */

import java.util.Arrays;

/**
 * 85. Maximal Rectangle
 Total Accepted: 55023
 Total Submissions: 213762
 Difficulty: Hard
 Contributors: Admin
 Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 6.
 */

//ToDo: I have no idea for this one.

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int result = 0;
        int[] height = new int[col];
        int[] left = new int[col];
        int[] right = new int[col];
        Arrays.fill(right,col);
        for (int i = 0; i < row; i++) {
            int current_left = 0;
            int current_right = col;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') height[j] = 0;
                else height[j] = height[j] + 1;
            }
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    left[j] = 0;//Give it 0, so in the next row at col j,
                    //this value would not be used to update left[j] in that row
                    current_left = j + 1;
                } else {
                    left[j] = Math.max(left[j], current_left);//left[j] in Math.max is actually left[j] from last row
                }
            }
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    right[j] = col;
                    current_right = j;
                } else {
                    right[j] = Math.min(right[j], current_right);
                }
            }
            for (int j = 0; j < col; j++) {
                result = Math.max(result, (right[j] - left[j]) * height[j]);
            }
        }
        return result;
    }
    public static void main(String[] args){
        MaximalRectangle mr=new MaximalRectangle();
        char[][] test1={{'1'}};
        System.out.println(mr.maximalRectangle(test1));
    }
}
