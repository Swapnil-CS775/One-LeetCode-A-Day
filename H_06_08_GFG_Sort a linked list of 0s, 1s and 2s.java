/*
Sort a linked list of 0s, 1s and 2s
Difficulty: MediumAccuracy: 60.75%Submissions: 261K+Points: 4Average Time: 30m
Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2

Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2

Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between.
Input: head = 2 → 2 → 0 → 1

Output: 0 → 1 → 2 → 2

Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be 0 → 1 → 2 → 2.
Constraints:
1 ≤ no. of nodes ≤ 106
0 ≤ node->data ≤ 2


*/

//code - 
/* class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
class Solution {
    static Node segregate(Node head) {
        // code here
        Node h1=new Node(-1);
        Node t1=h1;
        
        Node h2=new Node(-1);
        Node t2=h2;
        
        Node h3=new Node(-1);
        Node t3=h3;
        
        Node temp=head;
        
        while(temp!=null){
            if(temp.data==0){
                t1.next=temp;
                t1=t1.next;
                temp=temp.next;
                t1.next=null;
            }else if(temp.data==1){
                t2.next=temp;
                t2=t2.next;
                temp=temp.next;
                t2.next=null;
            }else{
                t3.next=temp;
                t3=t3.next;
                temp=temp.next;
                t3.next=null;
            }
        }
        
        // Now connect the three lists
        t1.next = h2.next != null ? h2.next : h3.next;
        t2.next = h3.next;
        
        return h1.next;
    }
}
