package CS5800.hw8_2_mine;

import java.awt.*;

/**
 * Created by Ben_Big on 3/12/16.
 */

public class RedBlackTree {

    BinaryTreeNode root;
    BinaryTreeNode sentinel;
    int height;

    RedBlackTree(){
        sentinel=new BinaryTreeNode(0);
        sentinel.parent=sentinel;
        sentinel.rightChild=sentinel;
        sentinel.leftChild=sentinel;
        root=sentinel;
    }

   void setRoot(int z){
       root=new BinaryTreeNode(z);
       sentinel=new BinaryTreeNode(0);

       root.parent=sentinel;
       root.leftChild=sentinel;
       root.rightChild=sentinel;

       sentinel.leftChild=sentinel;
       sentinel.rightChild=sentinel;
   }



    // I think initially root is also sentinel, so some part of setRoot is not necessary

    void insert(int z){
        /*
           if(root==null){
                setRoot(z);
                return;
            }*/
            BinaryTreeNode y=sentinel;
            BinaryTreeNode x=root;
            BinaryTreeNode newNode=new BinaryTreeNode(z);
            while (x!=sentinel) {
                y = x;
                if (newNode.value < x.value) {
                    x = x.leftChild;
                } else {
                    x = x.rightChild;
                }
            }
            newNode.parent = y;
            if (y==sentinel){
                root=newNode;
            }
            else if(newNode.value<y.value){
                y.leftChild=newNode;

            }
            else{
                y.rightChild=newNode;
            }
            newNode.leftChild=sentinel;
            newNode.rightChild=sentinel;
            newNode.color= Color.red;
            insert_fix(newNode);

    }

    void insert_fix(BinaryTreeNode newNode){

        while (newNode.parent.color==Color.red){
            // newNode.parent would never be root, since newNode.parent is red
            if (newNode.parent==newNode.parent.parent.leftChild) {
                BinaryTreeNode y= newNode.parent.parent.rightChild;
                if (y.color==Color.red){
                    newNode.parent.color=Color.black;
                    y.color=Color.black;
                    newNode.parent.parent.color=Color.red;
                    newNode=newNode.parent.parent;
                }
                else if (newNode==newNode.parent.rightChild) {
                    newNode=newNode.parent;
                    rotateLeft(newNode);
                }
                else {
                    newNode.parent.color = Color.black;
                    newNode.parent.parent.color = Color.red;
                    rotateRight(newNode);
                }
            }
            // else clause is symmetric to then clause, just exchange left and right
            else{
                BinaryTreeNode y= newNode.parent.parent.leftChild;
                if (y.color==Color.red){
                    newNode.parent.color=Color.black;
                    y.color=Color.black;
                    newNode.parent.parent.color=Color.red;
                    newNode=newNode.parent.parent;
                }
                else if (newNode==newNode.parent.leftChild) {
                    newNode=newNode.parent;
                    rotateRight(newNode);
                }
                else {
                    newNode.parent.color = Color.black;
                    newNode.parent.parent.color = Color.red;
                    rotateLeft(newNode);
                }
            }
        }
        root.color=Color.black;
    }

    private BinaryTreeNode successor_private(BinaryTreeNode x){
        if (x.rightChild!=sentinel)
            return min_private(x.rightChild);
        BinaryTreeNode y=x.parent;
        while (y!=sentinel && x==y.rightChild){
            x=y;
            y=y.parent;
        }
        return y;
    }

    private BinaryTreeNode predecessor_private(BinaryTreeNode x){
        if (x.leftChild!=sentinel)
            return max_private(x.leftChild);
        BinaryTreeNode y=x.parent;
        while (y!=sentinel && x==y.leftChild){
            x=y;
            y=y.parent;
        }
        return y;
    }

    private BinaryTreeNode min_private(BinaryTreeNode x){
        while (x.leftChild!=sentinel){
            x=x.leftChild;
        }
        return x;
    }

