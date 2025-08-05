/*
Add Number Linked Lists
Difficulty: MediumAccuracy: 34.52%Submissions: 350K+Points: 4Average Time: 30m
Given head of two singly linked lists head1 and head2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples:

Input: head1 = 4 -> 5, head2 = 3 -> 4 -> 5
Output:  3 9 0
Explanation: Given numbers are 45 and 345. There sum is 390.


Input: head1 = 0 -> 0 -> 6 -> 3, head2 = 0 -> 7 
Output: 7 0 
Explanation: Given numbers are 63 and 7. There sum is 70.

Constraints:
1 ≤ list1.size, list2.size ≤ 5*105
0 ≤ node->data ≤ 9


*/

//code - 
/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    static Node addTwoLists(Node head1, Node head2) {
        // code here
        head1=reverse(head1);
        head2=reverse(head2);
        
        Node dummyHead=new Node(-1);
        Node temp=dummyHead;
        
        int carry=0;
        while (head1 != null || head2 != null || carry > 0) {
            int val1 = (head1 != null) ? head1.data : 0;
            int val2 = (head2 != null) ? head2.data : 0;

            int sum = val1 + val2 + carry;

            carry = sum / 10;
            int digit = sum % 10;

            temp.next = new Node(digit);
            temp = temp.next;

            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }
        
        
         Node result = reverse(dummyHead.next);
        return removeLeadingZeros(result);
    }
    
    static Node reverse(Node head){
        Node current=head;
        Node prev=null;
        
        while(current!=null){
            Node nextNode=current.next;
            current.next=prev;
            prev=current;
            current=nextNode;
        }
        
    return prev;
    }
    
    static Node removeLeadingZeros(Node head) {
    // Skip all 0s until last node
    while (head != null && head.data == 0 && head.next != null) {
        head = head.next;
    }
    return head;
}
}
