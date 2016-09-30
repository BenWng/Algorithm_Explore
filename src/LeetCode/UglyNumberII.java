package LeetCode;

/**
 * Created by Ben_Big on 7/12/16.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 264. Ugly Number
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 */

//ToDo: this question needs revisit


/*
// A super slow idea
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
*/

//The following idea is on the right track, but still a little bit slow
/*
public class UglyNumberII {
    int[] primes={2,3,5};
    long[] multiplyResultCache={2,3,5};
    ArrayList<Long> uglyNumberList=new ArrayList<>();

    public int nthUglyNumber(int n) {
        if (n==1){
            return 1;
        }
        int pointerForUglyNumberList=0;
        uglyNumberList.add((long)1);

        while (uglyNumberList.size()<n){
            //Add the smallest number in the cache to the uglyNumberList
            long smallestMultiplyResultSoFar=multiplyResultCache[0];
            int indexOfSmallestMultiplyResultInCache=0;

            for (int i=0;i<3;i++){
                if (multiplyResultCache[i]<smallestMultiplyResultSoFar){
                    smallestMultiplyResultSoFar=multiplyResultCache[i];
                    indexOfSmallestMultiplyResultInCache=i;
                }
            }
            uglyNumberList.add(smallestMultiplyResultSoFar);

            //Move the pointer
            if (uglyNumberList.get(pointerForUglyNumberList)*5<=uglyNumberList.get(uglyNumberList.size()-1)) {
                pointerForUglyNumberList++;
            }


            //Supplant in the cache
            int numberToMultiply=primes[indexOfSmallestMultiplyResultInCache];

            int temporaryPointer=pointerForUglyNumberList;
            while(temporaryPointer<uglyNumberList.size()){
                long multiplyResult=uglyNumberList.get(temporaryPointer)*numberToMultiply;
                if (multiplyResult>uglyNumberList.get(uglyNumberList.size()-1) &&
                        multiplyResult!=multiplyResultCache[0] &&
                        multiplyResult!=multiplyResultCache[1] &&
                        multiplyResult!=multiplyResultCache[2])
                    {
                        multiplyResultCache[indexOfSmallestMultiplyResultInCache]=multiplyResult;
                        break;
                    }
                temporaryPointer++;
            }


        }

        long result= uglyNumberList.get(uglyNumberList.size()-1);
        return (int) result;

    }

    public static void main(String[] args) {
        UglyNumberII test=new UglyNumberII();

        System.out.println(test.nthUglyNumber(1690));

    }
}*/

public class UglyNumberII {


    public int nthUglyNumber(int n){
        if(n==1){
            return 1;
        }
        long[] uglyNumberList=new long[n];
        uglyNumberList[0]=1l;
        int numberOfUglyNumber=1;//record how many ugly numbers have been generated

        //At first, all the pointers point to index 0
        int pointerFor2=0;
        int pointerFor3=0;
        int pointerFor5=0;

        while (numberOfUglyNumber<n){
            long multiplyWith2=uglyNumberList[pointerFor2]*2;
            long multiplyWith3=uglyNumberList[pointerFor3]*3;
            long multiplyWith5=uglyNumberList[pointerFor5]*5;


            long minimum=multiplyWith2<multiplyWith3?multiplyWith2:multiplyWith3;
            minimum=minimum<multiplyWith5?minimum:multiplyWith5;

            if(minimum==multiplyWith2){
                pointerFor2++;
            }
            if(minimum==multiplyWith3){
                pointerFor3++;
            }
            if(minimum==multiplyWith5){
                pointerFor5++;
            }
            uglyNumberList[numberOfUglyNumber]=minimum;
            numberOfUglyNumber++;

        }
        return (int)uglyNumberList[n-1];
    }

    public static void main(String[] args) {
        UglyNumberII test=new UglyNumberII();

        System.out.println(test.nthUglyNumber(1690));

    }
}

