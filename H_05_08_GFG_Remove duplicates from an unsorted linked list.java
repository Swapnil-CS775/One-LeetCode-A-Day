/*
Remove duplicates from an unsorted linked list
Difficulty: EasyAccuracy: 45.95%Submissions: 251K+Points: 2Average Time: 20m
Given an unsorted linked list. The task is to remove duplicate elements from this unsorted Linked List. When a value appears in multiple nodes, the node which appeared first should be kept, all other duplicates are to be removed.

Examples:

Input: LinkedList: 5->2->2->4
Output: 5->2->4
Explanation: Given linked list elements are 5->2->2->4, in which 2 is repeated only. So, we will delete the extra repeated elements 2 from the linked list and the resultant linked list will contain 5->2->4
 
Input: LinkedList: 2->2->2->2->2
Output: 2
Explanation:Given linked list elements are 2->2->2->2->2, in which 2 is repeated. So, we will delete the extra repeated elements 2 from the linked list and the resultant linked list will contain only 2.
Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraints:
1 <= number of nodes <= 106
0 <= node->data <= 106


*/

//code - 
/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    // Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) {
        // Your code here
        HashSet<Integer>set=new HashSet<>();
        
        Node temp=head;
        Node dummyHead=new Node(-1);
        Node ans=dummyHead;
        while(temp!=null){
            if(set.add(temp.data)){
                ans.next=temp;
                ans=ans.next;
            }else {
                // Disconnect to avoid accidental chain
                ans.next = null;
            }
        temp=temp.next;
        }
    return dummyHead.next;
    }
}
