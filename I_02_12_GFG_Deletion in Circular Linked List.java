/*
You are given a Circular Linked List and an integer key representing a node. Delete the first occurrence of given key node in circular linked list and return the head of the modified linked list.
Note:

You don't have to print anything, just return the head of the modified list in each function.
Nodes are unique.
The key may or may not be present.
Examples:

Input: key = 8,
    
Output: 1 -> 7 -> 10
Explanation: After deleting 8 from the given circular linked list, it has elements as 1, 7, 10.
    
Input: key = 8,
    
Output: 2 -> 5 -> 7 -> 10
Explanation: After deleting 8 from the given circular linked list, it has elements as 2, 5, 7, 10.
    
Constraints:
1 ≤ number of nodes ≤ 105
0 ≤ node -> data, key ≤ 105


*/

//code - 
class Solution {
    Node deleteNode(Node head, int key) {
        // code here
        if(key==head.data){
            Node temp=head;
            do{
                temp=temp.next;
            }while(temp.next!=head);
            head=head.next;
            temp.next=head;
            return head;
        }else{
            Node temp=head;
            Node prev=null;
            do{
                prev=temp;
                temp=temp.next;
                if(temp.data==key)break;
            }while(temp.data!=key && temp!=head);
            if(temp!=head) prev.next=prev.next.next;
        }
        return head;
    }
}
