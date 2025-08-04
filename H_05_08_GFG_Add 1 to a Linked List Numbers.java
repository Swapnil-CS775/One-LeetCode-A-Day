/*
Add 1 to a Linked List Number
Difficulty: MediumAccuracy: 31.91%Submissions: 328K+Points: 4Average Time: 20m
You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

Note: The head represents the first element of the given array.

Examples :

Input: LinkedList: 4->5->6
Output: 457

Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 
Input: LinkedList: 1->2->3
Output: 124
 
Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124. 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= len(list) <= 105
0 <= list[i] <= 9


*/

//code - 
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
    public Node addOne(Node head) {
        // code here.
        //if list contain only one node and its value is 9 then simply return 1->0;
        if(head.data==9 && head.next==null){
            Node ans=new Node(1);
            head.data=0;
            ans.next=head;
            head=ans;
            return head;
        }

        //if list contain single node and its value is less than 8 then simply return sum;
        if(head.next==null){
            head.data=head.data+1;
            return head;
        }

       //first reverse compleate list to add carry
        Node tempHead=reverse(head);
        if((tempHead.data+1)<=9){
            tempHead.data=tempHead.data+1;
            return reverse(tempHead);
         //simply return form here is last node is less than equal to 8;
        }else{
            //here logic start if last node is = 9
            tempHead.data=0;
            Node temp=tempHead.next;
            
            while(temp!=null){
                if((temp.data+1)<=9){
                   temp.data=temp.data+1;
                   break;
                }else{
                    temp.data=0;
                    if(temp.next==null){
                        Node finalNode=new Node(1);
                        temp.next=finalNode;
                        break;
                    }
                    temp=temp.next;
                }
            }
            return reverse(tempHead);
        }
    }
    
    public Node reverse(Node head){
        Node prev=null;
        Node current=head;
        
        while(current!=null){
            Node nextNode=current.next;
            current.next=prev;
            prev=current;
            current=nextNode;
        }
    return prev;
    }
}
