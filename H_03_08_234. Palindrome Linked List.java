/*
234. Palindrome Linked List
Solved
Easy
Topics
premium lock icon
Companies
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?
Seen this question in a real interview before?

*/

//code - 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode mid=findMid(head);

        ListNode second=revFromMid(mid);
        ListNode first=head;
        while(second!=null){
            if(first.val!=second.val){
                return false;
            }
        second=second.next;
        first=first.next;
        }
    return true;
    }

    ListNode findMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }


    ListNode revFromMid(ListNode mid){
        ListNode prev=null;
        ListNode current=mid;
        ListNode nextNode=current.next;

        while(current.next!=null){
            current.next=prev;
            prev=current;
            current=nextNode;
            nextNode=nextNode.next;
        }
        current.next=prev;

    return current;
    }
}
