/*
Reverse a Stack
Difficulty: MediumAccuracy: 80.5%Submissions: 124K+Points: 4Average Time: 20m
You are given a stack st[]. You have to reverse the stack.

Examples:

Input: st[] = [1, 2, 3, 4]
Output: [1, 2, 3, 4]
Explanation: After reversing, the elements of stack are in opposite order.

Input: st[] = [3, 2, 1]
Output: [3, 2, 1]
Explanation: After reversing, the elements of stack are in opposite order.

Constraints:
1 ≤ st.size() ≤ 100
0 ≤ stack element ≤ 100


*/

//bruteforce appraoch = 
class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        int[] arr=new int[st.size()];
        
        for(int i=0;i<arr.length;i++){
            arr[i]=st.pop();
        }
        
        for(int i=0;i<arr.length;i++){
            st.push(arr[i]);
        }
        
    }
}


//second optimal without using stack but using recursion
class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        solve(st);
    }
    
    public static void solve(Stack<Integer>stack){
        int ele=stack.pop();
        if(!stack.isEmpty()) solve(stack);
        insAtEnd(stack,ele);
    }
    
    public static void insAtEnd(Stack<Integer>stack,int data){
        if (stack.isEmpty()){
            stack.push(data);
        }else{
            int currVal=stack.pop();
            insAtEnd(stack,data);
            stack.push(currVal);
        }
    }
}
