package CS5800.hw8_2_mine;

/**
 * Created by Ben_Big on 3/12/16.
 */


public class BinaryTreeNode <E> implements Node<E>{
    E value;
    BinaryTreeNode<E> parent;
    BinaryTreeNode<E> leftChild;
    BinaryTreeNode<E> rightChild;

    BinaryTreeNode (E initialValue){
        value=initialValue;
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

    boolean isParent(Node<E> btr){
        BinaryTreeNode<E> temp=parent;
        do{
           if (temp==btr){
               return true;
           }
            temp=temp.parent;
        }while (temp!=null);
        return false;
    }

    public void addLeft(Node<E> newLeft){
        if (!isParent(newLeft)) {
            this.removeLeft();
            leftChild =(BinaryTreeNode<E>) newLeft;
        }
    }

    public void addRight(Node<E> newRight){
        if (!isParent(newRight)) {
            this.removeRight();
            rightChild = (BinaryTreeNode<E>)newRight;
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
    /*
    public void preOrderTraverse(){
        leftChild.preOrderTraverse();


    }*/

}
