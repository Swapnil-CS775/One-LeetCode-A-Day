/*
387. First Unique Character in a String
Solved
Easy
Topics
premium lock icon
Companies
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"

Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

Input: s = "loveleetcode"

Output: 2

Example 3:

Input: s = "aabb"

Output: -1

 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.



*/

//simple approch

class Solution {
    public int firstUniqChar(String s) {
        // Step 1: Count frequency of each character
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Step 2: Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;  // No unique character found

    }
}


//lets do it using streming
//but this is not a optimal approach to solve it ..above approach is moderate;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) == 1) {
                queue.add(i);
            }

            
        }

        // Remove from queue while it’s no longer unique
        while (!queue.isEmpty() && map.get(s.charAt(queue.peek())) > 1) {
            queue.poll(); //removing elements from the front
            /* 
            peek() → retrieves but does not remove the head of the queue
            (returns null if empty).

            poll() → retrieves and removes the head (returns null if empty).

            remove() → retrieves and removes the head (throws 
            NoSuchElementException if empty).
            
            */
        }

        return queue.isEmpty() ? -1 : queue.peek();
    }
}
