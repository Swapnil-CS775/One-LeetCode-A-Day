/*
Rotate doubly Linked List
Difficulty: EasyAccuracy: 74.54%Submissions: 28K+Points: 2
Given a doubly linked list, rotate the linked list counter-clockwise by P nodes. Here P is a given positive integer and is smaller than the count of nodes(N) in a linked list.

Examples :

Input: Doubly Linkedlist: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 ,p = 2
Output: 3 <-> 4 <-> 5 <-> 6 <-> 1 <-> 2
Explanation: Doubly linked list after rotating
2 nodes is: 3 4 5 6 1 2.
Input: Doubly Linkedlist: 3 <-> 4 <-> 5 <-> 1 ,p = 3
Output: 1 <-> 3 <-> 4 <-> 5
Input: Doubly Linkedlist: 1 <-> 2 <-> 3 <-> 1 ,p = 2
Output: 3 <-> 1 <-> 2
Constraints:
1 <= p <=  105
2 <= number of nodes <= 105
*/

//code - 
class Solution {
    public Node rotateDLL(Node head, int p) {
        // code here..
        int k=p;
        if (k==0 || head==null || head.next==null) return head;
        Node temp=head;
        int length=1;
        while (temp.next!=null) {
            temp=temp.next;
            length++;
        }
        if(k%length==0) return head;
        int optimalRot=k>length ? k%length : k;
        Node oldTail=temp;

        temp=head;
        while (optimalRot!=1){
            temp=temp.next;
            optimalRot--;
        }
        Node newHead=temp.next;
        newHead.prev=null;
        Node newTail=temp;
        temp.next=null;
        oldTail.next=head;
        head.prev=newTail;

        return newHead;
    }
}
