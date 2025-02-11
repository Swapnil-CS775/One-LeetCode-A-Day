/*
 * 2089. Find Target Indices After Sorting Array
 * Easy
 * 
 * Runtime - 2 ms | Beats 84.65%
 * Memory - 43.01 MB | Beats 67.95%
 * 
 * Problem:
 * You are given a 0-indexed integer array 'nums' and a target element 'target'.
 * 
 * A target index is an index 'i' such that nums[i] == target.
 * 
 * Return a list of the target indices of 'nums' after sorting 'nums' in non-decreasing order.
 * If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
 * 
 * Example 1:
 * Input: nums = [1, 2, 5, 2, 3], target = 2
 * Output: [1, 2]
 * Explanation: After sorting, nums is [1, 2, 2, 3, 5].
 * The indices where nums[i] == 2 are 1 and 2.
 * 
 * Example 2:
 * Input: nums = [1, 2, 5, 2, 3], target = 3
 * Output: [3]
 * Explanation: After sorting, nums is [1, 2, 2, 3, 5].
 * The index where nums[i] == 3 is 3.
 * 
 * Example 3:
 * Input: nums = [1, 2, 5, 2, 3], target = 5
 * Output: [4]
 * Explanation: After sorting, nums is [1, 2, 2, 3, 5].
 * The index where nums[i] == 5 is 4.
 * 
 * Constraints:
 * 1 <= nums.length <= 100
 * 1 <= nums[i], target <= 100
 */

// Solution
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Create a list to store the target indices
        List<Integer> index = new ArrayList<>();
        
        // Step 3: Find target indices in the sorted array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index.add(i);
            }
        }
        
        // Step 4: Return the list of indices
        return index;
    }
}

/*
Explanation:

1. **Problem Overview**:
   The goal is to find the indices of the target element in a sorted version of the input array `nums`.

2. **Approach**:
   - First, sort the array `nums` in non-decreasing order.
   - Then, iterate through the sorted array to find all indices where the element matches the target.
   - Store these indices in a list and return the list.

3. **Example Walkthroughs**:
   - **Example 1**:
     Input: `nums = [1, 2, 5, 2, 3]`, `target = 2`
     - After sorting: `nums = [1, 2, 2, 3, 5]`
     - The indices of `2` are `1` and `2`, so output: `[1, 2]`.
   
   - **Example 2**:
     Input: `nums = [1, 2, 5, 2, 3]`, `target = 3`
     - After sorting: `nums = [1, 2, 2, 3, 5]`
     - The index of `3` is `3`, so output: `[3]`.
   
   - **Example 3**:
     Input: `nums = [1, 2, 5, 2, 3]`, `target = 5`
     - After sorting: `nums = [1, 2, 2, 3, 5]`
     - The index of `5` is `4`, so output: `[4]`.

4. **Time Complexity**:
   - The time complexity is **O(n log n)** due to the sorting step, where `n` is the length of the array.

5. **Space Complexity**:
   - The space complexity is **O(n)** for storing the sorted indices in the list.
*/
