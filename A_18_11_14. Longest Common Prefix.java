/*
14. Longest Common Prefix
Solved
Easy
Topics
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/

//code

class Solution {
    public String longestCommonPrefix(String[] strs) {

      
        //handle base case when array is empty or only one element with "" value than simply return ""
        if (strs == null || strs.length == 0) {
            return "";
        }
      
        //sort that array alphabeticaly
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;
        if (!first.equals("") && !last.equals("")) { //confurm that the selected words not ""
            while (i != first.length() && i != last.length()) {  //execute loop till any one word is not over
                if (first.charAt(i) == last.charAt(i)) {   //if i'th charactor is equal then only go to next charactor
                    i++; 
                } else { //if first charactor is not equal than break ; no need to compare further words
                    break;
                }
            }
        }

        if (i == 0) {
            return "";
        } else {
            return first.substring(0, i); 
        }
    }
}

