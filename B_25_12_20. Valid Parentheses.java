/*
20. Valid Parentheses
Solved
Easy
Topics
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

//Code - 
class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // Push opening brackets onto the stack
            if (current == '(' || current == '{' || current == '[') {
                stack[++top] = current;
            } else {
                // Check for stack underflow (no matching opening bracket)
                if (top == -1) {
                    return false;
                }

                // Check for matching pairs
                char last = stack[top];
                if ((current == ')' && last == '(') ||
                    (current == '}' && last == '{') ||
                    (current == ']' && last == '[')) {
                    top--; // Pop the stack
                } else {
                    return false; // Mismatched pair
                }
            }
        }

        // Return true if stack is empty (all brackets matched)
        return top == -1;
    }
}

//proper approach using stack 
private static boolean ans(String s){
        Stack<Character>stack=new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c=='{' || c=='[') stack.push(c);
            else {
                if(!stack.isEmpty() && (c==')' && stack.peek()=='(' ||
                        c=='}' && stack.peek()=='{' ||
                        c==']' && stack.peek()=='[')){
                    stack.pop();
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
