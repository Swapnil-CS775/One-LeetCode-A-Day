/*
Interleave the First Half of the Queue with Second Half
Difficulty: MediumAccuracy: 62.41%Submissions: 30K+Points: 4Average Time: 20m
Given a queue q[] of even size. Your task is to rearrange the queue by interleaving its first half with the second half.

Interleaving is the process of mixing two sequences by alternating their elements while preserving their relative order.
In other words, Interleaving means place the first element from the first half and then first element from the 2nd half and again second element from the first half and then second element from the 2nd half and so on....

Examples:

Input: q[] = [2, 4, 3, 1]
Output: [2, 3, 4, 1]
Explanation: We place the first element of the first half 2 and after that 
place the first element of second half 3 and after that repeat
the same process one more time so the resulting queue will be [2, 3, 4, 1]
Input: q[] = [3, 5]
Output: [3, 5]
Explanation: We place the first element of the first half 3 and first element
of the second half 5 so the resulting queue is [3, 5]
Constraints:
1 ≤ queue.size() ≤ 103
1 ≤ queue[i] ≤ 105


*/

//code 
//approach 1 using stack - 

class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        Stack<Integer>s1=new Stack<>();
        Stack<Integer>s2=new Stack<>();
        int size=q.size()/2;
        for(int i=0;i<size;i++) insertAtBottom(s1,q.remove());
        for(int i=0;i<size;i++) insertAtBottom(s2,q.remove());
        while(!s1.isEmpty()){
            q.add(s1.pop());
            q.add(s2.pop());
        }
       
    }
    
    public void insertAtBottom(Stack<Integer> s,int ele){
        if(s.size()==0){
            s.push(ele);
            return;
        }
        int top=s.pop();
        insertAtBottom(s,ele);
        s.push(top);
    }
}


//approach 2 using queue
class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        Queue<Integer>q1=new LinkedList<>();
        Queue<Integer>q2=new LinkedList<>();
        int size=q.size()/2;
        
        for(int i=0;i<size;i++)q1.add(q.remove());
        for(int i=0;i<size;i++)q2.add(q.remove());
        
        while(!q1.isEmpty()){
            q.add(q1.remove());
            q.add(q2.remove());
        }
    }
}
