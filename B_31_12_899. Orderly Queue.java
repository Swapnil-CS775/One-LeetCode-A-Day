/*
899. Orderly Queue
Hard
Topics
Companies
You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string.

Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.

 

Example 1:

Input: s = "cba", k = 1
Output: "acb"
Explanation: 
In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".
Example 2:

Input: s = "baaca", k = 3
Output: "aaabc"
Explanation: 
In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".
 

Constraints:

1 <= k <= s.length <= 1000
s consist of lowercase English letters.
*/

//Code - 
import java.util.Arrays;

class Solution {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            // If k > 1, we can completely reorder the string, so sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        } else {
            // If k == 1, find the smallest rotation
            String smallest = s;
            String rotated = s;
            for (int i = 0; i < s.length(); i++) {
                // Rotate the string by moving the first character to the end
                rotated = rotated.substring(1) + rotated.charAt(0);
                // Update the smallest string if the new rotation is smaller
                if (rotated.compareTo(smallest) < 0) {
                    smallest = rotated;
                }
            }
            return smallest;
        }
    }
}

// 2-
import java.util.Arrays;

class Solution {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            // Sort the string when k > 1
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        } else {
            // Find the smallest rotation when k == 1
            String smallest = s;
            String doubled = s + s; // Concatenate s with itself to handle rotations
            for (int i = 1; i < s.length(); i++) {
                String rotation = doubled.substring(i, i + s.length());
                if (rotation.compareTo(smallest) < 0) {
                    smallest = rotation;
                }
            }
            return smallest;
        }
    }
}
