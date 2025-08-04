/*
Move Last Element to Front of a Linked List
Difficulty: EasyAccuracy: 69.09%Submissions: 42K+Points: 2Average Time: 10m
You are given the head of a Linked List. You have to move the last element to the front of the Linked List and return the head the modified linked list.

Examples:

Input: Linked List: 2->5->6->2->1
Output: 1->2->5->6->2

Explanation: In the given linked list, the last element is 1, after moving the last element to the front the linked list will be 1->2->5->6->2
Input: Linked List: 2
Output: 2
Explanation: Here 2 is the only element so, the linked list will remain the same.
Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

Constraints:
1 <= size of linked list <= 106
0 <= elements of list <= 109


*/

//code - 
/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static Node moveToFront(Node head) {
        // code here
        if(head.next==null) return head;
        
        Node current=head;
        while(current.next.next!=null) current=current.next;
        current.next.next=head;
        head=current.next;
        current.next=null;
        return head;
    }
}
