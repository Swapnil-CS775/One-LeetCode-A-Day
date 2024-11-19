/*
1392. Longest Happy Prefix
Solved
Hard
Topics
Companies
Hint
A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.

 

Example 1:

Input: s = "level"
Output: "l"
Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".
Example 2:

Input: s = "ababab"
Output: "abab"
Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.
 

Constraints:

1 <= s.length <= 105
s contains only lowercase English letters.
*/

// Code - Optimized approch using KMP algo to find longest prefix and suffix
class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int len = 0; // Length of the current matching prefix
        int i = 1; // Start from the second character

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                // Characters match, extend the prefix
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // Backtrack to the previous possible prefix length
                    len = lps[len - 1];
                } else {
                    // No prefix match
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Return the longest happy prefix
        return s.substring(0, lps[n - 1]);
    }
}
