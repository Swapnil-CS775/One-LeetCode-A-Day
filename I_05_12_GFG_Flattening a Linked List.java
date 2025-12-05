/*
Flattening a Linked List
Difficulty: MediumAccuracy: 51.53%Submissions: 199K+Points: 4Average Time: 40m
Given a linked list containing n head nodes where every node in the linked list contains two pointers:
(i) next points to the next node in the list.
(ii) bottom points to a sub-linked list where the current node is the head.
Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data. Flatten the linked list such that all the nodes appear in a single level while maintaining the sorted order.

Note:
1. ↓ represents the bottom pointer and → represents the next pointer.
2. The flattened list will be printed using the bottom pointer instead of the next pointer.

Examples:

Input:

Output: 5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 40 -> 45.
Explanation: 
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 10 is pointing to 20 and so on.
So, after flattening the linked list the sorted list will be 
5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 40 -> 45.
Input:

Output: 5 -> 7 -> 8 -> 10 -> 19 -> 22 -> 28 -> 30 -> 50
Explanation:
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 8 is pointing to 30 and so on.
So, after flattening the linked list the sorted list will be 
5 -> 7 -> 8 -> 10 -> 19 -> 22 -> 28 -> 30 -> 50.
Constraints:
0 ≤ n ≤ 100
1 ≤ number of nodes in sub-linked list(mi) ≤ 50
1 ≤ node->data ≤ 104

*/

//code 
/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node root) {
        while(root.next!=null){
            root=merge(root,root.next);
        }
        return root;
    }
    
    public Node merge(Node l1,Node l2){
        Node p1=l1;
        Node p2=l2;
        Node next=l2.next;
        Node dummy=new Node(-1);
        
        Node temp=dummy;
        dummy.bottom=p1;
        p1=p1.bottom;
        temp=temp.bottom;
        while(p1!=null && p2!=null){
            if(p1.data<p2.data){
                temp.bottom=p1;
                p1=p1.bottom;
            }else{
                temp.bottom=p2;
                p2=p2.bottom;
            }
            temp=temp.bottom;
        }
        
        if(p1!=null && temp!=null)temp.bottom=p1;
        if(p2!=null && temp!=null)temp.bottom=p2;
        
        dummy.bottom.next=next;
        return dummy.bottom;
    }
}
