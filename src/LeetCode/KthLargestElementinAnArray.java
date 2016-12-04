package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Ben_Big on 12/5/16.
 */

/**
 * 215. Kth Largest Element in an Array
 Total Accepted: 95038
 Total Submissions: 256428
 Difficulty: Medium
 Contributors: Admin
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

public class KthLargestElementinAnArray {
    public int findKthLargest(int[] nums, int k) {
        class NumComparator implements Comparator<Integer>{
            @Override
            public int compare(Integer x, Integer y){
                if(x<y){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        }


        Comparator<Integer> comp=new NumComparator();
        PriorityQueue<Integer> queue=new PriorityQueue<>(comp);
        for (int i=0;i<nums.length;i++){
            queue.add(nums[i]);
            if (queue.size()>k) queue.poll();
        }

        return queue.poll();
    }
    public static void main(String[] args){
        KthLargestElementinAnArray kle=new KthLargestElementinAnArray();
        int [] test1={3,2,1,5,6,4};
        System.out.println(kle.findKthLargest(test1,2));
    }


}
