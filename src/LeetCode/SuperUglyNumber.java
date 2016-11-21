package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/*
313. Super Ugly Number
Total Accepted: 27201
Total Submissions: 74155
Difficulty: Medium
Contributors: Admin
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 */


/**
 * Created by Ben_Big on 11/22/16.
 */
public class  SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        ArrayList<Integer> uglyNumberList=new ArrayList<>();
        uglyNumberList.add(1);
        HashMap<Integer,Integer> primeToPointer=new HashMap<>();
        HashMap<Integer,Integer> uglyNumberToPrime=new HashMap<>();
        TreeSet<Integer> uglyNumbersHeap=new TreeSet<>();
        for (int pri : primes){
            primeToPointer.put(pri,0);
            uglyNumberToPrime.put(pri,pri);
            uglyNumbersHeap.add(pri);
        }

        while(uglyNumberList.size()<n){
            int leastUgly=uglyNumbersHeap.first();
            uglyNumbersHeap.remove(leastUgly);
            uglyNumberList.add(leastUgly);
            int correspondingPrime=uglyNumberToPrime.get(leastUgly);
            uglyNumberToPrime.remove(leastUgly);
            int currentPointer=primeToPointer.get(correspondingPrime);
            currentPointer++;
            while(currentPointer<uglyNumberList.size()){
                int product=correspondingPrime*uglyNumberList.get(currentPointer);
                if (!uglyNumberToPrime.containsKey(product)){
                    primeToPointer.put(correspondingPrime,currentPointer);
                    uglyNumberToPrime.put(product,correspondingPrime);
                    uglyNumbersHeap.add(product);
                    break;
                }
                currentPointer++;
            }
        }
        return uglyNumberList.get(n-1);
    }
    public static void main(String[] args){
        SuperUglyNumber sun=new SuperUglyNumber();
        int [] prime1={2, 7, 13, 19};
        System.out.println(sun.nthSuperUglyNumber(12,prime1));
    }
}