/*
2496. Maximum Value of a String in an Array
Solved
Easy
Topics
Companies
Hint
The value of an alphanumeric string can be defined as:

The numeric representation of the string in base 10, if it comprises of digits only.
The length of the string, otherwise.
Given an array strs of alphanumeric strings, return the maximum value of any string in strs.

 

Example 1:

Input: strs = ["alic3","bob","3","4","00000"]
Output: 5
Explanation: 
- "alic3" consists of both letters and digits, so its value is its length, i.e. 5.
- "bob" consists only of letters, so its value is also its length, i.e. 3.
- "3" consists only of digits, so its value is its numeric equivalent, i.e. 3.
- "4" also consists only of digits, so its value is 4.
- "00000" consists only of digits, so its value is 0.
Hence, the maximum value is 5, of "alic3".
Example 2:

Input: strs = ["1","01","001","0001"]
Output: 1
Explanation: 
Each string in the array has value 1. Hence, we return 1.
 

Constraints:

1 <= strs.length <= 100
1 <= strs[i].length <= 9
strs[i] consists of only lowercase English letters and digits.
*/

// Code - 
class Solution {
    public int maximumValue(String[] strs) {
        int maxVal=0;
        int n=strs.length;

        for(int i=0;i<n;i++)
        {
            if(strs[i].matches("[0-9]+"))
            {
                maxVal=Math.max(maxVal,Integer.parseInt(strs[i]));
                
            }
            else
            {
                maxVal=Math.max(maxVal,strs[i].length());
            }

        }
    return maxVal;
    }
}

//ANother code - 
class Solution {
    public int maximumValue(String[] strs) {
        int maxVal = 0;  // Initialize the maximum value
        
        for (int i = 0; i < strs.length; i++) {
            boolean isNumeric = true;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) < '0' || strs[i].charAt(j) > '9') {  //will evaluate to true for any character that is not a digit (i.e., any character outside the range '0' (ASCII 48) to '9' (ASCII 57)).
                    isNumeric = false;
                    break;
                }
            }
            // Calculate the value based on whether the string is numeric
            int value = isNumeric ? Integer.parseInt(strs[i]) : strs[i].length();
            maxVal = Math.max(maxVal, value);  // Update the maxVal
        }
        
        return maxVal;
    }
}




