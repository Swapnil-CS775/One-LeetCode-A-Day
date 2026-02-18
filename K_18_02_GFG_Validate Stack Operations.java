/*
Validate Stack Operations
Difficulty: MediumAccuracy: 70.5%Submissions: 29K+Points: 4Average Time: 10m
You have an empty stack and can perform push and pop operations in it. 
You are given two arrays a[] and b[] of unique elements and both having the same length.

a[] represents the order in which elements are pushed into a stack.

b[] represents the order in which elements are expected to be popped from the stack.


Determine whether the given push and pop sequences are valid.

Note: The stack is empty initially and must also be empty after performing all the operations.

Examples:

Input: a[] = [1, 2, 3], b[] = [2, 1, 3]
Output: true
Explanation:
Take 1 from a and push it into the stack,
Take 2 from a and push it into the stack,
Take 2 from b and pop it from the stack,
Take 1 from b and pop it from the stack,
Take 3 from a and push it into the stack,
Take 3 from b and pop it from the stack
So, all the push and pop sequences are valid.
Input: a[] = [1, 2, 3], b[] = [3, 1, 2]
Output: false
Explanation: After pushing 1, 2, and 3, we can pop 3 as required. But the next element in b[] is 1, while the stack top is 2. Since 1 is blocked under 2, this order cannot be achieved.
Constraints:
1 ≤ a.size()=b.size() ≤ 105
0 ≤ a[i], b[i] ≤ 2*105

Expected Complexities
*/

//code - expected using stack 
class Solution {
    public boolean validateOp(int[] a, int[] b) {
        // code here
        Stack<Integer>stack=new Stack<>();
        int i=0,j=0;
        while(i<a.length){
            while(!stack.isEmpty() && j<b.length && stack.peek()==b[j]){
                stack.pop();
                j++;
            }
            stack.push(a[i]);
            i++;
        }
        while(!stack.isEmpty() && j<b.length && stack.peek()==b[j]){
                stack.pop();
                j++;
        }
        
        
    return stack.isEmpty();
    }
}

//lets do using queue
