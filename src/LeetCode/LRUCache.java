package LeetCode;

/**
 * Created by ben on 11/19/16.
 */

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 146. LRU Cache   QuestionEditorial Solution  My Submissions
 Total Accepted: 98577
 Total Submissions: 620206
 Difficulty: Hard
 Contributors: Admin
 Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Show Company Tags
 Show Tags

 */


public class LRUCache {

    class DoubleLinkedListNode{
        int val;
        DoubleLinkedListNode next;
        DoubleLinkedListNode pre;
        DoubleLinkedListNode(int val){
            this.val=val;
            this.next=null;
            this.pre=null;
        }
    }

    class DoubleLinkedList{
        DoubleLinkedListNode head;
        DoubleLinkedListNode tail;
        int size=0;
        DoubleLinkedList(){
            head=new DoubleLinkedListNode(0);
            tail=new DoubleLinkedListNode(0);
            head.next=tail;
            tail.pre=head;
        }
        void addToFront(DoubleLinkedListNode node){
            DoubleLinkedListNode nextNode=head.next;
            head.next=node;
            node.pre=head;
            node.next=nextNode;
            nextNode.pre=node;
            size++;
        }
        void addToBack(DoubleLinkedListNode node){
            DoubleLinkedListNode preNode=tail.pre;
            preNode.next=node;
            node.pre=preNode;
            node.next=tail;
            tail.pre=node;
            size++;
        }
        void remove(DoubleLinkedListNode node){
            DoubleLinkedListNode preNode=node.pre;
            DoubleLinkedListNode nextNode=node.next;
            preNode.next=nextNode;
            nextNode.pre=preNode;
            size--;
        }
        DoubleLinkedListNode first(){
            return head.next;
        }
        DoubleLinkedListNode last(){
            return tail.pre;
        }
        int size(){
            return size;
        }
    }


    int capacity;
    HashMap<Integer,Integer> keyToValue=new HashMap<>();
    HashMap<Integer,DoubleLinkedListNode>keyToIndex=new HashMap<>();
    DoubleLinkedList useFrequency=new DoubleLinkedList();//The head of the linkedlist is least used...
    //... The tail is just used.
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) return -1;
        int result=keyToValue.get(key);
        DoubleLinkedListNode oldNode=keyToIndex.get(key);
        useFrequency.remove(oldNode);
        useFrequency.addToBack(oldNode);
        return result;
    }

    public void set(int key, int value) {
        if (keyToValue.containsKey(key)){
            int oldValue=keyToValue.get(key);
            keyToValue.replace(key,oldValue,value);
            DoubleLinkedListNode oldNode=keyToIndex.get(key);
            useFrequency.remove(oldNode);
            useFrequency.addToBack(oldNode);
        }
        else{
            if (useFrequency.size()==capacity) {
                DoubleLinkedListNode first= useFrequency.first();
                useFrequency.remove(first);
                int oldKey=first.val;
                keyToValue.remove(oldKey);
                keyToIndex.remove(oldKey);
            }
            keyToValue.put(key,value);
            DoubleLinkedListNode newNode=new DoubleLinkedListNode(key);
            useFrequency.addToBack(newNode);
            keyToIndex.put(key,newNode);
        }
    }
    public static void main(String[] args){
        LRUCache lruc=new LRUCache(3);
        System.out.println(lruc.get(3));//expect -1
        lruc.set(5,-8);
        lruc.set(6,-7);
        System.out.println(lruc.get(5));
        lruc.set(18,-21);
        lruc.set(33,-35);
    }


}
