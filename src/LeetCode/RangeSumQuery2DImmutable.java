package LeetCode;

/**
 * Created by Ben_Big on 9/22/16.
 */

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 304. Range Sum Query 2D - Immutable  QuestionEditorial Solution  My Submissions
 Total Accepted: 20372
 Total Submissions: 90176
 Difficulty: Medium
 Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

 Range Sum Query 2D
 The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

 Example:
 Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 sumRegion(1, 1, 2, 2) -> 11
 sumRegion(1, 2, 2, 4) -> 12
 Note:
 You may assume that the matrix does not change.
 There are many calls to sumRegion function.
 You may assume that row1 ≤ row2 and col1 ≤ col2.

 */
// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);

/*
public class RangeSumQuery2DImmutable {

    HashMap<LinkedList<Integer>,Integer> dictionary=new HashMap<>();

    public RangeSumQuery2DImmutable(int[][] matrix) {
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                LinkedList<Integer> position=new LinkedList<>();
                position.add(i);
                position.add(j);
                if (i==0 && j==0){
                    dictionary.put(position,matrix[i][j]);
                }
                else if (i==0){
                    LinkedList<Integer> prePosition=new LinkedList<>();
                    prePosition.add(0);
                    prePosition.add(j-1);
                    int preValue=dictionary.get(prePosition);
                    dictionary.put(position,preValue+matrix[i][j]);
                }
                else if (j==0){
                    LinkedList<Integer> prePosition=new LinkedList<>();
                    prePosition.add(i-1);
                    prePosition.add(0);
                    int preValue=dictionary.get(prePosition);
                    dictionary.put(position,preValue+matrix[i][j]);
                }
                else{
                    LinkedList<Integer> prePosition1=new LinkedList<>();
                    prePosition1.add(i-1);
                    prePosition1.add(j);
                    int preValue1=dictionary.get(prePosition1);
                    LinkedList<Integer> prePosition2=new LinkedList<>();
                    prePosition2.add(i);
                    prePosition2.add(j-1);
                    int preValue2=dictionary.get(prePosition2);
                    LinkedList<Integer> prePosition3=new LinkedList<>();
                    prePosition3.add(i-1);
                    prePosition3.add(j-1);
                    int preValue3=dictionary.get(prePosition3);
                    dictionary.put(position,preValue1+preValue2-preValue3+matrix[i][j]);
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result=0;
        LinkedList<Integer> position=new LinkedList<>();
        position.add(row2);
        position.add(col2);
        if (row1==0 && col1==0){
            result=dictionary.get(position);
        }
        else if(col1==0){
            LinkedList<Integer> prePosition=new LinkedList<>();
            prePosition.add(row1-1);
            prePosition.add(col2);
            result=dictionary.get(position)-dictionary.get(prePosition);
        }
        else if(row1==0){
            LinkedList<Integer> prePosition=new LinkedList<>();
            prePosition.add(row2);
            prePosition.add(col1-1);
            result=dictionary.get(position)-dictionary.get(prePosition);
        }
        else{
            LinkedList<Integer> prePosition1=new LinkedList<>();
            prePosition1.add(row2);
            prePosition1.add(col1-1);
            int preValue1=dictionary.get(prePosition1);
            LinkedList<Integer> prePosition2=new LinkedList<>();
            prePosition2.add(row1-1);
            prePosition2.add(col2);
            int preValue2=dictionary.get(prePosition2);
            LinkedList<Integer> prePosition3=new LinkedList<>();
            prePosition3.add(row1-1);
            prePosition3.add(col1-1);
            int preValue3=dictionary.get(prePosition3);
            result=dictionary.get(position)-preValue1-preValue2+preValue3;
        }
        return result;
    }
    public static void main(String[] args){
        int[] []testMatrix=new int[5][];
        for (int i=0;i<5;i++){
            testMatrix[i]=new int[5];
        }
        testMatrix[0][0]=3;testMatrix[0][1]=0;testMatrix[0][2]=1;testMatrix[0][3]=4;testMatrix[0][4]=2;
        testMatrix[1][0]=5;testMatrix[1][1]=6;testMatrix[1][2]=3;testMatrix[1][3]=2;testMatrix[1][4]=1;
        testMatrix[2][0]=1;testMatrix[2][1]=2;testMatrix[2][2]=0;testMatrix[2][3]=1;testMatrix[2][4]=5;
        testMatrix[3][0]=4;testMatrix[3][1]=1;testMatrix[3][2]=0;testMatrix[3][3]=1;testMatrix[3][4]=7;
        testMatrix[4][0]=1;testMatrix[4][1]=0;testMatrix[4][2]=3;testMatrix[4][3]=0;testMatrix[4][4]=5;
        RangeSumQuery2DImmutable rsq=new RangeSumQuery2DImmutable(testMatrix);
        System.out.println(rsq.sumRegion(2,1,4,3));//expecting 8
        System.out.println(rsq.sumRegion(1,1,2,2));//expecting 11
        System.out.println(rsq.sumRegion(1,2,2,4));//expecting 12
        System.out.println(rsq.sumRegion(0,0,0,0));//expecting 3
        System.out.println(rsq.sumRegion(0,0,1,1));//expecting 14
        System.out.println(rsq.sumRegion(0,0,1,0));//expecting 8
    }
}*/

