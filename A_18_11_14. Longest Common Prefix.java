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


//Optimal aproch
class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null) { // handle edge case if array is null then simply return no comman prefix
            return "";
        }
        
        String prefix = strs[0];  //consider first string is in array is a longest prefix- and reduce it as conparing by next element
        
        for (int i = 1; i < strs.length; i++) {
            
            while (strs[i].indexOf(prefix) != 0) { //it means flower is not present in flow so reduce flower by 1 which make flowe 
                                                   //again flowe is not present in flow so reduce flowe by 1 which make flow
                                                   //now flow is present in flow so go to next string
                                                   //flow is not present in flight so reduce flow by 1 which make flo
                                                   //flo id not present in flight so reduce flo by 1 which make fl
                                                   //fl is present in flight and array is also traversed out of loop and retun prefix="fl"
                prefix = prefix.substring(0, prefix.length() - 1);
                                                   //here start index is inclusive and end index is exclusive
                                                  
                if (prefix.isEmpty()) { //this line triggers when on specific word we dont get any common prefix and by making
                                        //substring the word get exosted
                    return "";
                }
            }
        }
        return prefix;
    }
}

