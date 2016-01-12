package LeetCode;

/*
You are given two linked lists representing two non-negative numbers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */


/**
 * Created by Ben_Big on 1/12/16.
 */


//  Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addOn=0;
        ListNode returnList=new ListNode(0);
        ListNode pointer=returnList;
        while(l1!=null || l2!=null){
            int temp=(l1!=null ? l1.val : 0)+(l2!=null ? l2.val :0)+addOn;
            if (temp>=10){
                pointer.val=temp-10;
                addOn=1;
            }
            else{
                pointer.val=temp;
                addOn=0;
            }
            if ((l1!=null && l1.next!=null) || (l2!=null && l2.next!=null)) {
                pointer.next = new ListNode(0);
                pointer = pointer.next;
            }
            else if (addOn==1){
                pointer.next=new ListNode(1);
            }
            if (l1!=null)
                l1=l1.next;
            if (l2!=null)
                l2=l2.next;
        }
        return returnList;
    }
    public static void main(String args[]){
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(8);


        ListNode l2=new ListNode(0);


        ListNode l3=addTwoNumbers(l1,l2);
        do{
            System.out.print(""+l3.val+" ");
            l3=l3.next;
        }while(l3!=null);

    }
}