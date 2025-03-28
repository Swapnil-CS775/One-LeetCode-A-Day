/*
2053. Kth Distinct String in an Array
Solved
Easy
Topics
Companies
Hint
A distinct string is a string that is present only once in an array.

Given an array of strings arr, and an integer k, return the kth distinct string present in arr. If there are fewer than k distinct strings, return an empty string "".

Note that the strings are considered in the order in which they appear in the array.

 

Example 1:

Input: arr = ["d","b","c","b","c","a"], k = 2
Output: "a"
Explanation:
The only distinct strings in arr are "d" and "a".
"d" appears 1st, so it is the 1st distinct string.
"a" appears 2nd, so it is the 2nd distinct string.
Since k == 2, "a" is returned. 
Example 2:

Input: arr = ["aaa","aa","a"], k = 1
Output: "aaa"
Explanation:
All strings in arr are distinct, so the 1st string "aaa" is returned.
Example 3:

Input: arr = ["a","b","a"], k = 3
Output: ""
Explanation:
The only distinct string is "b". Since there are fewer than 3 distinct strings, we return an empty string "".
 

Constraints:

1 <= k <= arr.length <= 1000
1 <= arr[i].length <= 5
arr[i] consists of lowercase English letters.
 */

//Code - 
class Solution {
    public String kthDistinct(String[] arr, int k) {
        // Step 1: Count the frequency of each string
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : arr) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        // Step 2: Find the kth distinct string
        int count = 0;
        for (String str : arr) {
            if (frequencyMap.get(str) == 1) { // Distinct string
                count++;
                if (count == k) {
                    return str; // Return kth distinct string
                }
            }
        }

        // Step 3: If fewer than k distinct strings
        return "";
    }
}

