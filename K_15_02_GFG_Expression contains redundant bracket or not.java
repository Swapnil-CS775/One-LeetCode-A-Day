/*
Expression contains redundant bracket or not
Difficulty: MediumAccuracy: 48.71%Submissions: 46K+Points: 4
Given a string of balanced expression s, check if it contains a redundant parenthesis or not. A set of parenthesis are redundant if the same sub-expression is surrounded by unnecessary or multiple brackets.
Note: Expression may contain + , - , *, and / operators. Given expression is valid and there are no white spaces present.

Examples:

Input: s = "((a+b))"
Output: true 
Explanation: ((a+b)) can reduced to (a+b).
Input: s = "(a+(b)/c)"
Output: true
Explanation: (a+(b)/c) can reduced to (a+b/c) because b is surrounded by () which is redundant.
Input: s = "(a+b+(c+d))"
Output: false
Explanation:(a+b+(c+d)) doesn't have any redundant or multiple brackets.
Constraints:
1 ≤ |s| ≤105


*/

//code - 
class Solution {
    public static boolean checkRedundancy(String s) {
        // code here
        Stack<Character>stack=new Stack<>();
        
        for(char ch:s.toCharArray()){
            if(ch=='(' || (ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || ch=='+' ||
            ch=='-' || ch=='*' || ch=='/') {
                stack.push(ch);
            }else{
                int op=0;
                while(!stack.isEmpty() && stack.peek()!='('){
                    char c=stack.pop();
                    if(c=='+' || c=='-' || c=='*' || c=='/') op++;
                }
                if(!stack.isEmpty())stack.pop();
                if(op==0) return true;
            }
        }
        
        return false;
    }
}
