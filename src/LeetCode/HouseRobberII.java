package LeetCode;

/**
 * Created by Ben_Big on 10/7/16.
 */

/**
 * 213. House Robber II

 •	Total Accepted: 40254
 •	Total Submissions: 124081
 •	Difficulty: Medium

 Note: This is an extension of House Robber.
 After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention.
 This time, all houses at this place are arranged in a circle.
 That means the first house is the neighbor of the last one.
 Meanwhile, the security system for these houses remain the same as for those in the previous street.
 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 */


public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums==null){
            return 0;
        }
        else if (nums.length==1){
            return nums[0];
        }
        else if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        else if (nums.length==3){
            return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        }


        int[][] recursiveResultRobFirstHouse=new int[2][];
        int[][] recursiveResultNotRobFirstHouse=new int[2][];
        recursiveResultRobFirstHouse[0]=new int[nums.length-1];
        recursiveResultRobFirstHouse[1]=new int[nums.length-1];
        recursiveResultNotRobFirstHouse[0]=new int[nums.length-1];
        recursiveResultNotRobFirstHouse[1]=new int[nums.length-1];

        ///////////////////////////////////////////////////
        //Index 0 corresponds to the third house
        //Rob Third house, after first house is robbed, second house cannot be robbed anyway
        recursiveResultRobFirstHouse[0][0]=nums[0]+nums[2];
        //Do not rob Third house, after first house is robbed, second house cannot be robbed anyway
        recursiveResultRobFirstHouse[1][0]=nums[0];

        //Start with the fourth house, till the second last house
        for (int i=3;i<nums.length-1;i++){
            recursiveResultRobFirstHouse[0][i-2]=recursiveResultRobFirstHouse[1][i-3]+nums[i];
            recursiveResultRobFirstHouse[1][i-2]=Math.max(recursiveResultRobFirstHouse[1][i-3],recursiveResultRobFirstHouse[0][i-3]);
        }

        ////////////////////////////////////////////////
        //index 0 corresponds to second house
        //Rob Second house
        recursiveResultNotRobFirstHouse[0][0]=nums[1];
        //Do not rob second house
        recursiveResultRobFirstHouse[1][0]=0;

        //Start with the third house, till the second last house
        for (int i=2;i<nums.length-1;i++){
            recursiveResultNotRobFirstHouse[0][i-1]=recursiveResultNotRobFirstHouse[1][i-2]+nums[i];
            recursiveResultNotRobFirstHouse[1][i-1]=Math.max(recursiveResultNotRobFirstHouse[1][i-2],recursiveResultNotRobFirstHouse[0][i-2]);
        }
        //////////////////////////////////////////////
        int lastHouseNumber=nums.length-1;

        //rob the first one, last one cannot be robbed
        int optionRobFirstOne=Math.max(recursiveResultRobFirstHouse[0][lastHouseNumber-3],recursiveResultRobFirstHouse[1][lastHouseNumber-3]);


        //Do not rob the first one, last one can be robbed
        int optionNotRobFirstOne=Math.max(recursiveResultNotRobFirstHouse[0][lastHouseNumber-2],recursiveResultNotRobFirstHouse[1][lastHouseNumber-2]+nums[lastHouseNumber]);

        return Math.max(optionNotRobFirstOne,optionRobFirstOne);
    }
}
