/*
2108. Find First Palindromic String in the Array
Solved
Easy
Topics
Companies
Hint
Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".

A string is palindromic if it reads the same forward and backward.

 

Example 1:

Input: words = ["abc","car","ada","racecar","cool"]
Output: "ada"
Explanation: The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.
Example 2:

Input: words = ["notapalindrome","racecar"]
Output: "racecar"
Explanation: The first and only string that is palindromic is "racecar".
Example 3:

Input: words = ["def","ghi"]
Output: ""
Explanation: There are no palindromic strings, so the empty string is returned.
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists only of lowercase English letters.
*/

//First apporch - 
class Solution {
    public String firstPalindrome(String[] words) {

        for (int i = 0; i < words.length; i++) {
            int n = words[i].length();
            if (n == 1)
                return words[i];
            int j = 0, k = n - 1;
            while (j <= k) {
                if (words[i].charAt(j) == words[i].charAt(k)) {
                    j++;
                    k--;
                    continue;
                }
                break;
            }
            if (j > k || j == k)
                return words[i];
        }
        return "";
    }
}


//second approch
class Solution {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) { //this prevent usage of extra space when char at first and last are not equal simply return false
                return false;
            }
            left++;
            right--;
        }
        return true; //if control come here that means string is palindrome;
    }
}
