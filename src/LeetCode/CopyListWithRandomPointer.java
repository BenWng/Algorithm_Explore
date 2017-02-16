package LeetCode;

import java.util.HashMap;

/* 138.
    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

        Return a deep copy of the list.*/


class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class CopyListWithRandomPointer {



    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null){
            return null;
        }

        HashMap<RandomListNode,Integer> nodeToInteger=new HashMap<>();
        //1. Go through the linkedlist to add every node being pointed into a HashMap, use it as the key
        for (RandomListNode p=head;p!=null;p=p.next){
            if (p.random!=null){
                nodeToInteger.put(p.random,-1);
            }
        }
        //2. Go through the linkedlist to give every key (node) its position in the linkedlist as value
        int i=0;
        for (RandomListNode p=head;p!=null;p=p.next, i++){
            if (nodeToInteger.containsKey(p)){
                nodeToInteger.replace(p,i);
            }
        }
        int length=i;
        //3. Go through the linkedlist, lookup every node to build the array(index:a node's position, value:the poistion of the node previous node points to)
        int[] positionToPointedPosition=new int[length];
        int j=0;
        for (RandomListNode p=head;p!=null;p=p.next,j++){
            if (p.random!=null){
                positionToPointedPosition[j]=nodeToInteger.get(p.random);
            }
            else{
                positionToPointedPosition[j]=-1;
            }
        }
        //4. Go through the linkedlist to copy each node
        RandomListNode newHead=new RandomListNode(head.label);
        RandomListNode pre=newHead;
        for (RandomListNode p=head.next;p!=null;p=p.next){
            pre.next=new RandomListNode(p.label);
            pre=pre.next;
        }
        //5. Go through the copied linkedlist to build another hashmap (key:position, value: the copied node being pointed to)
        HashMap<Integer,RandomListNode> integerToNode=new HashMap<>();
        int k=0;
        for (RandomListNode p=newHead;p!=null;p=p.next,k++){
            if (nodeToInteger.containsValue(k)){
                integerToNode.put(k,p);
            }
        }
        //6. Go through the copied linkedlist to give each node a pointer based on the hashmap from step 5
        int l=0;
        for (RandomListNode p=newHead;p!=null;p=p.next,l++){
            if (positionToPointedPosition[l]!=-1){
                p.random=integerToNode.get(positionToPointedPosition[l]);
            }

        }
        return newHead;

    }
    public static void main(String[] args){
        CopyListWithRandomPointer clwrp=new CopyListWithRandomPointer();
        RandomListNode test1=new RandomListNode(-1);
        clwrp.copyRandomList(test1);
    }

}
