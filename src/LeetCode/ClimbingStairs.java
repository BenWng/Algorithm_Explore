package LeetCode;

/**
 * Created by Ben_Big on 2/14/16.
 */
public class ClimbingStairs {
    public static int climbStairs(int n){
        int [] Ary=new int[n];
        for (int i=0;i<n;i++){
            if (i==0){  //n==0 corresponds to n==1
                Ary[i]=1;
            }
            else if (i==1){
                Ary[i]=2;
            }
            else{
                Ary[i]=Ary[i-1]+Ary[i-2];
            }
        }
        return Ary[n-1];
    }
    public static void main(String[] args){
        System.out.println(climbStairs(18));
    }
}
