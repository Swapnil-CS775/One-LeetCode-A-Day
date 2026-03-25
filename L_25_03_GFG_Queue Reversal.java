/*
Queue Reversal
Difficulty: EasyAccuracy: 77.98%Submissions: 163K+Points: 2
Given a queue q containing integer elements, your task is to reverse the queue.

Examples:

Input: q[] = [5, 10, 15, 20, 25]
Output: [25, 20, 15, 10, 5]
Explanation: After reversing the given elements of the queue, the resultant queue will be 25 20 15 10 5.
Input: q[] = [1, 2, 3, 4, 5]
Output: [5, 4, 3, 2, 1]
Explanation: After reversing the given elements of the queue, the resultant queue will be 5 4 3 2 1.
Constraints:
1 ≤ q.size() ≤ 103
0 ≤ q[i] ≤ 105
*/

//code - using stack
class Solution {
    public void reverseQueue(Queue<Integer> q) {
        // code here
        //using stack
        Stack<Integer>stack=new Stack<>();
        while(!q.isEmpty()){
            stack.push(q.remove());
        }
        
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
    }
}


//using recursion
class Solution {
    public void reverseQueue(Queue<Integer> q) {
        // code here
        //using recursion
       if(q.size()==0) return;
       int ele=q.remove();
       reverseQueue(q);
       q.add(ele);
    }
}
