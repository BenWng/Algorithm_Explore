package LeetCode;
import LeetCode.DataStructures.ListNode;

/**
 * Created by ben on 1/12/16.
 */


/*
    Given a linked list, swap every two adjacent nodes and return its head.

    For example,
    Given 1->2->3->4, you should return the list as 2->1->4->3.

    Your algorithm should use only constant space.
     You may not modify the values in the list,
     only nodes itself can be changed.
 */

public class SwapNodesPair {
    public static ListNode swapPairs(ListNode head) {
        ListNode itrReturn=head;
        ListNode itr1;
        ListNode itr2;
        ListNode itrPre=null;
        boolean firstTimeFlag=true;

        if (head!=null){
            itr1=head;
            itr2=head.next;
        }
        else{
            return itrReturn;
        }
        while (itr1!=null && itr2!=null){

            ListNode itr1Next=itr1.next;
            ListNode itr2Next=itr2.next;

            ListNode itr1Temp=null;
            ListNode itr2Temp=null;

            //move two nodes ahead, for the next iteration
            if(itr1Next!=null){
                itr1Temp=itr1Next.next;
            }

            if(itr2Next!=null){
                itr2Temp=itr2Next.next;
            }

            //swap
            itr1.next=itr2Next;
            itr2.next=itr1;

            if (firstTimeFlag){
                //if it is the first iteration, reset the head
                itrReturn=itr2;
                firstTimeFlag=false;
            }
            else{
                //itrPre corresponds to the second node in the previous iteration
                itrPre.next=itr2;
            }


            //for next iteration to connect itr1 to the next node (new)
            itrPre=itr1;

            itr1=itr1Temp;
            itr2=itr2Temp;

        }
        return itrReturn;
    }
    public static void main(String[] args){
        ListNode test=new ListNode(1);
        test.next=new ListNode(2);
        /*
        test.next.next=new ListNode(3);
        test.next.next.next=new ListNode(4);
        test.next.next.next.next=new ListNode(5);
        */

        ListNode test2=swapPairs(test);

        while(test2!=null) {
            System.out.println(test2.val);
            test2 = test2.next;
        }
    }
}
