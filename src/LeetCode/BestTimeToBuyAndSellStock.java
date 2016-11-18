/*
121. Best Time to Buy and Sell Stock
Total Accepted: 144963
Total Submissions: 376073
Difficulty: Easy
Contributors: Admin
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 */

package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben_Big on 11/15/16.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int pricesLength=prices.length;
        int[] maxAfterCurrentDay=new int[pricesLength-1];
        for (int i=pricesLength-1;i>0;i--){
            int indexInList=i-1;
            if (i==pricesLength-1){
                maxAfterCurrentDay[indexInList]=prices[i];
            }
            else{
                int maxAfter=maxAfterCurrentDay[indexInList+1];
                if (prices[i]>maxAfter){
                    maxAfterCurrentDay[indexInList]=prices[i];
                }
                else{
                    maxAfterCurrentDay[indexInList]=maxAfter;
                }
            }
        }
        int result=0;
        for (int i=0;i<pricesLength-1;i++){
            int currentDayProfit=maxAfterCurrentDay[i]-prices[i];
            if(currentDayProfit>result){
                result=currentDayProfit;
            }
        }

        return result;
    }
    public static void main(String[] args){
        BestTimeToBuyAndSellStock stock=new BestTimeToBuyAndSellStock();
        int []input= {7,1,5,3,6,4};
        System.out.println(stock.maxProfit(input));
    }
}
