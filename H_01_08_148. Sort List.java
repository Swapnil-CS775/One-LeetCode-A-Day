/*
148. Sort List
Attempted
Medium
Topics
premium lock icon
Companies
Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?


*/

//code 
//this is one of the possible ans but it gives TLE for large input
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
    public ListNode sortList(ListNode head) {
        
        ListNode first=head;
        ListNode second=head;

        while(first!=null){
            second=head;
            while(second.next!=null){

                if(second.val>second.next.val){
                    int temp=second.val;
                    second.val=second.next.val;
                    second.next.val=temp;
                }
                second=second.next;
            }
            first=first.next;
        }
        return head;
    }
}



// 2nd approach 
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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode mid=mid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);

        return merge(left,right);
    }

    ListNode mid(ListNode head){
         ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect left half from right
        if (prev != null) prev.next = null;
        return slow;
    }

    ListNode merge(ListNode first,ListNode second){
        ListNode dummyHead=new ListNode();
        ListNode merged=dummyHead;

        while(first!=null && second!=null){
            if(first.val<second.val){
                merged.next=first;
                first=first.next;
            }else{
                merged.next=second;
                second=second.next;
            }
            merged=merged.next;
        }

        if(first!=null){
            merged.next=first;
        }
        if(second!=null){
            merged.next=second;
        }

    return dummyHead.next;
    }
}

