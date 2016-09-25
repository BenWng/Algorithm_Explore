package LeetCode;

/**
 * Created by Ben_Big on 9/25/16.
 */


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 368. Largest Divisible Subset
 Question
 Editorial Solution
 My Submissions

 •	Total Accepted: 11074
 •	Total Submissions: 34750
 •	Difficulty: Medium

 Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

 If there are multiple solutions, return any subset is fine.

 Example 1:

 nums: [1,2,3]

 Result: [1,2] (of course, [1,3] will also be ok)
 Example 2:

 nums: [1,2,4,8]

 Result: [1,2,4,8]

 */

/** The idea of the following implementation is right, but the implementation itself
 * makes it very slow, although it is still good enough to pass leetcode
 */

//ToDo: The problem therefore needs to be revisited
/*
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length==0){
            ArrayList<Integer>result =new ArrayList<>(0);
            return result;
        }
        int[] sortedNums=mergeSort(nums);
        ArrayList<LinkedList<Integer>> subsets=new ArrayList<>(nums.length);
        int [] S=new int[nums.length];
        S[0]=1;
        LinkedList<Integer> subsetAtZero=new LinkedList<>();
        subsetAtZero.add(sortedNums[0]);
        subsets.add(0,subsetAtZero);

        int maximumSubsetSize=1;
        int maximumSubsetIndex=0;
        for (int i=1;i<nums.length;i++){
            int maxSForI=-1;
            int bestMatchingJ=-1;
            for (int j=i-1;j>=0;j--){
                if (sortedNums[i]%sortedNums[j]==0 && 1+S[j]>maxSForI){
                    bestMatchingJ=j;
                    maxSForI=1+S[j];
                }
            }
            if (bestMatchingJ==-1){
                S[i]=1;
                LinkedList<Integer> subsetAtI=new LinkedList<>();
                subsetAtI.add(sortedNums[i]);
                subsets.add(i,subsetAtI);
            }
            else{
                S[i]=maxSForI;
                LinkedList<Integer> subsetAtI=(LinkedList<Integer>)subsets.get(bestMatchingJ).clone();
                subsetAtI.add(sortedNums[i]);
                subsets.add(i,subsetAtI);
            }
            if (S[i]>maximumSubsetSize){
                maximumSubsetSize=S[i];
                maximumSubsetIndex=i;
            }
        }
        return subsets.get(maximumSubsetIndex);
    }

    private int[] mergeSort(int[] nums){
        if(nums.length==1){
            return nums;
        }
        int []subarray1=new int [nums.length/2];
        int []subarray2=new int [nums.length-nums.length/2];
        for (int i=0;i<nums.length/2;i++){
            subarray1[i]=nums[i];
        }
        for (int i=nums.length/2;i<nums.length;i++){
            subarray2[i-nums.length/2]=nums[i];
        }
        return merge(mergeSort(subarray1),mergeSort(subarray2));
    }
    private int[] merge(int[] array1, int[] array2){
        int pointer1=0;
        int pointer2=0;
        int [] result=new int [array1.length+array2.length];
        int resultPointer=0;
        while (resultPointer<result.length) {
            if (pointer1>=array1.length){
                result[resultPointer]=array2[pointer2];
                pointer2++;
            }
            else if (pointer2>=array2.length){
                result[resultPointer]=array1[pointer1];
                pointer1++;
            }
            else if (array1[pointer1]<array2[pointer2]){
                result[resultPointer]=array1[pointer1];
                pointer1++;
            }
            else if (array1[pointer1]>=array2[pointer2]){
                result[resultPointer]=array2[pointer2];
                pointer2++;
            }
            resultPointer++;
        }
        return result;
    }
    public static void main(String[] args){
        LargestDivisibleSubset lds=new LargestDivisibleSubset();
        //Test Merge Sort
        int [] testMerge1={3,5,1,8,4};
        int [] result1=lds.mergeSort(testMerge1);
        int [] testMerge2={2};
        int [] result2=lds.mergeSort(testMerge2);
        //Test largestDivisibleSubset
        int [] testSubset1={1,2,3};
        System.out.println(lds.largestDivisibleSubset(testSubset1));
        int [] testSubset2={1,2,3,8,9,27,81};
        System.out.println(lds.largestDivisibleSubset(testSubset2));
        int [] testSubset3=new int[0];
        System.out.println(lds.largestDivisibleSubset(testSubset3));
        int [] testSubset4={546,669};
        System.out.println(lds.largestDivisibleSubset(testSubset4));


    }
}
*/

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums){
        if (nums.length==0){
            ArrayList<Integer>result =new ArrayList<>(0);
            return result;
        }
        Arrays.sort(nums);
        //The array for recursive relationship
        int []S=new int[nums.length];

        //The array to track the result
        int []C=new int[nums.length];

        S[0]=1;
        C[0]=0;


        int maximumSubsetSize=1;
        int maximumSubsetIndex=0;
        for (int i=1;i<nums.length;i++){
            int maxSForI=-1;
            int bestMatchingJ=-1;
            for (int j=i-1;j>=0;j--){
                if (nums[i]%nums[j]==0 && 1+S[j]>maxSForI){
                    bestMatchingJ=j;
                    maxSForI=1+S[j];
                }
            }
            if (bestMatchingJ==-1){
                S[i]=1;
                C[i]=i;
            }
            else{
                S[i]=maxSForI;
                C[i]=bestMatchingJ;
            }
            if(S[i]>maximumSubsetSize){
                maximumSubsetSize=S[i];
                maximumSubsetIndex=i;
            }
        }
        LinkedList<Integer> result=new LinkedList<>();
        int temp=maximumSubsetIndex;
        while (C[temp]!=temp){
            result.addFirst(nums[temp]);
            temp=C[temp];
        }
        result.addFirst(nums[temp]);
        return result;
    }
    public static void main(String[] args){
        LargestDivisibleSubset lds=new LargestDivisibleSubset();
          //Test largestDivisibleSubset
        int [] testSubset1={1,2,3};
        System.out.println(lds.largestDivisibleSubset(testSubset1));
        int [] testSubset2={1,2,3,8,9,27,81};
        System.out.println(lds.largestDivisibleSubset(testSubset2));
        int [] testSubset3=new int[0];
        System.out.println(lds.largestDivisibleSubset(testSubset3));
        int [] testSubset4={546,669};
        System.out.println(lds.largestDivisibleSubset(testSubset4));
        int [] testSubset5={3,4,16,8};
        System.out.println(lds.largestDivisibleSubset(testSubset5));


    }
}