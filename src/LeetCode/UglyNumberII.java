package LeetCode;

/**
 * Created by Ben_Big on 7/12/16.
 */

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 264. Ugly Number
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 */

//ToDo: This question needs to be revisited

public class UglyNumberII {
    Integer[] primes = {2, 3, 5};

    public int nthUglyNumber(int n) {
        long[] result = new long[n];
        int resultTracker = 0;
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add((long) 1);
        HashSet<Long> set=new HashSet<>();
        set.add((long) 1);



        while (resultTracker < n) {
            long current = heap.poll();
            for (int i = 0; i < primes.length; i++) {
                long newProduct = current * primes[i];
                if (!set.contains(newProduct)) {
                    heap.add(newProduct);
                    set.add(newProduct);
                }
            }
            result[resultTracker] = current;
            resultTracker++;
        }
        return (int) result[resultTracker - 1];
    }


    public static void main(String[] args) {
        UglyNumberII test=new UglyNumberII();

        System.out.println(test.nthUglyNumber(1600));

    }

}
