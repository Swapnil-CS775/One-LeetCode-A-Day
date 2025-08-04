/*
Find the first node of loop in linked list
Difficulty: EasyAccuracy: 55.49%Submissions: 86K+Points: 2
Given a head of the singly linked list. If a loop is present in the list then return the first node of the loop else return NULL.

Custom Input format:
A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.

Examples:

Input:
 
Output: 3
Explanation: We can see that there exists a loop in the given linked list and the first node of the loop is 3.
Input:
 
Output: -1
Explanation: No loop exists in the above linked list.So the output is -1.
Constraints:
1 <= no. of nodes <= 106
1 <= node->data <= 106 
*/

//code - first approch
class Solution {
    public static Node findFirstNode(Node head) {
        // code here
        HashSet<Node>set=new HashSet<>();
        
        Node temp=head;
        while(set.add(temp)){
            if(temp.next==null) return null;
            temp=temp.next;
        }
        
        return temp;
    }
}

// seocnd approch
/*
This idea is to use Floyd’s Cycle-Finding Algorithm to find a loop in a linked list. It uses two pointers slow and fast,
fast pointer move two steps ahead and slow will move one step ahead at a time.

After detecting that the loop is present using above algorithm, to find the starting node of loop in linked list, 
we will reset the slow pointer to head node and fast pointer will remain at its position.
Both slow and fast pointers move one step ahead until fast not equals to slow. The meeting point will be the Starting node of loop.
*/

//code - 
// User function Template for Java

/* class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
}*/

class Solution {
    public static Node findFirstNode(Node head) {
        // code here
        Node slow=head,fast=head;
        do{
            slow=slow.next;
            fast=fast.next.next;
            if(fast==null || fast.next==null) return new Node(-1);
        }while(slow!=fast);
        
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        
        return slow;
    }
}
