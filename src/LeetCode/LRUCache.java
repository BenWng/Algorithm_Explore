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

    }

    class DoubleLinkedList{

    }
    int capacity;
    HashMap<Integer,Integer> keyToValue=new HashMap<>();
    HashMap<Integer,Integer>keyToIndex=new HashMap<>();
    LinkedList<Integer> useFrequency=new LinkedList<>();//The head of the linkedlist is least used...
    //... The tail is just used.
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) return -1;
        int result=keyToValue.get(key);
        int index=keyToIndex.get(key);
        useFrequency.remove(index);
        useFrequency.addLast(key);
        int newIndex=useFrequency.size()-1;
        keyToIndex.replace(key,index,newIndex);
        return result;
    }

    public void set(int key, int value) {
        if (keyToValue.containsKey(key)){
            int oldValue=keyToValue.get(key);
            keyToValue.replace(key,oldValue,value);
            int index=keyToIndex.get(key);
            useFrequency.remove(index);
            useFrequency.addLast(key);
            int newIndex=useFrequency.size()-1;
            keyToIndex.replace(key,index,newIndex);
        }
        else{
            if (useFrequency.size()==capacity) {
                int oldKey = useFrequency.getFirst();
                useFrequency.remove(0);
                keyToValue.remove(oldKey);
                keyToIndex.remove(oldKey);
            }
            keyToValue.put(key,value);
            useFrequency.addLast(key);
            int newIndex=useFrequency.size()-1;
            keyToIndex.put(key,newIndex);
        }
    }
    public static void main(String[] args){
        LRUCache lruc=new LRUCache(3);
        System.out.println(lruc.get(3));//expect -1
        lruc.set(5,8);
        lruc.set(6,7);
        System.out.println(lruc.get(5));
    }


}