    private BinaryTreeNode max_private(BinaryTreeNode x){
        while (x.rightChild!=sentinel){
            x=x.rightChild;
        }
        return x;
    }

    private BinaryTreeNode search_private(int x){
        BinaryTreeNode y=root;
        while (y!=sentinel) {
            if (y.value == x) {
                return y;
            }
            else if (y.value<x){
                y=y.rightChild;
            }
            else {
                y=y.leftChild;
            }
        }
        return null;
    }

    void rotateLeft(BinaryTreeNode x){
        BinaryTreeNode y=x.rightChild;
        x.rightChild=y.leftChild;
        if (y.leftChild!=sentinel){
            y.leftChild.parent=x;
        }
        y.parent=x.parent;
        if(x.parent==sentinel){
            root=y;
        }
        else if(x==x.parent.leftChild){
            x.parent.leftChild=y;
        }
        else{
            x.parent.rightChild=y;
        }
        y.leftChild=x;
        x.parent=y;
    }

    void rotateRight(BinaryTreeNode x){
        BinaryTreeNode y=x.leftChild;
        x.leftChild=y.rightChild;
        if (y.rightChild!=sentinel){
            y.rightChild.parent=x;
        }
        y.parent=x.parent;
        if(x.parent==sentinel){
            root=y;
        }
        else if(x==x.parent.rightChild){
            x.parent.rightChild=y;
        }
        else{
            x.parent.leftChild=y;
        }
        y.rightChild=x;
        x.parent=y;

    }


    void successor(int x){
        BinaryTreeNode y=search_private(x);
        if (y==null){
            System.out.println(""+x+" is not in the tree");
        }
        else{
            BinaryTreeNode suc=successor_private(y);
            if (suc==sentinel){
                System.out.println(x+" is the largest element, no successor");
            }
            else {
                System.out.println("" + x + "'s successor is " + suc.value);
            }
        }
    }

    void predecessor(int x){
        BinaryTreeNode y=search_private(x);
        if (y==null){
            System.out.println(""+x+" is not in the tree");
        }
        else{
            BinaryTreeNode pre=predecessor_private(y);
            if (pre==sentinel){
                System.out.println(x+" is the smallest element, no predecessor");
            }
            else {
                System.out.println("" + x + "'s predecessor is " + pre.value);
            }
        }
    }

    void min(){
        BinaryTreeNode y=min_private(root);
        if (y==sentinel) {
            System.out.println("The tree is empty");
        }
        else {
            System.out.println("Minimum is "+y.value);
        }
    }

    void max(){
        BinaryTreeNode y=max_private(root);
        if (y==sentinel) {
            System.out.println("The tree is empty");
        }
        else {
            System.out.println("Maximum is "+y.value);
        }

    }


    void search(int x){
        BinaryTreeNode y=search_private(x);
        if (y==null){
            System.out.println(""+x+" is not in the tree");
        }
        else{
            System.out.println(""+x+" is in the tree");
        }
    }


    void height(){
        heightOfTree(root,0);
        System.out.println("height= "+height);
    }

    private void heightOfTree(BinaryTreeNode btr,int h){
        if (btr==sentinel){
            if (h>height){
                height=h;
            }
        }
        else{
            heightOfTree(btr.leftChild,h+1);
            heightOfTree(btr.rightChild,h+1);
        }

    }


    void sort(){
        root.preOrderTraverse(new Node.Traverser(){
            public void Traverse(Node n){
                System.out.print(n.getValue()+" ");
            }
        },sentinel);
        System.out.println();
    }

    void printTree(){}



    public static void main(String[] args){
        RedBlackTree rbt=new RedBlackTree();


        rbt.insert(26);
        rbt.insert(41);
        rbt.height();
        rbt.insert(17);
        rbt.height();
        rbt.insert(30);
        rbt.height();
        rbt.insert(47);


        rbt.insert(38);
        rbt.insert(50);
        rbt.height();
        rbt.sort();

        rbt.max();
        rbt.min();



    }
}
