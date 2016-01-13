package LeetCode;
import LeetCode.DataStructures.TreeNode;

import java.util.*;

/**
 * Created by ben on 1/10/16.
 */


/*Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].*/




public class preorderTraversal {
    /**
     * This is the recursion version
     * It is a depth first
     */

    public List<Integer> recursiveTraversal(TreeNode root) {
        ArrayList<Integer> al=new ArrayList<>();
        f1(root,al);
        return al;
    }
    void f1( TreeNode r, ArrayList<Integer> arrl){
        if (r!=null && r.val!='#'){
            arrl.add(r.val);
            if(r.left!= null){
                f1(r.left,arrl);
            }
            if(r.right!= null){
                f1(r.right,arrl);
            }

        }
    }


    //ToDo: redo the iterative part sometime
    /**
     * This is the Iteration version
     */

    public List<Integer> iterativeTraversal(TreeNode root) {
        ArrayList<Integer> al=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if (root!=null) {
            stack.add(root);
        }

        while (!stack.empty()){
            TreeNode temp=stack.pop();
            al.add(temp.val);

            if (temp.right != null) {
                stack.add(temp.right);
            }
            if (temp.left != null) {
                stack.add(temp.left);
            }
        }
        return al;
    }

    public static void main(String[] args){
        TreeNode tn=new TreeNode(10);
        tn.left=new TreeNode(20);
        tn.right=new TreeNode(30);
        (tn.left).left=new TreeNode(40);
        preorderTraversal pt=new preorderTraversal();
        System.out.println(pt.iterativeTraversal(tn));

    }
}