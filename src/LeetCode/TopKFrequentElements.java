package LeetCode;

/**
 * Created by ben on 8/22/16.
 */

/**
 * 347. Top K Frequent Elements  QuestionEditorial Solution  My Submissions
 Total Accepted: 26632
 Total Submissions: 60704
 Difficulty: Medium
 Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k){
        //Part 1: Get the frequency count
        HashMap<Integer,Integer> frequencyRecorder=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (frequencyRecorder.containsKey(nums[i])){
                int frequency=frequencyRecorder.get(nums[i]);
                frequencyRecorder.replace(nums[i],frequency+1);
            }
            else{
                frequencyRecorder.put(nums[i],1);
            }

        }
        //Part 2: sorting based on frequecny count
        Set<Map.Entry<Integer, Integer>> frequencySet=frequencyRecorder.entrySet();
        Iterator<Map.Entry<Integer,Integer>> itrSet=frequencySet.iterator();
        ArrayList<LinkedList<Map.Entry<Integer,Integer>>> sortedFrequency=new ArrayList<>(nums.length);
        for (int i=0;i<nums.length;i++){
            sortedFrequency.add(new LinkedList<>());
        }
        while(itrSet.hasNext()){
            Map.Entry<Integer,Integer> currentEntry=itrSet.next();
            sortedFrequency.get(currentEntry.getValue()-1).add(currentEntry);
        }
        //Part 3: Get the result
        LinkedList<Integer> result=new LinkedList<>();
        int numResult=0;
        for (int i=nums.length-1; i>=0 && numResult<k; i--){
            LinkedList<Map.Entry<Integer,Integer>> currentList=sortedFrequency.remove(i);
            if(!currentList.isEmpty()) {
                Iterator<Map.Entry<Integer,Integer>> itrList2 =currentList.iterator();
                while (itrList2.hasNext()){
                    result.add(itrList2.next().getKey());
                    numResult++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
    }
    /*
    public static void main(String[] args){
        int[] testCase1={1,1,1,2,3,4,4,5};
        int[] testCase2={1};
        TopKFrequentElements test=new TopKFrequentElements();
        System.out.println(test.topKFrequent(testCase1,2));//Expecting [1,4]
        System.out.println(test.topKFrequent(testCase2,1));//Expecting [1]

    }*/
}


