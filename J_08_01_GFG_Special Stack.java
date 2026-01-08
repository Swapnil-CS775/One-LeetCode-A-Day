/*
Special Stack
Difficulty: EasyAccuracy: 59.15%Submissions: 91K+Points: 2Average Time: 20m
Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return the minimum element from the SpecialStack. Your task is to complete all the functions, using a stack data structure.

Note: The output of the code will be the value returned by getMin() function.

Examples:

Input: stack: 18 19 29 15 16
Output: 15
Explanation: The minimum element of the stack is 15.
Input: stack: 34 335 1814 86
Output: 34
Explanation: The minimum element of the stack is 34.
Constraints:
1 ≤ ele ≤ 105
1 ≤ stack.size() ≤ 104


*/

//code - 
/*Complete the function(s) below*/
class GfG {
    public void push(int a, Stack<Integer> s) {
        // add code here.
        if(s.isEmpty()) s.push(a);
        else if(s.peek()>a) s.push(a);
        else{
            Stack<Integer>stack=new Stack<>();
            while(!s.isEmpty() && s.peek()<a) stack.push(s.pop());
            s.push(a);
            while(!stack.isEmpty()) s.push(stack.pop());
        }
    }

    public int pop(Stack<Integer> s) {
        // add code here.
        return s.pop();
    }

    public int min(Stack<Integer> s) {
        // add code here.
        return s.peek();
    }

    public boolean isFull(Stack<Integer> s, int n) {
        // add code here.
        return s.size()==n;
    }

    public boolean isEmpty(Stack<Integer> s) {
        // add code here.
        return s.isEmpty();
    }
}
