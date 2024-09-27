/*
 * 217. Contains Duplicate
 * Easy
 * 
 * Runtime - 11 ms | Beats 72.13%
 * Memory - 57.98 MB | Beats 50.47%
 * 
 * Problem:
 * Given an integer array nums, return true if any value appears at least twice in the array, 
 * and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1, 2, 3, 1]
 * Output: true
 * Explanation: The element 1 occurs at indices 0 and 3.
 * 
 * Example 2:
 * Input: nums = [1, 2, 3, 4]
 * Output: false
 * Explanation: All elements are distinct.
 * 
 * Example 3:
 * Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
 * Output: true
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */

// Solution
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store unique elements encountered in the array
        HashSet<Integer> set = new HashSet<>();
        
        // Loop through each element in the array
        for (int num : nums) {
            // If the number already exists in the set, a duplicate is found
            if (set.contains(num)) {
                return true;
            }
            // If not, add the number to the set
            set.add(num);
        }
        
        // If no duplicates are found after checking all elements, return false
        return false;
    }
}

/*
Explanation:

1. **Problem Overview**:
   The goal is to determine if any element in the array `nums` appears more than once. If any duplicate is found, return `true`; otherwise, return `false`.

2. **Approach**:
   - The most efficient way to solve this problem is to use a **HashSet**, which stores only unique elements.
   - As we iterate through the array, we check if the current element already exists in the set:
     - If it does, it means we’ve found a duplicate, so we return `true`.
     - If it doesn’t, we add it to the set and continue.
   - If we reach the end of the array without finding any duplicates, we return `false`.

3. **Example Walkthroughs**:
   - **Example 1**:
     Input: `nums = [1, 2, 3, 1]`
     - We start iterating: 
       - `1` is not in the set, so we add it.
       - `2` is not in the set, so we add it.
       - `3` is not in the set, so we add it.
       - The next `1` is already in the set, so we return `true`.
     Output: `true`
   
   - **Example 2**:
     Input: `nums = [1, 2, 3, 4]`
     - We iterate through the entire array:
       - `1`, `2`, `3`, `4` are all unique, so we add them to the set one by one.
     - After checking all elements, no duplicates are found, so we return `false`.
     Output: `false`
   
   - **Example 3**:
     Input: `nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]`
     - We iterate:
       - `1` is not in the set, so we add it.
       - The second `1` is already in the set, so we return `true`.
     Output: `true`

4. **Time Complexity**:
   - The time complexity is **O(n)**, where `n` is the length of the array. This is because we only perform constant-time operations (adding to the set and checking for duplicates) for each element.
   
5. **Space Complexity**:
   - The space complexity is **O(n)**, as we need additional space to store the elements in the set.
*/
