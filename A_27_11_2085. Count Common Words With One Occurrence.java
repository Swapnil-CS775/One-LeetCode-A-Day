/*
2085. Count Common Words With One Occurrence
Solved
Easy
Topics
Companies
Hint
Given two string arrays words1 and words2, return the number of strings that appear exactly once in each of the two arrays.

 

Example 1:

Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
Output: 2
Explanation:
- "leetcode" appears exactly once in each of the two arrays. We count this string.
- "amazing" appears exactly once in each of the two arrays. We count this string.
- "is" appears in each of the two arrays, but there are 2 occurrences of it in words1. We do not count this string.
- "as" appears once in words1, but does not appear in words2. We do not count this string.
Thus, there are 2 strings that appear exactly once in each of the two arrays.
Example 2:

Input: words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
Output: 0
Explanation: There are no strings that appear in each of the two arrays.
Example 3:

Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
Output: 1
Explanation: The only string that appears exactly once in each of the two arrays is "ab".
 
*/

//Code

class Solution {
    public int countWords(String[] words1, String[] words2) {
        int count=0;

        HashMap<String,Integer>myMap1=new HashMap<>();
        HashMap<String,Integer>myMap2=new HashMap<>();

        for(String word:words1)
        {
            myMap1.put(word,myMap1.getOrDefault(word,0)+1);
        }
        for(String word:words2)
        {
            myMap2.put(word,myMap2.getOrDefault(word,0)+1);
        }

        for(String word:myMap1.keySet())
        {
            if(myMap1.get(word)==1 && myMap2.containsKey(word) && myMap2.get(word)==1)
            {
                count++;
            }
        }


    return count;
    }
}

