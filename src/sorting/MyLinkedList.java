package sorting;
import java.util.*;

/**
 * Created by ben on 1/8/16.
 */

//ToDo: the generic and the conflict with ArrayList.

public class MyLinkedList <T extends Object> {
    class Node<T extends Object>{
        T value;
        Node<T> next;
        public Node(T v){
            value=v;
            next=null;
        }
    }

    public Node<T> head;

    public MyLinkedList(T h){
        head=new Node<T>(h);
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
    /*
    public T[] show(){
        ArrayList<T> al=new ArrayList<T>();
        Node itr=head;
        while (itr!=null){
            al.add(itr.value);
            itr=itr.next;
        }
        return al.toArray();
    }*/
    void show(){
        Node itr=head;
        while (itr!=null){
            System.out.print(""+itr.value+ " ");
            itr=itr.next;
        }
        System.out.println();
    }


    public static void main(String args[]){
        MyLinkedList <String> mll=new MyLinkedList<String>("hello");
        mll.add("world");
        mll.add("byebye");
        mll.show();
        mll.pop();
        mll.add("Nihao");
        mll.show();
    }

}
