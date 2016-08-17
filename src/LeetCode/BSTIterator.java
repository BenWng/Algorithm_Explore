package LeetCode;

import LeetCode.DataStructures.TreeNode;

/**
 * Created by ben on 5/22/16.
 */


/**
 * 173.
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
import java.util.*;

public class BSTIterator {

    Stack<TreeNode> s=new Stack();

    public BSTIterator(TreeNode root) {
        TreeNode x=root;
        while (x!=null){
            s.push(x);
            x=x.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return s.empty()?false:true;

    }


    /** @return the next smallest number */
    public int next() {
        TreeNode top=s.pop();
        if(top.right!=null) {
            this.addRight(top.right);
        }
        return top.val;
    }

    private void addRight(TreeNode t){
        s.add(t);
        while(t.left!=null){
            t=t.left;
            s.add(t);
        }
    }

    public static void main(String[] args){
        /*
                 7
                / \
               3   8
              / \   \
             2   5   9
                / \
               4   6
        */



        TreeNode root=new TreeNode(7);
        root.left=new TreeNode(3);root.left.left=new TreeNode(2);root.left.right=new TreeNode(5);
        root.left.right.left=new TreeNode(4); root.left.right.right=new TreeNode(6);
        root.right=new TreeNode(8); root.right.right=new TreeNode(9);


        /*
        TreeNode root=null;
        */



        BSTIterator i=new BSTIterator(root);
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }

}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */