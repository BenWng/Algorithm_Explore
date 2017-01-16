package LeetCode;

/**
 * Created by Ben_Big on 1/16/17.
 */

import java.util.*;

/**
 * 297. Serialize and Deserialize Binary Tree   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 45582
 Total Submissions: 143841
 Difficulty: Hard
 Contributors: Admin
 Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 For example, you may serialize the following tree

 1
 / \
 2   3
 / \
 4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */


public class SerializeAndDeserializeBinaryTree {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        ArrayList<String> resultArray= new ArrayList<>();
        String result="";
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode head=queue.poll();
            if (head!=null){
                queue.add(head.left);
                queue.add(head.right);
                resultArray.add(Integer.toString(head.val));
            }
            else{
                resultArray.add("null");
            }
        }
        for (String str : resultArray){
            result+=(str+" ");
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        //Translate the string into nodes
        String [] values=data.split(" ");
        Queue<String> valuesList=new LinkedList(Arrays.asList(values));
        Queue<TreeNode> nodesList=new LinkedList<>();

        while(!valuesList.isEmpty()){
            String value=valuesList.poll();
            if (value=="null"){
                nodesList.add(null);
            }
            else{
                TreeNode newNode=new TreeNode(Integer.parseInt(value));
                nodesList.add(newNode);
            }
        }


        //Process all the nodes level by level
        Queue<TreeNode> preLevelNodesCache=new LinkedList<>();
        Queue<TreeNode> currentLevelNodesCache=new LinkedList<>();

        TreeNode root=nodesList.poll();
        int level=1;
        preLevelNodesCache.add(root);
        while(!nodesList.isEmpty()){
            for (int i=0;i<Math.pow(2,level)&& !nodesList.isEmpty();i++){
                currentLevelNodesCache.add(nodesList.poll());
            }
            //Add the nodes in currentLevelNodeCache to the nodes in preLevelNodeCache as their chidren
            addChildNode(preLevelNodesCache,currentLevelNodesCache);
            preLevelNodesCache=currentLevelNodesCache;
            currentLevelNodesCache=new LinkedList<>();
        }

        return root;
    }
    private void addChildNode(Queue<TreeNode>preLevelNodesCache, Queue<TreeNode>currentLevelNodesCache){
        Iterator<TreeNode> itr=currentLevelNodesCache.iterator();
        while (!preLevelNodesCache.isEmpty()){
            TreeNode parent=preLevelNodesCache.poll();
            for (int i=0;i<2&& itr.hasNext();i++){
                TreeNode child=itr.next();
                if (i==0) parent.left=child;
                else parent.right=child;
            }
        }
    }



}
