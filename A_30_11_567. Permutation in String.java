/*
567. Permutation in String
Solved
Medium
Topics
Companies
Hint
Given two strings s1 and s2, return true if s2 contains a 
permutation
 of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
*/

//Another question using sliding window 


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length(); // length of smaller string
        int n=s2.length(); // lenght of larger string
        if(m>n)return false; // if s1 is grater than s2 than no way to present s1 in s2  so return false

        int[] s1Count=new int[26]; // constatent storage to count freq of both the array
        int[] s2Count=new int[26];

        for(int i=0;i<m;i++)   // first count frequency of smaller string and for larger string also till respective no.
        {
            s1Count[s1.charAt(i)-'a']++;
            s2Count[s2.charAt(i)-'a']++; 
        }

        if(Arrays.equals(s1Count,s2Count)) return true; // if both are equal than simply return true

        for(int j=m;j<n;j++)  //now for making window start from size of smaller string and till length of larger string
        {
            s2Count[s2.charAt(j)-'a']++;  //increment window by just 1

            s2Count[s2.charAt(j-m)-'a']--; // remoeve frequency of first checked element

            if(Arrays.equals(s1Count,s2Count)) return true; // if window equal to the smaller string than simply return true 
        }
    return false; // else return false
    }
}
