/*
438. Find All Anagrams in a String
Solved
Medium
Topics
Companies
Given two strings s and p, return an array of all the start indices of p's 
anagrams
 in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/


//Code - 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int m=p.length();
        List<Integer>ans=new ArrayList<>();

        if(m>n) return ans;
        
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (int i = 0; i < m; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount)) {
            ans.add(0);
        }

        for (int i = m; i < n; i++) {
            // Add the current character to the window
            sCount[s.charAt(i) - 'a']++;

            // Remove the character that goes out of the window
            sCount[s.charAt(i - m) - 'a']--;

            // If the frequency arrays match, we have an anagram
            if (Arrays.equals(pCount, sCount)) {
                ans.add(i - m + 1);
            }
        }

    return ans;
    }
}

/*
Code:
java
Copy code
import java.util.*;
Line 1: We import necessary classes. Here, java.util.* imports all utility classes, such as List, ArrayList, and Arrays, which we use in our solution.
java
Copy code
class Solution {
Line 3: This defines the Solution class, which is where our findAnagrams method will reside.
java
Copy code
    public List<Integer> findAnagrams(String s, String p) {
Line 4: This is the method definition for findAnagrams. It takes two parameters:
s: The string in which we are searching for anagrams.
p: The string whose anagrams we are looking for within s. The method returns a List<Integer> containing the start indices of all anagrams of p found in s.
java
Copy code
        int n = s.length();
        int m = p.length();
Line 5-6: Here, we get the lengths of strings s and p and store them in variables n and m, respectively.
n is the length of s, the string where we are searching for anagrams.
m is the length of p, the string whose anagrams we need to find in s.
java
Copy code
        List<Integer> ans = new ArrayList<>();
Line 7: We initialize an empty ArrayList<Integer> called ans. This list will store the starting indices of the anagrams of p found in s.
java
Copy code
        if (n < m) {
            return ans;
        }
Line 8-10: We check if the length of s is less than the length of p. If s is shorter than p, it's impossible for s to contain any anagrams of p. In that case, we immediately return the empty list ans.
java
Copy code
        int[] pCount = new int[26];
        int[] sCount = new int[26];
Line 11-12: We initialize two integer arrays pCount and sCount of size 26, where each index represents a letter of the alphabet ('a' to 'z'). These arrays will be used to store the frequency counts of the characters in p and in the current sliding window of s.
java
Copy code
        for (int i = 0; i < m; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
Line 13-15:
First loop: This loop iterates over the first m characters of both p and s (because the window size is m).
For each character in p, we increment the corresponding index in pCount. For example, if p.charAt(i) is 'a', then pCount['a' - 'a']++ increments the first index of pCount (index 0 for 'a').
We do the same for the first m characters of s to initialize the frequency count of the first window of s.
java
Copy code
        if (Arrays.equals(pCount, sCount)) {
            ans.add(0);
        }
Line 16-18:
After setting up the frequency arrays for both p and the first window of s, we compare them using Arrays.equals().
If pCount and sCount are equal, it means that the first window in s is an anagram of p, so we add the index 0 to the result list ans.
java
Copy code
        for (int i = m; i < n; i++) {
Line 19: This loop starts sliding the window over the string s. It begins at index m because we've already processed the first window (s[0...m-1]).
java
Copy code
            sCount[s.charAt(i) - 'a']++;
Line 20: For each new character that enters the sliding window (at position i), we increment the corresponding index in sCount. This updates the frequency count for the character that has just entered the window.
java
Copy code
            sCount[s.charAt(i - m) - 'a']--;
Line 21: As the window slides, the character at position i - m goes out of the window. We decrement the corresponding index in sCount to remove the count of the character that is no longer in the window.
java
Copy code
            if (Arrays.equals(pCount, sCount)) {
                ans.add(i - m + 1);
            }
Line 22-24:
After updating the frequency count for the sliding window, we check if pCount and sCount are now equal. If they are, it means the current window is an anagram of p.
We add the starting index of the current window (i - m + 1) to the list ans. The expression i - m + 1 computes the starting index of the current window.
java
Copy code
        return ans;
Line 25: Finally, after processing all possible windows in s, we return the list ans, which contains all the starting indices of the anagrams of p in s.
Detailed Example Walkthrough:
Let’s walk through the example s = "cbaebabacd" and p = "abc".

Initialization:

n = 10 (length of s).
m = 3 (length of p).
pCount = [1, 1, 1, 0, ..., 0] (character counts for p = "abc").
sCount = [1, 1, 1, 0, ..., 0] (character counts for the first window s[0...2] = "cba").
First Window Check (s[0...2] = "cba"):

Arrays.equals(pCount, sCount) is true, so we add 0 to the result list: ans = [0].
Sliding the Window:

Move the window to s[1...3] = "bae".

Update sCount: add s[3] = 'e', subtract s[0] = 'c'.

Arrays.equals(pCount, sCount) is false, so no index is added.

Move to s[2...4] = "aeb", update sCount, check again, no match.

Move to s[3...5] = "eba", update sCount, no match.

Move to s[4...6] = "bae", update sCount, no match.

Final Matching Window:

Move to s[6...8] = "bac".
Arrays.equals(pCount, sCount) is true, so we add 6 to the result list: ans = [0, 6].
Return the result: After processing all windows, we return ans = [0, 6].
*/

