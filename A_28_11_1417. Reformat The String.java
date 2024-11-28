/*
1417. Reformat The String
Solved
Easy
Topics
Companies
Hint
You are given an alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.

 

Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.
Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters and/or digits.
*/


//Code
class Solution {
    public String reformat(String s) {
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();

        // Separate letters and digits
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.append(c);
            } else if (Character.isDigit(c)) {
                digits.append(c);
            }
        }

        // Check if reformatting is possible
        if (Math.abs(letters.length() - digits.length()) > 1) {
            return "";
        }

        // Ensure the longer one comes first
        StringBuilder first = letters.length() >= digits.length() ? letters : digits;
        StringBuilder second = letters.length() < digits.length() ? letters : digits;

        StringBuilder result = new StringBuilder();

        // Merge the two lists alternately
        for (int i = 0; i < first.length() || i < second.length(); i++) {
            if (i < first.length()) {
                result.append(first.charAt(i));
            }
            if (i < second.length()) {
                result.append(second.charAt(i));
            }
        }

        return result.toString();
    }
}


// small change
class Solution {
    public String reformat(String s) {
        StringBuilder letters = new StringBuilder(); // store all letters in this
        StringBuilder digits = new StringBuilder();  //store all digits in this

        // Separate letters and digits
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.append(c);
            } else if (Character.isDigit(c)) {
                digits.append(c);
            }
        }

        // Check if reformatting is possible (a0b1c2)  letters=3 digits=3 so 3-3=0 possible ,
        //(a0b1c)  letters=3 digits=2 so 3-2=1 possible,
        //(a0bc)  letters=3 digits=1 so 3-1=2 Not possible, bcz absolute diff is 2 
        if (Math.abs(letters.length() - digits.length()) > 1) {
            return "";
        }

        boolean flag=letters.length()>=digits.length() ? true:false; //we have to deside for putting letter or digit at forst place whose size is large we put it at begining

        StringBuilder result = new StringBuilder(); // append ans here

        // Merge the two lists alternately
        int j=0,k=0; // two pointers to two strings letter and digit
        for (int i = 0; i < s.length(); i++) { // we have to iterate as length of string as we choose vlaid string bcz of it abs diff is < 1 means 1 or less than 1
            if (flag) {  //if true means letters is more
                result.append(letters.charAt(j++));
            }
            else {
                result.append(digits.charAt(k++));
            }
            flag=!flag; //every time flag will be toggled means once letter is appended than flag will be false and ext time digit will be appended 
        }

        return result.toString();  // return result in string format
    }
}


