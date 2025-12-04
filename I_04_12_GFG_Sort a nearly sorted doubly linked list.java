/*
Sort a nearly sorted doubly linked list
Last Updated : 31 Aug, 2024
Given a doubly linked list containing n nodes, each node is at most k-indices away from its target position. The problem is to sort the given doubly linked list. The distance can be assumed in either of the directions (left and right).

Examples:

Input: Doubly Linked List : 3 <-> 2 <-> 1 <-> 5 <-> 6 <-> 4 , k = 2
Output: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6

Input: Doubly Linked List : 5 <-> 6 <-> 7 <-> 3 <-> 4 <-> 4 , k = 3
Output: 3 <-> 4 <-> 4 <-> 5 <-> 6 <-> 7

[Naive Approach] Using Insertion sort - O(n*k) time and O(1) space
The idea is to use insertion sort to sort the doubly linked list. While inserting each element in the sorted part of the list, there will be atmost k swaps to place the element to its correct position since every node is is atmost k steps away from its correct position.


*/

//insertion sort code -
public static Node sort(Node head){
        if(head==null || head.next==null) return head;

        Node current=head.next;
        while (current!=null){
            Node temp=current.prev;
            if(current.data>temp.data){
                current=current.next;
                continue;
            }else while (temp!=null && temp.data>current.data) temp=temp.prev;

            Node node=current;
            if(current.next==null){
                current.prev.next=null;
            }else {
                current = current.next;
                current.prev = node.prev;
                node.prev.next = current;
            }
            if(temp!=null){
                node.next=temp.next;
                temp.next.prev=node;
                temp.next=node;
                node.prev=temp;
            }else {
                node.prev=null;
                node.next=head;
                head.prev=node;
                head=node;
            }
        }
        return head;
    }
