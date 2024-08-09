/*
 * 744. Find Smallest Letter Greater Than Target
Easy
Runtime - 0 ms | Beats 100%
Memory - 44.38 | Beats 30.58%

You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.

 

Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
Example 2:

Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
Example 3:

Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
 

Constraints:

2 <= letters.length <= 104
letters[i] is a lowercase English letter.
letters is sorted in non-decreasing order.
letters contains at least two different characters.
target is a lowercase English letter.
 */

 //Solution
 class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start < letters.length ? letters[start] : letters[0];
    }
}


//Explaination
/*
Example 1:
    letters = ['c', 'f', 'j']
    target = 'a'
    
    Initialization:
        start = 0
        end = 2
        
    Iteration 1:
        mid = 0 + (2 - 0) / 2 = 1
        letters[mid] = 'f'
        'f' > 'a' => end = 0
        
    Iteration 2:
        start = 0
        end = 0
        mid = 0 + (0 - 0) / 2 = 0
        letters[mid] = 'c'
        'c' > 'a' => end = -1
        
    Termination:
        start = 0, within bounds
        Output: 'c'

Example 2:
    letters = ['c', 'f', 'j']
    target = 'c'
    
    Initialization:
        start = 0
        end = 2
        
    Iteration 1:
        mid = 0 + (2 - 0) / 2 = 1
        letters[mid] = 'f'
        'f' > 'c' => end = 0
        
    Iteration 2:
        start = 0
        end = 0
        mid = 0 + (0 - 0) / 2 = 0
        letters[mid] = 'c'
        'c' <= 'c' => start = 1
        
    Termination:
        start = 1, within bounds
        Output: 'f'

Example 3:
    letters = ['x', 'x', 'y', 'y']
    target = 'z'
    
    Initialization:
        start = 0
        end = 3
        
    Iteration 1:
        mid = 0 + (3 - 0) / 2 = 1
        letters[mid] = 'x'
        'x' <= 'z' => start = 2
        
    Iteration 2:
        start = 2
        end = 3
        mid = 2 + (3 - 2) / 2 = 2
        letters[mid] = 'y'
        'y' <= 'z' => start = 3
        
    Iteration 3:
        start = 3
        end = 3
        mid = 3 + (3 - 3) / 2 = 3
        letters[mid] = 'y'
        'y' <= 'z' => start = 4
        
    Termination:
        start = 4, out of bounds
        Output: 'x'
*/
