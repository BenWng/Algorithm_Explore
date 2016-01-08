package Cracking_Interview.Ch2_Linked_List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Ben_Big on 1/7/16.
 */
public class Q_2_1_Revised {
    public static void main(String[] args){
        LinkedList<Integer> test=new LinkedList<Integer>();
        test.add(165);
        test.add(20);
        test.add(30);
        test.add(20);
        test.add(16);
        RemoverClass<Integer> rc =new RemoverClass <Integer>();
        System.out.println(rc.remover(test));
    }
}


class RemoverClass<T>{
    public LinkedList<T> remover(LinkedList<T> ll){
        ListIterator<T> itr=ll.listIterator();
        ArrayList<T> al=new ArrayList<T>();
        while(itr.hasNext()){
            T element=itr.next();
            if (al.contains(element)){
                itr.remove();
            }
            else{
                al.add(element);
            }
        }
        return ll;
    }
}
