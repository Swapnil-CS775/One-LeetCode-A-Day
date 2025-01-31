/*
884. Uncommon Words from Two Sentences
Solved
Easy
Topics
Companies
A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

 

Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"

Output: ["sweet","sour"]

Explanation:

The word "sweet" appears only in s1, while the word "sour" appears only in s2.

Example 2:

Input: s1 = "apple apple", s2 = "banana"

Output: ["banana"]

 

Constraints:

1 <= s1.length, s2.length <= 200
s1 and s2 consist of lowercase English letters and spaces.
s1 and s2 do not have leading or trailing spaces.
All the words in s1 and s2 are separated by a single space.

*/

// Code

// This question maks us silly we just have to return that element whose frequency is 1 
//(condition is return string nighter present in s1 more than once nor present in s2)

import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Use one map to count occurrences from both sentences
        HashMap<String, Integer> wordCount = new HashMap<>();

        // Split the sentences into words
        String[] words1 = s1.split("\\s+");
        String[] words2 = s2.split("\\s+");

        // Count word frequencies
        for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Find uncommon words
        List<String> result = new ArrayList<>();
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == 1) {
                result.add(word);
            }
        }

        // Convert list to array
        return result.toArray(new String[0]);
    }
}


