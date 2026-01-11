/*
Postfix Evaluation
Difficulty: MediumAccuracy: 63.04%Submissions: 136K+Points: 4
You are given an array of strings arr[] that represents a valid arithmetic expression written in Reverse Polish Notation (Postfix Notation). Your task is to evaluate the expression and return an integer representing its value.

Note: A postfix expression is of the form operand1 operand2 operator (e.g., "a b +"). 
And the division operation between two integers always computes the floor value, i.e floor(5 / 3) = 1 and floor(-5 / 3) = -2.
It is guaranteed that the result of the expression and all intermediate calculations will fit in a 32-bit signed integer.

Examples:

Input: arr[] = ["2", "3", "1", "*", "+", "9", "-"]
Output: -4
Explanation: If the expression is converted into an infix expression, it will be 2 + (3 * 1) – 9 = 5 – 9 = -4.
Input: arr[] = ["2", "3", "^", "1", "+"]
Output: 9
Explanation: If the expression is converted into an infix expression, it will be 2 ^ 3 + 1 = 8 + 1 = 9.
Constraints:
3 ≤ arr.size() ≤ 103
arr[i] is either an operator: "+", "-", "*", "/" or "^", or an integer in the range [-104, 104]


*/

//code - 
class Solution {
    public int evaluatePostfix(String[] arr) {
        // code here
        Stack<Integer>stack=new Stack<>();
        
        for(int i=0;i<arr.length;i++){
            String ch=arr[i];
            int a=0,b=0;
            if(!isInteger(ch)){
                a=stack.pop();
                b=stack.pop();
                
                if(ch.equals("+")) stack.push(b+a);
                else if(ch.equals("-")) stack.push(b-a);
                else if(ch.equals("*")) stack.push(b*a);
                else if(ch.equals("/")){
                    int ans=b/a;
                    if ((b < 0) ^ (a < 0)) {       // one negative, one positive
                        if (b % a != 0) ans--;     // has remainder → floor more negative
                    }
                    stack.push(ans);
                }
                else if(ch.equals("^")) stack.push((int)Math.pow(b,a));
            }else stack.push(Integer.parseInt(ch));
        }
    
        return stack.peek();
    }
    
    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
