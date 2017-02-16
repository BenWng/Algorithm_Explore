package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben_Big on 2/16/17.
 */

/*
* 120.
* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).*/

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int numRows=triangle.size();
        int [] summationValue=new int [numRows];
        summationValue[0]=triangle.get(0).get(0);
        for (int rowIndex=1;rowIndex<numRows;rowIndex++){
            List<Integer> currentRow=triangle.get(rowIndex);
            int numCols=currentRow.size();
            int [] tempSummationValue=new int[numRows];

            for (int colIndex=0;colIndex<numCols;colIndex++){
                int currentValue=currentRow.get(colIndex);
                int resultWithPreviousIndex=Integer.MAX_VALUE;
                int resultWithCurrentIndex=Integer.MAX_VALUE;

                if (colIndex!=0){
                    //Valid for all elements except the first one
                    resultWithPreviousIndex=currentValue+summationValue[colIndex-1];
                }

                if (colIndex!=numCols-1){
                    //Valid for all elements except the last one
                    resultWithCurrentIndex=currentValue+summationValue[colIndex];

                }
                tempSummationValue[colIndex]=resultWithPreviousIndex<resultWithCurrentIndex?resultWithPreviousIndex:resultWithCurrentIndex;
            }
            summationValue=tempSummationValue;
        }

        int result=Integer.MAX_VALUE;
        for (int i=0;i<summationValue.length;i++){
            if (summationValue[i]<result) result=summationValue[i];
        }

        return result;


    }

    public static void main(String[] args){
        List < Integer> test=new ArrayList<>();
        test.add(-1);
        List < Integer> testt=new ArrayList<>();
        testt.add(2);testt.add(3);
        List < Integer> testtt=new ArrayList<>();
        testtt.add(1);testtt.add(-1);testtt.add(-3);
        List<List<Integer>> test1=new ArrayList<>();
        test1.add(test); test1.add(testt); test1.add(testtt);
        Triangle t=new Triangle();
        System.out.println(t.minimumTotal(test1));

    }


}
