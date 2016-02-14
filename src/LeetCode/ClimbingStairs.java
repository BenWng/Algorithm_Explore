package LeetCode;

/**
 * Created by Ben_Big on 2/14/16.
 */
public class ClimbingStairs {
    public static int climbStairs(int n){
        int [] Ary=new int[n];
        for (int i=0;i<n;i++){
            if (n==0){  //n==0 corresponds to n==1
                Ary[n]=1;
            }
            else if (n==1){
                Ary[n]=2;
            }
            else{
                Ary[n]=2+Ary[n-1]+Ary[n-2];
            }
        }
        return Ary[n-1];
    }
    public static void main(String[] args){

    }
}
