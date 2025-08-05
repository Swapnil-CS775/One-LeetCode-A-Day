/*
Intersection Sorted Linked Lists
Difficulty: EasyAccuracy: 48.63%Submissions: 146K+Points: 2Average Time: 20m
Given that two linked lists are sorted in increasing order, create a new linked list representing the intersection of the two linked lists. The new linked list should be made without changing the original lists.

Note: The elements of the linked list are not necessarily distinct.

Examples:

Input: LinkedList1 = 1->2->3->4->6, LinkedList2 = 2->4->6->8
Output: 2->4->6
Explanation: For the given two linked list, 2, 4 and 6 are the elements in the intersection.

Input: LinkedList1 = 10->20->40->50, LinkedList2 = 15->40
Output: 40
Explaination:

Constraints:
1 <= size of linked lists <= 104
1 <= node->data<= 104


*/

//code - 
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    public static Node findIntersection(Node head1, Node head2) {
        // code here.
        Node dummnyHead=new Node(-1);
        Node temp=dummnyHead;
        
        Node t1=head1;
        Node t2=head2;
        while(t1!=null && t2!=null){
            if(t1.data==t2.data){
                temp.next=new Node(t1.data);
                temp=temp.next;
                
                while(t1.next!=null && t1.data==t1.next.data) t1=t1.next;
                t1=t1.next;
                while(t2.next!=null && t2.data==t2.next.data) t2=t2.next;
                t2=t2.next;
            }else{
                if(t1.data<t2.data) t1=t1.next;
                else t2=t2.next;
            }
        }
        
        temp.next=null;
        return dummnyHead.next;
    }
}
