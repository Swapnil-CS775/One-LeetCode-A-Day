/*
1957. Delete Characters to Make Fancy String
Solved
Easy
Topics
Companies
Hint
A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.

 

Example 1:

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".
Example 2:

Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".
Example 3:

Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".
 

Constraints:

1 <= s.length <= 105
s consists only of lowercase English letters.
*/

//Code - 
class Solution {
    public String makeFancyString(String s) {
        if (s.length() < 3) return s;

        StringBuilder ans = new StringBuilder();
        int count = 1; // Count starts at 1 for the first character
        ans.append(s.charAt(0)); // Always append the first character

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++; // Increment count if the current char matches the previous one
            } else {
                count = 1; // Reset count if the current char is different
            }

            // Append the character only if count is <= 2
            if (count <= 2) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}
