/*
143. Reorder List
Solved
Medium
Topics
premium lock icon
Companies
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
*/

//code - 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * Main function to reorder the list.
     */
    public void reorderList(ListNode head) {
        // Edge cases: No need to reorder if the list is empty or has 1 or 2 nodes.
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // Step 1: Find the end of the first half of the list.
        ListNode firstHalfTail = findMid(head);

        // Step 2: Get the head of the second half and split the list.
        ListNode secondHalfHead = firstHalfTail.next;
        firstHalfTail.next = null; // This completes the split.

        // Step 3: Reverse the second half of the list.
        secondHalfHead = reverseList(secondHalfHead);

        // Step 4: Merge the first half with the reversed second half.
        ListNode firstHalfHead = head;
        while (secondHalfHead != null) {
            // Temporarily store the next pointers.
            ListNode temp1 = firstHalfHead.next;
            ListNode temp2 = secondHalfHead.next;

            // Rewire the pointers for interleaving.
            firstHalfHead.next = secondHalfHead; // L0 -> Ln
            secondHalfHead.next = temp1;      // Ln -> L1

            // Move to the next pair of nodes to be merged.
            firstHalfHead = temp1;
            secondHalfHead = temp2;
        }
    }

    /**
     * Finds the tail node of the first half of the list using the slow/fast pointer method.
     * For [1,2,3,4], it returns node 2.
     * For [1,2,3,4,5], it returns node 3.
     */
    ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Reverses a linked list and returns the new head.
     * This is a corrected and more robust version of your revFromMid function.
     * @param head The head of the list portion to reverse.
     * @return The new head of the reversed list.
     */
    ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
