/*
Segregate even and odd nodes in a Linked List
Difficulty: MediumAccuracy: 49.8%Submissions: 95K+Points: 4Average Time: 10m
Given a link list, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be the same as that in the original list.

NOTE: Don't create a new linked list, instead rearrange the provided one.

Examples:

Input: Linked list: 17->15->8->9->2->4->6
Output: 8->2->4->6->17->15->9

Explaination: 8,2,4,6 are the even numbers so they appear first and 17,15,9 are odd numbers that appear later.
Input: Linked List: 1 -> 3 -> 5 -> 7
Output: 1->3->5->7

Explaination: There is no even number. So no need for modification.
Constraints:
1 ≤ size of linked list ≤ 105
1 ≤ Each element of the list ≤ 105
*/


//code - 
// User function Template for Java

/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node divide(Node head) {
        // code here
        Node dummyEven=new Node(-1);
        Node tempEven=dummyEven;
        
        Node dummyOdd=new Node(-1);
        Node tempOdd=dummyOdd;
        
        Node temp=head;
        while(temp!=null){
            if(temp.data%2==0){
                tempEven.next=temp;
                temp=temp.next;
                tempEven=tempEven.next;
                tempEven.next=null;
            }else{
                tempOdd.next=temp;
                temp=temp.next;
                tempOdd=tempOdd.next;
                tempOdd.next=null;
            }
        }
        
        
        
        tempOdd.next=null;
        tempEven.next=dummyOdd.next;
        return dummyEven.next;
    }
}
