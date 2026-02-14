/*
Valid Substring
Difficulty: MediumAccuracy: 23.37%Submissions: 139K+Points: 4
Given a string s consisting only of opening and closing parentheses '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Note: The length of the smallest valid substring "()" is 2.

Examples:

Input: s = "(()("
Output: 2
Explanation: The longest valid substring is "()". Its length is 2. 
Input: s = "()(())("
Output: 6
Explanation: The longest valid substring is "()(())". Its length is 6.
Input: s = "(()())"
Output: 6
Explanation: The longest valid substring is "(()())". Its length is 6.
Constraints:
1 ≤ s.size() ≤ 105
s[i] ∈ { '(' , ')' }
*/

//using loops - 
class Solution {
    public int maxLength(String s) {
        // code here
        int open=0,close=0,maxLen=0;
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(') open++;
            else close++;
            if(open==close){
                maxLen=Math.max(maxLen,open*2);
            }else if(close>open) {
                open=0;
                close=0; 
            }
        }
        
        open=0;
        close=0;
        
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='(') open++;
            else close++;
            if(open==close){
                maxLen=Math.max(maxLen,open*2);
            }else if(close<open) {
                open=0;
                close=0; 
            }
        }
        
        return maxLen;
    }
}


//using stack - 

class Solution {
    public int maxLength(String s) {
        // code here
        Stack<Integer>stack=new Stack<>();
        int maxLen=0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            
            if(c=='(') stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else maxLen=Math.max(maxLen,i-stack.peek());
            }
        }
        
        return maxLen;
    }
}
