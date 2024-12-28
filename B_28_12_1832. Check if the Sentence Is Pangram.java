/*
1832. Check if the Sentence Is Pangram
Solved
Easy
Topics
Companies
Hint
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

 

Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false
 

Constraints:

1 <= sentence.length <= 1000
sentence consists of lowercase English letters.
*/

//Code - 
class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] array=new int[26];
        int count=0;

        for(int i=0;i<sentence.length();i++)
        {
            if(array[sentence.charAt(i)-'a']==0)
            {
                array[sentence.charAt(i)-'a']=1;
                count++;
            }
            if(count==26)
            return true;
        }
    return false;
    }
}
