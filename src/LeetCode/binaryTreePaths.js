/**
 * Created by Ben_Big on 10/6/16.
 */
/**
 * 257. Binary Tree Paths  QuestionEditorial Solution  My Submissions
 Total Accepted: 70100
 Total Submissions: 214904
 Difficulty: Easy
 Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]

 */



"use strict";

function TreeNode(val){
    this.val=val;
    this.left=this.right=null;
}


var binaryTreePath=function(root){
    var result=new Array();
    if (root===null){
        return result;
    }
    var recursiveTreeTraversal=function(str,currentNode){
        var strPlusCurrentValue;
        if(str===""){
            strPlusCurrentValue=str+currentNode.val;
        }
        else {
            strPlusCurrentValue = str + "->" + currentNode.val;
        }
        if(currentNode.left!==null){
            recursiveTreeTraversal(strPlusCurrentValue,currentNode.left);
        }
        if(currentNode.right!==null){
            recursiveTreeTraversal(strPlusCurrentValue,currentNode.right);
        }
        if(currentNode.left===null && currentNode.right===null){
            result.push(strPlusCurrentValue);
        }
    }
    recursiveTreeTraversal("",root);
    return result;
}

var root=new TreeNode(3);
var rootLeft=new TreeNode(5);
var rootRight=new TreeNode(8);
var rootLeftLeft=new TreeNode(7);
root.left=rootLeft;
root.right=rootRight;
rootLeft.left=rootLeftLeft;
console.log(binaryTreePath(root));


