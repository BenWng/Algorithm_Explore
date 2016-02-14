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


/**
 * ToDo: Using Recursion is 100 times slower than iteration. With Iteration, I only need 10 lines. 
 */

public class HouseRobber {



    public static int rob(int[] nums){
        HashMap<Integer,Integer> rest=new HashMap<>();
        if (nums.length==1){
            return nums[0];
        }
        else if (nums.length==2){
            return Integer.max(nums[0],nums[1]);
        }
        else if (nums.length==3){
            return Integer.max((nums[0]+nums[2]),nums[1]);
        }

        else{
            return rob_helper(0,nums,rest);
        }

    }



    public static int rob_helper(int index, int[] nums, HashMap<Integer,Integer> rest) {
        int total0=0;
        int total1=0;
        if (nums.length==1){
            rest.put(index,nums[0]);
            return nums[0];
        }
        if (nums.length==2){
            if (nums[0]>nums[1]){
                rest.put(index,nums[0]);
                return nums[0];
            }
            else{
                rest.put(index+1,nums[1]);
                return nums[1];
            }
        }
        if (nums.length==3){
            if (nums[1]>nums[0]+nums[2]){
                rest.put(index+1,nums[1]);
                return nums[1];
            }

        }

        if (nums.length-2>0) {
            int[] rest0 = new int[nums.length - 2];
            for (int i=0;i<nums.length-2;i++) {
                rest0[i]=nums[i+2];
            }
            if (rest.containsKey(index+2)){
                total0=nums[0]+rest.get(index+2);
            }
            else{
                total0=nums[0]+rob_helper(index+2,rest0,rest);
            }
        }
        if (nums.length-3>0) {
            int[] rest1 = new int[nums.length - 3];
            for (int i=0;i<nums.length-3;i++) {
                rest1[i]=nums[i+3];
            }
            if (rest.containsKey(index+3)) {
                total1 = nums[1] + rest.get(index+3);

            }
            else {
                total1 = nums[1] + rob_helper(index+3,rest1,rest);
            }
        }
        if(total0>total1){
            rest.put(index,total0);
            return total0;
        }
        else{
            rest.put(index,total1);
            return total1;
        }
    }
    public static void main(String[] args){
        int [] nums={82,217,170,215,153,55,185,55,185,232,69,131,130,102};
        System.out.println(rob(nums));

    }
}
