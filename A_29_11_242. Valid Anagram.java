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
