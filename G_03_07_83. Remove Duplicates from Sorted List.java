/*
83. Remove Duplicates from Sorted List
Solved
Easy
Topics
premium lock icon
Companies
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Input: head = [1,1,2]
Output: [1,2]

Input: head = [1,1,2,3,3]
Output: [1,2,3]


Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.


*/


//Ans - 
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        removeDuplicate(head);
        return head;
    }



    void removeDuplicate(ListNode head){
        ListNode currentNode=head;
        ListNode temp=currentNode.next;

        while(temp!=null){
            if(currentNode.val==temp.val){
                temp = temp.next;
            }else{
                currentNode.next=temp;
                currentNode=temp;
                temp=temp.next;
            }
        }
        
        if(temp==null){
            currentNode.next=null;
        }
    }
}
