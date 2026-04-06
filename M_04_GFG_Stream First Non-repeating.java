/*
Stream First Non-repeating
Difficulty: MediumAccuracy: 31.65%Submissions: 240K+Points: 4Average Time: 15m
Given a string s consisting of only lowercase alphabets, for each index i in the string (0 ≤ i < n), find the first non-repeating character in the prefix s[0..i]. If no such character exists, use '#'.

Examples:

Input: s = "aabc"
Output: a#bb
Explanation: 
At i=0 ("a"): First non-repeating character is 'a'.
At i=1 ("aa"): No non-repeating character, so '#'.
At i=2 ("aab"): First non-repeating character is 'b'.
At i=3 ("aabc"): Non-repeating characters are 'b' and 'c'; 'b' appeared first, so 'b'. 
Input: s = "bb" 
Output: "b#" 
Explanation: 
At i=0 ("b"): First non-repeating character is 'b'.
At i=1 ("bb"): No non-repeating character, so '#'.
Constraints:
1 ≤ s.size() ≤ 105
*/

//code --
class Solution {
    public String firstNonRepeating(String s) {
        // code here
        Queue<Character>queue=new LinkedList<>();
        int[] freq=new int[256];
        StringBuilder sb=new StringBuilder();
        
        if(s.equals(null)) return "";
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
           
            queue.add(ch);
            while(!queue.isEmpty() && freq[queue.peek()-'a']>1) queue.remove();
            if(queue.isEmpty())sb.append("#");
            else sb.append(queue.peek());
        }
        
        
        return sb.toString();
        
    }
}
