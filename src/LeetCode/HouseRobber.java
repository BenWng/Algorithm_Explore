package LeetCode;
import java.util.*;

/**
 * Created by Ben_Big on 2/11/16.
 */

/**
 You are a professional robber planning to rob houses along a street.
 Each house has a certain amount of money stashed,
 the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.


 */



public class HouseRobber {

    public int rob(int[] nums) {
        if(nums==null){
            return 0;
        }
        else if (nums.length==1){
            return nums[0];
        }

        int lengthOfNums=nums.length;
        int [] C=new int [lengthOfNums];
        int result=0;
        int preMax=0;
        int prePreMax=0;


        for (int i=0;i<lengthOfNums;i++){
            preMax=result;
            C[i]=prePreMax+nums[i];
            result=Math.max(result,C[i]);
            prePreMax=preMax;

        }
        return result;
    }

    public static void main(String[] args){
        //Test1
        HouseRobber rb1=new HouseRobber();
        int[] M1={50,800,200,300};
        System.out.println(rb1.rob(M1));//Expecting 1000

        //Test2
        HouseRobber rb2=new HouseRobber();
        int[] M2=null;
        System.out.println(rb2.rob(M2));//Expecting 0

        //Test3
        HouseRobber rb3=new HouseRobber();
        int[] M3={7};
        System.out.println(rb3.rob(M3));

    }
}
