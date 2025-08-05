/*
Check If Circular Linked List
Difficulty: EasyAccuracy: 54.26%Submissions: 176K+Points: 2Average Time: 15m
Given the head, the head of a singly linked list, Returns true if the linked list is circular & false if it is not circular.

A linked list is called circular if it is not NULL terminated and all nodes are connected in the form of a cycle. 

Note: The linked list does not contain any inner loop.

Examples:

Input: 

Output: true
Explanation: As shown in figure the first and last node is connected, i.e. 5 --> 2
Input: 
 
Output: false
Explanation: As shown in figure this is not a circular linked list.
Constraints:
1 <= number of nodes <= 100
1 <= node -> data <= 104
*/

//code - 
/* Structure of LinkedList
class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/
class Solution {
    boolean isCircular(Node head) {
        // Your code here
        Node slow=head;
        Node fast=head;
        
        do{
            slow=slow.next;
            if(fast==null || fast.next==null) return false;
            fast=fast.next.next;
        }while(slow!=fast || fast.next==head || fast.next.next==head);
    
    return true;        
    }
}

