/**
 * Created by Ben_Big on 5/27/16.
 */

/**
 * 147. Insertion Sort List
 * Sort a linked list using insertion sort.
 */


/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */

function ListNode(val) {
     this.val = val;
     this.next = null;
}
ListNode.prototype.listToString=function(){
    temp=this;
    while(temp!==null){
        console.log(temp.val);
        temp=temp.next;
    }
};




var insertionSortList = function(head) {
    var numTocompare=0;
    var currentNode=head;
    while(currentNode!==null){
        var temp=currentNode.next;
        currentNode.next=null;
        var sortedNode=head;
        for(var i=0;i<numTocompare;i++){
            if (currentNode.val>=sortedNode.val){
                if(sortedNode.next!==null && currentNode.val<sortedNode.next.val){
                        currentNode.next=sortedNode.next;
                        sortedNode.next=currentNode;
                        break;
                }
                else if (sortedNode.next===null){
                        sortedNode.next=currentNode;
                        break;
                }
                else{//currentNode.val>=sortedNode.next.val
                    sortedNode=sortedNode.next;
                }
            }
            else{
                currentNode.next=sortedNode;
                head=currentNode;
                break;
            }
        }
        numTocompare++;
        currentNode=temp;
    }
    return head;
};




//Test Case 1
T1=new ListNode(3); T2=new ListNode(4); T3=new ListNode(1);
T1.next=T2; T2.next=T3;
insertionSortList(T1).listToString();
console.log("//////");

//Test Case 2
T4=new ListNode(6);
insertionSortList(T4).listToString();
console.log("//////");

//Test Case 3
T5=new ListNode(8);T6=new ListNode(1);
T5.next=T6;
insertionSortList(T5).listToString();

