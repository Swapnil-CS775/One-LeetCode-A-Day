/*
521. Longest Uncommon Subsequence I
Solved
Easy
Topics
Companies
Hint
Given two strings a and b, return the length of the longest uncommon subsequence between a and b. If no such uncommon subsequence exists, return -1.

An uncommon subsequence between two strings is a string that is a 
subsequence
 of exactly one of them.

 

Example 1:

Input: a = "aba", b = "cdc"
Output: 3
Explanation: One longest uncommon subsequence is "aba" because "aba" is a subsequence of "aba" but not "cdc".
Note that "cdc" is also a longest uncommon subsequence.
Example 2:

Input: a = "aaa", b = "bbb"
Output: 3
Explanation: The longest uncommon subsequences are "aaa" and "bbb".
Example 3:

Input: a = "aaa", b = "aaa"
Output: -1
Explanation: Every subsequence of string a is also a subsequence of string b. Similarly, every subsequence of string b is also a subsequence of string a. So the answer would be -1.
 

Constraints:

1 <= a.length, b.length <= 100
a and b consist of lower-case English letters.
*/

//Code - 
class Solution {
    public int findLUSlength(String a, String b) {
        int length=-1;
        String first;
        String second;
        if(a.length()>=b.length()){
            first=a;
            second=b;
        }
        else{
            first=b;
            second=a;
        }

        int i=0,j=0;
        while(i<first.length() && j<second.length())
        {
            if(first.charAt(i)==second.charAt(j))
            {
                i++;
            }
            j++;
        }
        if(i!=first.length())
            length=first.length();

    return length;
    }
}


//Another Approch - 
class Solution {
    public int findLUSlength(String a, String b) {
        // If the strings are equal, no uncommon subsequence exists
        if (a.equals(b)) {
            return -1;
        }
        // Otherwise, the longer string itself is the LUS
        return Math.max(a.length(), b.length());
    }
}