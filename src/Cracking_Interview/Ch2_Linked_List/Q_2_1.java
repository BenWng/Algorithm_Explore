package Cracking_Interview.Ch2_Linked_List;
import java.util.*;


/**
 * Created by Ben_Big on 1/5/16.
 */

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list
 *FOLLOW UP . How would you solve this problem if a temporary buffer is not allowed
 */



public class Q_2_1 {
    public static void main(String[] args){
        LinkedList<String> test=new LinkedList<String>();
        test.add("A");
        test.add("B");
        test.add("A");
        test.add("C");
        test.add("D");
        System.out.println(remover(test));
    }

    public static LinkedList<String> remover(LinkedList<String> ll){
           ListIterator<String> itr=ll.listIterator();
           ArrayList <String> al=new ArrayList<String>();
           while(itr.hasNext()){
               String element=itr.next();
                if (al.contains(element)){
                    itr.remove();
                }
                else{
                    al.add(element);
                }
           }
        return ll;
    }

    /**
     * removerNoBuffer does not work
     * It is not possible to change a list with two iterators
     * at the same time. The details see Evernote.
     */

    public static LinkedList<String> removerNoBuffer(LinkedList<String> ll){
        ListIterator<String> itr=ll.listIterator();
        while(itr.hasNext()){
            String element=itr.next();
            ListIterator<String> itr2=ll.listIterator(itr.nextIndex());
            while(itr2.hasNext()){
                if(itr2.next() == element){
                    itr2.remove();
                }
            }
        }
        return ll;
    }
}
