/*
Intersection in Y Shaped Lists
Difficulty: MediumAccuracy: 44.67%Submissions: 305K+Points: 4Average Time: 45m
You are given the heads of two non-empty singly linked lists, head1 and head2, that intersect at a certain point. return that Node where these two linked lists intersect.

Note: It is guaranteed that the intersected node always exists.

Examples:

Input: head1 : 4 -> 4 -> 4 -> 4 -> 4, head2 : 4 -> 4 -> 4
 
Output: 4
Explanation: From the above image, it is clearly seen that the common part is 4 -> 4 whose starting point is 4.
Input: head1 : 4 -> 1 -> 8 -> 4 -> 5, head2 : 5 -> 6 -> 1 -> 8 -> 4 -> 5
 
Output: 8
Explanation: From the above image, it is clearly seen that the common part is 8 -> 4 -> 5 whose starting point is 8.
Constraints:
2 ≤ total number of nodes ≤ 2*105
-104 ≤ node->data ≤ 104


*/

//code  - 
//first approch
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        HashSet<Node>set=new HashSet<>();
        
        Node t1=head1;
        Node t2=head2;
        
        while(t1!=null || t2!=null){
            if(t1!=null){
                if(!set.add(t1)){
                    return t1;
                }
                t1=t1.next;
            }
            if(t2!=null){
                if(t2!=null){
                if(!set.add(t2)){
                    return t2;
                }
            t2=t2.next;
            }
            }
        }
    return null;
    }
}

//approch 2

/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        Node t1=head1;
        Node t2=head2;
        
        while(t1.next!=null || t2.next!=null){
            if(t1.next==null){
                t1=head2;
            }
            if(t2.next==null){
                t2=head1;
            }
            t1=t1.next;
            t2=t2.next;
            if(t1==t2){
                return t1;
            }
        }
        
    return null;
    }
}

/*

✅ Optimal Approach: Two Pointers
Idea:
Use two pointers a and b, one for each list. When either pointer reaches the end of its list, redirect it to the head of the other list. Eventually, both pointers will meet at the intersection node.

💡 Why it Works:
Let:

lenA = length of list A before the intersection

lenB = length of list B before the intersection

lenCommon = length of the common tail (intersection)

When the two pointers traverse:

Pointer A travels: lenA + lenCommon + lenB

Pointer B travels: lenB + lenCommon + lenA

So they meet at the intersection node after at most lenA + lenB steps.
*/
