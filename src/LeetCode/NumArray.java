package LeetCode;

/**
 * Created by ben on 2/15/16.
 */


/**
 * Given an integer array nums,
 * find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.
 */


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

public class NumArray {

    public int [] Ary;


    public NumArray(int[] nums) {
        if(nums.length>1){
            Ary=new int[nums.length];
            Ary[0]=nums[0];
            for (int i=1;i<nums.length;i++){
                Ary[i]=nums[i]+Ary[i-1];
            }
        }
        else if (nums.length==1){
            Ary=new int[1];
            Ary[0]=nums[0];
        }
    }
    public int sumRange(int i, int j) {
        if(i>0){
            return Ary[j]-Ary[i-1];
        }
        else {
            return Ary[j];
        }
    }

    public static void main(String[] args){
        int [] nums={-1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0,0));//sumRange(2,5),sumRange(0,5)

    }
}
