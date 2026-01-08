/*
Reverse Using Stack
Difficulty: EasyAccuracy: 76.17%Submissions: 112K+Points: 2
You are given a string s , the task is to reverse the string using stack.

Examples:

Input: s ="GeeksforGeeks"
Output:  skeeGrofskeeG
Input: s ="Geek"
Output: keeG
Constraints:
1 ≤ s.length() ≤ 100

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)
*/

//code 

class Solution {
    public String reverse(String S) {
        // code here
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<S.length();i++){
            stack.push(S.charAt(i));
        }
        
        StringBuilder ans=new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        
    return ans.toString();
    }
}
