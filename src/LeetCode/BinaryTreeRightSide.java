package LeetCode;
import LeetCode.DataStructures.TreeNode;
import java.util.*;

/**
 * Created by ben on 1/12/16.
 */

/*
Given a binary tree, imagine yourself standing on the
right side of it, return the values of the nodes you
can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */



public class BinaryTreeRightSide {
    public static ArrayList<Integer> rightview(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> al = new ArrayList<>();
        LinkedList<TreeNode> ll = new LinkedList<>();
        ArrayList<Integer> returnResult=new ArrayList<>();
        ll.add(root);
        al.add(ll);
        boolean haltFlag=false;
        do{
            LinkedList<TreeNode> ll2=al.get(al.size()-1);
            LinkedList<TreeNode> ll3=new LinkedList<>();
            ListIterator<TreeNode> li=ll2.listIterator();

            if (ll2.peekLast()!=null)
                returnResult.add(ll2.peekLast().val);

            while(li.hasNext()){
                TreeNode temp=li.next();
                if(temp!=null && temp.left!=null){
                    ll3.add(temp.left);
                }
                if(temp!=null && temp.right!=null){
                    ll3.add(temp.right);
                }
            }
            TreeNode temp2=ll3.peekLast();
            if(temp2!=null){
                haltFlag=false;
                al.add(ll3);
            }
            else{
                haltFlag=true;
            }
        }while(haltFlag!=true);

        return  returnResult;
    }

    public static void main(String[] args){
           TreeNode test=new TreeNode(1);
            test.left=new TreeNode(3);
            System.out.println(rightview(test));
    }
}
