/*
Remove loop in Linked List
Difficulty: MediumAccuracy: 27.66%Submissions: 526K+Points: 4Average Time: 45m
Given the head of a singly linked list, the task is to remove a cycle if present. A cycle exists when a node's next pointer points back to a previous node, forming a loop. Internally, a variable pos denotes the index of the node where the cycle starts, but it is not passed as a parameter. The terminal will print true if a cycle is removed otherwise, it will print false.

Examples:

Input: head = 1 -> 3 -> 4, pos = 2
Output: true
Explanation: The linked list looks like

A loop is present in the list, and it is removed.
Input: head = 1 -> 8 -> 3 -> 4, pos = 0
Output: true
Explanation: 

The Linked list does not contains any loop. 
Input: head = 1 -> 2 -> 3 -> 4, pos = 1
Output: true
Explanation: The linked list looks like 

A loop is present in the list, and it is removed.
Constraints:
1 ≤ size of linked list ≤ 105
*/

//code - 
/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    public static void removeLoop(Node head) {
        // code here
        Node slow=head,fast=head;
        Node prev=null;
        do{
            prev=slow;
            slow=slow.next;
            if(fast==null || fast.next==null ) return;
            fast=fast.next.next;
        }while(slow!=fast);
        
        //special case for if loop starts at head
        if(prev.next==head){
            prev.next=null;
            return;
        }
        
        slow=head;
        while(slow!=fast){
            prev=fast;
            fast=fast.next;
            slow=slow.next;
        }
        if(prev!=null){
            prev.next=null;
        }
    }
}
