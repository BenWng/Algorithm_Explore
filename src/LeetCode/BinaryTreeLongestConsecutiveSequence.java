package LeetCode;

/**
 * Created by Ben_Big on 11/19/16.
 */

/*
298. Binary Tree Longest Consecutive Sequence
Total Accepted: 18842
Total Submissions: 48071
Difficulty: Medium
Contributors: Admin
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    /
   2
  /
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



public class BinaryTreeLongestConsecutiveSequence {

    private int longestLength=0;

    public int longestConsecutive(TreeNode root) {
        lengthForCurrentNode(root,0);
        return longestLength;
    }

    private void lengthForCurrentNode(TreeNode root,int len){
        if (root==null){
            longestLength=longestLength<len?len:longestLength;
            return;
        }
        TreeNode rightChild=root.right;
        TreeNode leftChild=root.left;


        if (leftChild!=null && leftChild.val==root.val+1){
            lengthForCurrentNode(leftChild,len+1);
        }
        else{
            longestLength=longestLength<len+1?len+1:longestLength;
            lengthForCurrentNode(leftChild,0);
        }


        if (rightChild!=null && rightChild.val==root.val+1){
            lengthForCurrentNode(rightChild,len+1);
        }
        else{
            longestLength=longestLength<len+1?len+1:longestLength;
            lengthForCurrentNode(rightChild,0);
        }
    }

    public static void main(String[] args){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        BinaryTreeLongestConsecutiveSequence solution =new BinaryTreeLongestConsecutiveSequence();
        System.out.println(solution.longestConsecutive(t1));
    }


}
