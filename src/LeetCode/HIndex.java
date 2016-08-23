package LeetCode;

/**
 * Created by Ben_Big on 6/10/16.
 */


import java.util.Iterator;
import java.util.LinkedList;

/**
 * 274. Given an array of citations (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 *According to the definition of h-index on Wikipedia:
 *  "A scientist has index h if h of his/her N papers have at least h citations each,
 *and the other N − h papers have no more than h citations each."
 *For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 *Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
 */



public class HIndex {
    public int hIndex(int[] citations) {
        LinkedList<Integer> sortedCitations=countSort(citations);
        Iterator<Integer> itr=sortedCitations.iterator();
        int index=0;
        int hIndex=0;
        while(itr.hasNext()){
            int currentValue=itr.next();
            if(currentValue>sortedCitations.size()-index){
                return hIndex>sortedCitations.size()-index?hIndex:sortedCitations.size()-index;
            }
            else{
                hIndex=currentValue;
                index++;
            }

        }
        return hIndex;
    }
    public LinkedList<Integer> countSort(int[] citations){
        int max=0;
        for (int i=0;i<citations.length;i++){
            if(citations[i]>max){
                max=citations[i];
            }
        }
        int[] countResult=new int[max+1];
        for (int i=0;i<citations.length;i++){
            countResult[citations[i]]++;
        }
        LinkedList<Integer> result=new LinkedList<>();
        for (int i=0;i<countResult.length;i++){
            if(countResult[i]!=0){
                for (int j=0;j<countResult[i];j++){
                    result.add(i);
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] testCase1={3,5,8};
        HIndex hi=new HIndex();
        System.out.println(hi.hIndex(testCase1));
    }
}
