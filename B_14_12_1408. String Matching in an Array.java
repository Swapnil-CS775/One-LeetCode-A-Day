/*
1408. String Matching in an Array
Easy
Topics
Companies
Hint
Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

A substring is a contiguous sequence of characters within a string

 

Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Example 2:

Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
Example 3:

Input: words = ["blue","green","bu"]
Output: []
Explanation: No string of words is substring of another string.
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] contains only lowercase English letters.
All the strings of words are unique.
*/

// code -

class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();

        // Compare each word with every other word
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Once found, no need to check further
                }
            }
        }

        // Convert the set to a list and return
        return new ArrayList<>(result);
    }
}

// OPtimal approch 
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        // Sort the words by length
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        // Check each word as a substring in the subsequent words
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // No need to check further once a match is found
                }
            }
        }

        return result;
    }
}

