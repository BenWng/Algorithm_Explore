package LeetCode;

/**
 * Created by Ben_Big on 9/19/16.
 */

/**
 * 279. Perfect Squares  QuestionEditorial Solution  My Submissions
 Total Accepted: 49752
 Total Submissions: 145168
 Difficulty: Medium
 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */


/*
//Todo: This works, but absolutely too slow
public class PerfectSquares {
    public int numSquares(int n) {
        int m=(int)Math.sqrt(n);
        int [][] S=new int[m+1][];
        for (int i=0;i<=m;i++){
            S[i]=new int[n+1];
        }

        for (int i=1;i<=n;i++){
            S[1][i]=i;
        }


        for (int i=2;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(i*i>j){
                    S[i][j]=S[i-1][j];
                }
                else{
                    Integer minimumTemp=S[i-1][j];
                    for (int k=0;j-k*i*i>=0;k++){
                        if (S[i-1][j-k*i*i]+k<minimumTemp){
                            minimumTemp=S[i-1][j-k*i*i]+k;
                        }
                    }
                    S[i][j]=minimumTemp;
                }
            }
        }

        int result=S[1][n];
        for (int k=1;k<=m;k++){
            if(S[k][n]<result){
                result=S[k][n];
            }
        }

        return result;
    }
    public static void main(String[] args){
        PerfectSquares ps=new PerfectSquares();
        System.out.println(ps.numSquares(3081));
    }
}
*/

public class PerfectSquares {
    public int numSquares(int n) {
        int[] S=new int[n+1];
        S[0]=1;
        S[1]=1;
        for (int i=2;i<=n;i++){
            int squareRoot=(int)Math.sqrt(i);
            if(squareRoot*squareRoot==i){
                S[i]=1;
            }
            else{
                int minimumTemp=5;
                for (int k=1;k<=squareRoot;k++){
                    if (S[i-k*k]+S[k*k]<minimumTemp){
                        minimumTemp=S[i-k*k]+S[k*k];
                    }
                }
                S[i]=minimumTemp;
            }
        }
        return S[n];
    }
}