/**The idea of the following code is identical to that of the above,
difference is that instead of using those complex data structure, the code
 below uses only 2 dimensional array. The code above actually exceeds time limit
*/

public class RangeSumQuery2DImmutable{

    int [][]storage;

    public RangeSumQuery2DImmutable(int[][] matrix){
        int rowNum=matrix.length;
        int colNum=rowNum>0?matrix[0].length:0;
        storage=new int[rowNum][];

        for (int i=0;i<rowNum;i++){
            storage[i]=new int[colNum];
        }

        for (int i=0;i<rowNum;i++){
            for (int j=0;j<colNum;j++){
                if(i==0&&j==0){
                    storage[i][j]=matrix[0][0];
                }
                else if(i==0){
                    storage[i][j]=matrix[i][j]+storage[0][j-1];
                }
                else if(j==0){
                    storage[i][j]=matrix[i][j]+storage[i-1][0];
                }
                else{
                    storage[i][j]=matrix[i][j]+storage[i-1][j]+storage[i][j-1]-storage[i-1][j-1];
                }

            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result=0;
        if (row1==0 && col1==0){
            result=storage[row2][col2];
        }
        else if(col1==0){
            result=storage[row2][col2]-storage[row1-1][col2];
        }
        else if(row1==0){
            result=storage[row2][col2]-storage[row2][col1-1];
        }
        else{
            result=storage[row2][col2]-storage[row2][col1-1]-storage[row1-1][col2]+storage[row1-1][col1-1];
        }
        return result;
    }

    public static void main(String[] args){
        int[] []testMatrix=new int[5][];
        for (int i=0;i<5;i++){
            testMatrix[i]=new int[5];
        }
        testMatrix[0][0]=3;testMatrix[0][1]=0;testMatrix[0][2]=1;testMatrix[0][3]=4;testMatrix[0][4]=2;
        testMatrix[1][0]=5;testMatrix[1][1]=6;testMatrix[1][2]=3;testMatrix[1][3]=2;testMatrix[1][4]=1;
        testMatrix[2][0]=1;testMatrix[2][1]=2;testMatrix[2][2]=0;testMatrix[2][3]=1;testMatrix[2][4]=5;
        testMatrix[3][0]=4;testMatrix[3][1]=1;testMatrix[3][2]=0;testMatrix[3][3]=1;testMatrix[3][4]=7;
        testMatrix[4][0]=1;testMatrix[4][1]=0;testMatrix[4][2]=3;testMatrix[4][3]=0;testMatrix[4][4]=5;
        RangeSumQuery2DImmutable rsq=new RangeSumQuery2DImmutable(testMatrix);
        System.out.println(rsq.sumRegion(2,1,4,3));//expecting 8
        System.out.println(rsq.sumRegion(1,1,2,2));//expecting 11
        System.out.println(rsq.sumRegion(1,2,2,4));//expecting 12
        System.out.println(rsq.sumRegion(0,0,0,0));//expecting 3
        System.out.println(rsq.sumRegion(0,0,1,1));//expecting 14
        System.out.println(rsq.sumRegion(0,0,1,0));//expecting 8


    }

}

