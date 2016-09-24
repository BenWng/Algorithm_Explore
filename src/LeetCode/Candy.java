package LeetCode;

/**
 * Created by ben on 9/24/16.
 */

/**
 135. Candy  QuestionEditorial Solution  My Submissions
 Total Accepted: 58513
 Total Submissions: 249843
 Difficulty: Hard
 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */

public class Candy {
    public int candy(int[] ratings) {
        int [] numCandies=new int [ratings.length];
        numCandies[ratings.length-1]=1;
        for (int i=ratings.length-1;i>=1;i--){
            if (ratings[i-1]>ratings[i]){
                numCandies[i-1]=numCandies[i]+1;
            }
            else {
                numCandies[i-1]=1;
            }
        }

        for (int i=0;i<ratings.length-1;i++){
            if (ratings[i+1]>ratings[i] && numCandies[i+1]<=numCandies[i]){
                numCandies[i+1]=numCandies[i]+1;
            }
        }
        int sum=0;
        for (int i=0;i<ratings.length;i++){
            sum=sum+numCandies[i];
        }
        return sum;
    }
    public static void main(String[] args){
        Candy c=new Candy();
        int[] test1={1,3,4,3,2,1};
        System.out.println(c.candy(test1));
    }

}
