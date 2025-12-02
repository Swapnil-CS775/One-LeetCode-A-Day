/*
Reverse a Doubly Linked List
Difficulty: EasyAccuracy: 70.38%Submissions: 206K+Points: 2Average Time: 15m
You are given the head of a doubly linked list. You have to reverse the doubly linked list and return its head.

Examples:

Input:
   
Output: 5 <-> 4 <-> 3
Explanation: After reversing the given doubly linked list the new list will be 5 <-> 4 <-> 3.
   
Input: 
   
Output: 196 <-> 59 <-> 122 <-> 75
Explanation: After reversing the given doubly linked list the new list will be 196 <-> 59 <-> 122 <-> 75.
   
Constraints:
1 ≤ number of nodes ≤ 106
0 ≤ node->data ≤ 104
*/

//code - 
/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        Node prev=null;
        Node current=head;
        Node next=null;

        while (current!=null){
            next=current;
            current=current.next;
            next.next=prev;
            next.prev=current;
            prev=next;
        }

        return prev;
    }
}
