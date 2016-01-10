package sorting;
import java.util.*;
import java.lang.reflect.Array;

/**
 * Created by ben on 1/8/16.
 */


public class MyLinkedList <T extends Object> {
    class Node{
        T value;
        Node next;
        public Node(T v){
            value=v;
            next=null;
        }
    }

    public Node head;

    public MyLinkedList(T h){
        head=new Node(h);
    }


    /**
     *
     * @return The head of the LinkedList
     */
    T pop(){
        T temp=head.value;
        this.head=head.next;
        return temp;
    }

    /**
     *
     * @param x: The element added to the end of the
     *         LinkedList
     */
    void add(T x){
        Node itr=head;
        while(itr.next!=null){
            itr=itr.next;
        }
        itr.next=new Node(x);
    }

    public T[] show(){
        ArrayList<T> al=new ArrayList<T>();
        Node itr=head;
        while (itr!=null){
            al.add(itr.value);
            itr=itr.next;
        }
        T[] returnArray=(T[]) new Object[al.size()];
        al.toArray(returnArray);
        for(int i=0;i<returnArray.length;i++){
            System.out.print(""+(T)returnArray[i]+" ");
        }
        System.out.println();
        return returnArray;
    }



    public static void main(String args[]){
        MyLinkedList <String> mll=new MyLinkedList<String>("hello");
        mll.add("world");
        mll.add("byebye");
        Object[] result=mll.show();
        mll.pop();
        mll.add("Nihao");
        mll.show();
    }

}
