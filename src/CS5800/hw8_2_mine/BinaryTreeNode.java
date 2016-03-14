package CS5800.hw8_2_mine;

import java.awt.Color;

/**
 * Created by Ben_Big on 3/12/16.
 */


public class BinaryTreeNode  implements Node{
    int value;
    BinaryTreeNode parent;
    BinaryTreeNode leftChild;
    BinaryTreeNode rightChild;
    Color color;

    BinaryTreeNode (int initialValue){
        value=initialValue;
        color=Color.black;
    }

    public int getValue(){
        return value;
    }

    public void changeValue(int x){
        value=x;
    }

    public Node getLeft(){
        return leftChild;
    }

    public Node getRight(){
        return rightChild;
    }

    public Node getParent(){
        return parent;
    }

    public void removeLeft(){
        if (leftChild!=null){
            leftChild.parent=null;
            leftChild=null;
        }
    }

    public void removeRight(){
        if (rightChild!=null){
            rightChild.parent=null;
            rightChild=null;
        }
    }

    boolean isParent(Node btr){
        BinaryTreeNode temp=parent;
        do{
           if (temp==btr){
               return true;
           }
            temp=temp.parent;
        }while (temp!=null);
        return false;
    }

    public void addLeft(Node newLeft){
        if (!isParent(newLeft)) {
            this.removeLeft();
            leftChild =(BinaryTreeNode) newLeft;
        }
    }

    public void addRight(Node newRight){
        if (!isParent(newRight)) {
            this.removeRight();
            rightChild = (BinaryTreeNode)newRight;
        }
    }

    public void removeFromParent(){
        if (parent!=null){
            if (parent.leftChild==this){
                parent.leftChild=null;
                parent=null;
            }
            else if (parent.rightChild==this){
                parent.rightChild=null;
                parent=null;
            }
        }
    }

    public void preOrderTraverse(Traverser tra, Node n){
        if (leftChild!=n) {
            leftChild.preOrderTraverse(tra,n);
        }
        if (this!=n) {
            tra.Traverse(this);
        }
        if (rightChild!=n) {
            rightChild.preOrderTraverse(tra,n);
        }
    }

}
