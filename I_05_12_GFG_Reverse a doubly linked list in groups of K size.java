/*
Reverse a doubly linked list in groups of K size
Last Updated : 07 Sep, 2024
Given a Doubly linked list containing n nodes. The task is to reverse every group of k nodes in the list. If the number of nodes is not a multiple of k then left-out nodes, in the end should be considered as a group and must be reversed.

Examples: 

Input: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> NULL, k = 2
Output: 2 <-> 1 <-> 4 <-> 3 <-> 6 <-> 5 <-> NULL. 
Explanation : Linked List is reversed in a group of size k = 2.

Reverse-a-doubly-linked-list-in-groups-of-K-size-2
 


Input: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> NULL, k = 4
Output: 4 <-> 3 <-> 2 <-> 1 <-> 6 -> 5 -> NULL. 
Explanation : Linked List is reversed in a group of size k = 4.
*/

//code - 
public static Node reverseKGroups(Node head,int k){

        Node temp=head;
        while (temp!=null){
            Node h=temp;
            Node p=h.prev;
            int i=k;
            while (i>1 && temp.next!=null){
                temp=temp.next;
                i--;
            }
            Node t=temp;
            temp=temp.next;
            t.next=null;

            Node reversedHead=reverseDLL(h);
            if(p==null)head=reversedHead;
            else {
                p.next=reversedHead;
                reversedHead.prev=p;
            }
            if(temp!=null){
                h.next=temp;
                temp.prev=h;
            }
        }
        return head;
    }

    public static Node reverseDLL(Node head){

        Node prev=null;
        Node current=head;
        Node next=null;

        while (current!=null){
            next=current;
            current=current.next;
            next.next=prev;
            next.prev=current;
            prev=next;
        }
        return prev;
    }
