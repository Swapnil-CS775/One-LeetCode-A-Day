/*
1684. Count the Number of Consistent Strings
Solved
Easy
Topics
Companies
Hint
You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

 

Example 1:

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
Example 2:

Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.
Example 3:

Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
 

Constraints:

1 <= words.length <= 104
1 <= allowed.length <= 26
1 <= words[i].length <= 10
The characters in allowed are distinct.
words[i] and allowed contain only lowercase English letters.
*/

//Approch 1 - 
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0; 
        for (String word : words) { 
            boolean isConsistent = true; 
            
            for (int j = 0; j < word.length(); j++) {
                if (!allowed.contains(String.valueOf(word.charAt(j)))) {
                    isConsistent = false; 
                    break; 
                }
            }
            if (isConsistent) {
                count++; 
            }
        }   
        return count; 
    }
}

//Approch - 2
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedSet = new boolean[26]; 
        
        for (char c : allowed.toCharArray()) {
            allowedSet[c - 'a'] = true;
        }
        
        int count = 0; 
        
        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                if (!allowedSet[c - 'a']) { 
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) count++;
        }
        
        return count;
    }
}
