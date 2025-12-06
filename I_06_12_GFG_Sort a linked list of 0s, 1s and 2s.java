/*
Sort a linked list of 0s, 1s and 2s
Difficulty: MediumAccuracy: 60.75%Submissions: 280K+Points: 4Average Time: 30m
Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
   
Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:
   
Input: head = 2 → 2 → 0 → 1
   
Output: 0 → 1 → 2 → 2
Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be:
   
Constraints:
1 ≤ no. of nodes ≤ 106
0 ≤ node->data ≤ 2


*/

//code - 
class Solution {
    public Node segregate(Node head) {
        // code here
        if(head==null) return head;
        int zero=0;
        int one=0;
        int two=0;

        Node temp=head;
        while(temp!=null){
            if(temp.data==0) zero++;
            else if(temp.data==1) one++;
            else two++;
            temp=temp.next;
        }
        
        temp=head;
        
        while(zero>0){
            temp.data=0;
            temp=temp.next;
            zero--;
        }
        while(one>0){
            temp.data=1;
            temp=temp.next;
            one--;
        }
        while(two>0){
            temp.data=2;
            temp=temp.next;
            two--;
        }
            
        
        return head;
    }
}


//any other apppraoch 

class Solution {
    public Node segregate(Node head) {
        // code here
        Node zero=new Node(-1);
        Node one=new Node(-1);
        Node two=new Node(-1);
        
        Node t0=zero;
        Node t1=one;
        Node t2=two;
        
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                t0.next=temp;
                t0=t0.next;
            }else if(temp.data==1){
                t1.next=temp;
                t1=t1.next;
            }else{
                t2.next=temp;
                t2=t2.next;
            }
            temp=temp.next;
        }
        
        t0.next=(one.next!=null)? one.next :two.next;
        t1.next=two.next;
        t2.next=null;
        
        return zero.next;
    }
}
