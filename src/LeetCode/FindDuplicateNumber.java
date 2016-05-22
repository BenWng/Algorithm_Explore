package LeetCode;

/**
 * Created by Ben_Big on 5/21/16.
 */

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.
 */



public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int length=nums.length;
        int max=length-1;
        int min=1;
        int half=(max+min)/2;

        while (length>=2){
            int lower_amount=half-min+1; // example max=15, min=3,half is 9
            int upper_amount=max-half;
            int lower_count=0;
            int upper_count=0;
            for (int  i : nums){
                if (i>half){
                    upper_amount++;
                }
                else { //i<=half
                    lower_amount++;
                }
            }

            if (upper_count>upper_amount){
                min=half+1;
            }
            if (lower_count>lower_amount){
                max=half;
            }
            half=(max+min)/2;
            length=max-min+1;
        }



        return 0;
    }
    public static void main(String[] args){



    }

}