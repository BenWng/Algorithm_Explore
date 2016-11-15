/*
96. Unique Binary Search Trees
Total Accepted: 102348
Total Submissions: 259662
Difficulty: Medium
Contributors: Admin
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

package LeetCode;

/**
 * Created by Ben_Big on 11/14/16.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n){
        int[] s=new int[n+1];
        s[0]=1;s[1]=1;
        for (int i=2;i<=n;i++){
            s[i]=2*s[i-1];
            for (int j=i-2;j>=1;j--){
                int numBetweenJandI=i-j-1;
                s[i]+=s[j]*s[numBetweenJandI];
            }
        }
       return s[n];

    }
    public static void main(String[] args){
        UniqueBinarySearchTrees ubst=new UniqueBinarySearchTrees();
        System.out.println(ubst.numTrees(6));
    }

}
