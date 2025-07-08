/*
21. Merge Two Sorted Lists
Solved
Easy
Topics
premium lock icon
Companies
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
*/

//first approach - 
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    
        ListNode newHead=null;
        ListNode temp=null;

        if(list1==null){
            newHead=list2;
            return newHead;
        }
        if(list2==null){
            newHead=list1;
            return newHead;
        }

        while(list1!=null && list2 != null){
            if(list1.val<=list2.val){
                if(newHead==null){
                    newHead=list1;
                    temp=newHead;
                    list1=list1.next;
                    continue;
                }
                temp.next=list1;
                temp=temp.next;
                list1=list1.next;

                
            }else{
                if(newHead==null){
                    newHead=list2;
                    temp=newHead;
                    list2=list2.next;
                    continue;
                }
                temp.next=list2;
                temp=temp.next;
                list2=list2.next;
            }
        }

        if(list1!=null && temp!=null){
            temp.next=list1;
        }
        if(list2!=null && temp!=null){
            temp.next=list2;
        }


        return newHead;
    }
}


//more clear approach 
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    
        ListNode dummy=new ListNode(-1);
        ListNode current=dummy;

        while(list1!=null && list2 != null){
            if(list1.val<=list2.val){
                current.next=list1;
                list1=list1.next;
                
            }else{
                current.next=list2;
                list2=list2.next;
            }
            current=current.next;
        }

        if(list1!=null){
            current.next=list1;
        }
        else if(list2!=null){
            current.next=list2;
        }


        return dummy.next;
    }
}
