/*
1592. Rearrange Spaces Between Words
Solved
Easy
Topics
Companies
Hint
You are given a string text of words that are placed among some number of spaces. Each word consists of one or more lowercase English letters and are separated by at least one space. It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized. If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.

Return the string after rearranging the spaces.

 

Example 1:

Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
Example 2:

Input: text = " practice   makes   perfect"
Output: "practice   makes   perfect "
Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. We place this extra space at the end of the string.
 

Constraints:

1 <= text.length <= 100
text consists of lowercase English letters and ' '.
text contains at least one word.
*/

//Code- 
class Solution {
    public String reorderSpaces(String text) {
        // Step 1: Count total spaces
        int spaceCount = 0;  //initialize space count to 0
        for (char ch : text.toCharArray()) { //here string is converted into charArray using toCharArray method
            if (ch == ' ') { //when char == ' ' than we increase count by 1
                spaceCount++;
            }
        }

        // Step 2: Extract words
        String[] words = text.trim().split("\\s+");  //first convert that string into words and then trim heading and treling spaces
        int wordCount = words.length;

        // Step 3: Calculate spaces
        int equalSpaces = wordCount > 1 ? spaceCount / (wordCount - 1) : 0; //if string contain more than 1 words then count ......else set to 0
        int extraSpaces = wordCount > 1 ? spaceCount % (wordCount - 1) : spaceCount; // calculate any remeaning extra space at end require or not if remainder is 0 than not require and if its length is = 1 than all spacesCount will be appended at end

        // Step 4: Build result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);
            if (i < words.length - 1) { // Add equal spaces between words
                result.append(" ".repeat(equalSpaces));
            }
        }

        // Add remaining spaces to the end
        result.append(" ".repeat(extraSpaces));

        return result.toString();
    }
}


