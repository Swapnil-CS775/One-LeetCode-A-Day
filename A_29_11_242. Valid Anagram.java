/*
242. Valid Anagram
Solved
Easy
Topics
Companies
Given two strings s and t, return true if t is an 
anagram
 of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
*/


//Code - 
import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26]; /

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}

// another small change

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26]; 

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            charCount[t.charAt(j) - 'a']--;
            if(charCount[t.charAt(j) - 'a']<0)
            {
                return false;
            }
        }
    return true;
    }
}



/*
// Time Complexity Analysis:

// 1. Length Check:
// The operation `s.length() != t.length()` is a constant-time operation.
// Time Complexity: O(1)

// 2. First Loop:
// The loop `for (int i = 0; i < s.length(); i++)` iterates through all characters in string `s`.
// Each iteration increments the count for the character in the `charCount` array.
// Time Complexity: O(n), where `n` is the length of string `s`.

// 3. Second Loop:
// The loop `for (int j = 0; j < t.length(); j++)` iterates through all characters in string `t`.
// Each iteration decrements the count and checks for negative counts in the `charCount` array.
// Time Complexity: O(n), where `n` is the length of string `t`.

// 4. Total Time Complexity:
// The two loops run sequentially, so the total time complexity is:
// O(n) + O(n) = O(2n).
// Dropping the constant factor, the final time complexity is: O(n).

// Space Complexity Analysis:

// 1. Fixed-Size Array:
// The `charCount` array is of fixed size (26) to store counts for each lowercase English letter.
// Space Complexity: O(1)

// 2. No Other Space Usage:
// There is no additional space used proportional to the input size.

// Final Space Complexity: O(1)

*/

// using hash MAp
import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer>myMap=new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            myMap.put(s.charAt(i),myMap.getOrDefault(s.charAt(i),0)+1);
            myMap.put(t.charAt(i),myMap.getOrDefault(t.charAt(i),0)-1);
        }

        for (int j : myMap.values()) {
            if (j != 0) {
                return false;
            }
        }

        return true;
    }
}
