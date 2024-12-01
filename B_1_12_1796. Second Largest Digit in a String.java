/*
1796. Second Largest Digit in a String
Solved
Easy
Topics
Companies
Hint
Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.

An alphanumeric string is a string consisting of lowercase English letters and digits.

 

Example 1:

Input: s = "dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
Example 2:

Input: s = "abc1111"
Output: -1
Explanation: The digits that appear in s are [1]. There is no second largest digit. 
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters and digits.
*/

// code - 
class Solution {
    public int secondHighest(String s) {
        int firstMax = -1, secMax = -1;

        for (int i = 0; i < s.length(); i++) {  // iterate over each char
            char ch = s.charAt(i); // take this char into ch 
            if (Character.isDigit(ch)) { //check is it digit  Character.isDigit(ch)  this method check is that character is digit or not
                int digit = ch - '0';  // if yes than convert it into integer using  digit = ch - '0'  suppose ch='9' than '9' - '0' = (ascii value of integer is 48 to 57)
                                        // than '9' - '0' = 57 - 48 = 9 so we get digit as 9 real digit;
                
                if (digit > firstMax) { //check condition is digit greater than first digit 
                    secMax = firstMax; // if yes than assign first digit value to sec digit and first digit = digit
                    firstMax = digit; 
                } else if (digit > secMax && digit != firstMax) { // this condotion check if at first we get maximum digit in string than never above condition become true and we get aand -1 but may after that digit some digit may able to become sec max digit 
                                                                  // for ex = abc8245.....here sec max digit is 5 
                    secMax = digit; 
                }
            }
        }

        return secMax;  
    }
}
