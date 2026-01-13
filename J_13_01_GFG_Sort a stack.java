/*
Sort a stack
Difficulty: MediumAccuracy: 69.19%Submissions: 167K+Points: 4Average Time: 20m
Given a stack of integers st[]. Sort the stack in ascending order (smallest element at the bottom and largest at the top).

Examples:

Input: st[] = [1, 2, 3]
Output: [3, 2, 1]
Explanation: The stack is already sorted in ascending order.

Input: st[] = [41, 3, 32, 2, 11]
Output: [41, 32, 11, 3, 2]
Explanation: After sorting, the smallest element (2) is at the bottom and the largest element (41) is at the top.

Constraints:
1 ≤ st.size() ≤ 103
0 ≤ stack element ≤ 103
*/


//code using recursion
class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        solve(st);
    }
    
    
    public void solve(Stack<Integer>stack){
        int ele=stack.pop();
        if(!stack.isEmpty()) solve(stack);
        insertAtRightPosition(stack,ele);
    }
    
    public void insertAtRightPosition(Stack<Integer>stack,int ele){
        if(stack.isEmpty()) stack.push(ele);
        else{
            if(ele<stack.peek()){
                int curr=stack.pop();
                insertAtRightPosition(stack,ele);
                stack.push(curr);
            }else{
                stack.push(ele);
            }
        }
    }
}
