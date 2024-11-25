/*
2185. Counting Words With a Given Prefix
Solved
Easy
Topics
Companies
Hint
You are given an array of strings words and a string pref.

Return the number of strings in words that contain pref as a prefix.

A prefix of a string s is any leading contiguous substring of s.

 

Example 1:

Input: words = ["pay","attention","practice","attend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
Example 2:

Input: words = ["leetcode","win","loops","success"], pref = "code"
Output: 0
Explanation: There are no strings that contain "code" as a prefix.
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length, pref.length <= 100
words[i] and pref consist of lowercase English letters.
*/

// Code Bruitforce approch - 
class Solution {
    public int prefixCount(String[] words, String pref) {
        
        int n=pref.length();
        int count=0;
        int j;

        for(int i=0;i<words.length;i++)
        {
            for(j=0;j<n;j++)
            {
                if(words[i].length()>=n && words[i].charAt(j)==pref.charAt(j)) // here we also have to check the words size should be greater than of equal to prefex
                {
                    continue;
                }
                else
                {
                    break;
                }
            }
            if(j==n)
            {
                count++;
            }
        }
    return count;
    }
}


//Optimal approch 
class Solution {
    public int prefixCount(String[] words, String pref) {
        
        int n=pref.length();
        int count=0;
        int j;

        for(String word:words)
        {
            if(word.length()>=n && word.startsWith(pref)) // Simple startsWith method in java pass pref in it ,it will count words startWith that pref
            {
                count++;
            }
        }
    return count;
    }
}
