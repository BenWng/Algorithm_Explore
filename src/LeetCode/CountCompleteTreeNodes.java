package LeetCode;

/**
 * Created by Ben_Big on 10/1/16.
 */


/**
 * 222. Count Complete Tree Nodes
 Question
 Editorial Solution
 My Submissions

 •	Total Accepted: 44743
 •	Total Submissions: 168961
 •	Difficulty: Medium

 Given a complete binary tree, count the number of nodes.
 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 */

//ToDo: this problem needs revisit, I initially thought traversal the whole tree should be good enough, but it is too slow


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// The following code would still exceed time limit, the culprit is Math.pow
/*
public class CountCompleteTreeNodes {
    private int totalNodeNumber=0;
    public int countNodes(TreeNode root){
         TreeNode currentNode=root;
        int heightOfTheCurrentTree=-1;
        while(currentNode!=null){
            totalNodeNumber++;
            int leftHeight=0;
            if (heightOfTheCurrentTree==-1) {
                leftHeight = GetHeight(currentNode.left);
            }
            else{
                leftHeight=heightOfTheCurrentTree-1;
            }
            int rightHeight=GetHeight(currentNode.right);
            if (leftHeight==rightHeight){
                totalNodeNumber+=(Math.pow(2,leftHeight)-1);
                currentNode=currentNode.right;
                heightOfTheCurrentTree=rightHeight;
            }
            else{
                totalNodeNumber+=(Math.pow(2,rightHeight)-1);
                currentNode=currentNode.left;
                heightOfTheCurrentTree=leftHeight;
            }
        }
        return totalNodeNumber;
    }
    private int GetHeight(TreeNode tn){
        int height=0;
        while(tn!=null){
            height++;
            tn=tn.left;
        }
        return height;
    }
}*/

public class CountCompleteTreeNodes {
    private int totalNodeNumber=0;
    public int countNodes(TreeNode root){
        TreeNode currentNode=root;
        int heightOfTheCurrentTree=-1;
        while(currentNode!=null){
            totalNodeNumber++;
            int leftHeight=0;
            if (heightOfTheCurrentTree==-1) {
                leftHeight = GetHeight(currentNode.left);
            }
            else{
                leftHeight=heightOfTheCurrentTree-1;
            }
            int rightHeight=GetHeight(currentNode.right);
            if (leftHeight==rightHeight){
                int temp=1;
                for (int j=0;j<leftHeight;j++){
                    temp=temp*2;
                }


                totalNodeNumber+=(temp-1);
                currentNode=currentNode.right;
                heightOfTheCurrentTree=rightHeight;
            }
            else{
                int temp=1;
                for (int j=0;j<rightHeight;j++){
                    temp=temp*2;
                }


                totalNodeNumber+=(temp-1);
                currentNode=currentNode.left;
                heightOfTheCurrentTree=leftHeight;
            }
        }
        return totalNodeNumber;
    }
    private int GetHeight(TreeNode tn) {
        int height=0;
        while(tn!=null){
            height++;
            tn=tn.left;
        }
        return height;
    }
}
