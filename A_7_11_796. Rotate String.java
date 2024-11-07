/*
796. Rotate String
Solved
Easy
Topics
Companies
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.

*/

// Code
class Solution {
    public boolean rotateString(String s, String goal) {
        boolean ans=true;
        int i=0;
        if(s.length()!=goal.length())
        {
            return false;
        }
        StringBuilder str=new StringBuilder(s);
        while(i<s.length())
        {
            if(str.toString().equals(goal))
            {
                ans=true;
                break;
            }
            else
            {
                char x=str.charAt(0);
                str.deleteCharAt(0);
                str.append(x);
                i++;
            }
        }
        if(i==s.length())
        {
            ans=false;
        }
    return ans;
    }
}
