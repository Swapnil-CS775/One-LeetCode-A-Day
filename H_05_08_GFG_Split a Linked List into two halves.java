/*
Split a Linked List into two halves
Difficulty: EasyAccuracy: 61.63%Submissions: 60K+Points: 2
Given a Circular linked list. The task is split into two Circular Linked lists. If there are an odd number of nodes in the given circular linked list then out of the resulting two halved lists, the first list should have one node more than the second list.

Examples :

Input: LinkedList : 10->4->9
Output: 10->4 , 9

Explanation: After dividing linked list into 2 parts , the first part contains 10, 4 and second part contain only 9.
Input: LinkedList : 10->4->9->10
Output: 10->4 , 9->10

Explanation: After dividing linked list into 2 parts , the first part contains 10, 4 and second part contain 9, 10.
Constraints:
2 <= number of nodes <= 105
1 <= node->data <= 103


*/

//code - 
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    public Pair<Node, Node> splitList(Node head) {
        // Code here
        Node ans1=head;
        Node ans2=null;
        Node slow=head;
        Node fast=head;
        
        while(fast.next!=head && fast.next.next!=head){
            slow=slow.next;
            fast=fast.next.next;
        }

      //if list contain odd no. of nodes
        if(fast.next==head){
            ans2=slow.next;
            fast.next=ans2;
            
            ans1=head;
            slow.next=ans1;
            
        }

       //if list contain even no. of nodes
        if(fast.next.next==head){
            ans2=slow.next;
            fast.next.next=ans2;
            ans1=head;
            slowPrev.next=ans1;
            ans1=head;
            slow.next=ans1;
        }
        
    return new Pair<>(ans1,ans2);
    }
}
