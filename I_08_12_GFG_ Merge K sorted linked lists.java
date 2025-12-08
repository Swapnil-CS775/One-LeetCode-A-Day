/*
Merge K sorted linked lists
Difficulty: MediumAccuracy: 57.01%Submissions: 122K+Points: 4Average Time: 60m
Given an array arr[] of n sorted linked lists of different sizes. Your task is to merge all these lists into a single sorted linked list and return the head of the merged list.

Examples:

Input:
   
Output: 1 -> 2 -> 3 -> 4 -> 7 -> 8 -> 9
Explanation: The arr[] has 3 sorted linked list of size 3, 3, 1.
1st list: 1 -> 3 -> 7
2nd list: 2 -> 4 -> 8
3rd list: 9
The merged list will be: 
    
Input:
   
Output: 1 -> 3 -> 4 -> 5 -> 6 -> 8
Explanation: The arr[] has 3 sorted linked list of size 2, 1, 3.
1st list: 1 -> 3
2nd list: 8
3rd list: 4 -> 5 -> 6
The merged list will be: 
    
Constraints
1 ≤ total no. of nodes ≤ 105
1 ≤ node->data ≤ 103
*/

//code - 
class Solution {
    Node mergeKLists(Node[] arr) {
        // code here
        if(arr.length==0) return null;
        
        Node dummyHead=new Node(-1);
        dummyHead.next=arr[0];
        for(int i=1;i<arr.length;i++){
            dummyHead.next=merge(dummyHead.next,arr[i]);
        }
        
        return dummyHead.next;
    }
    
    //merge two sorted list
    Node merge(Node h1,Node h2){
        Node l1=h1;
        Node l2=h2;
        Node dummy=new Node(-1);
        Node temp=dummy;
        if(l1.data<l2.data){
            temp.next=l1;
            l1=l1.next;
        }else{
            temp.next=l2;
            l2=l2.next;
        }
        temp=temp.next;
        
        while(l1!=null && l2!=null){
            if(l1.data<l2.data){
                temp.next=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        
        if(l1!=null) temp.next=l1;
        if(l2!=null) temp.next=l2;
        
        return dummy.next;
    }
}
