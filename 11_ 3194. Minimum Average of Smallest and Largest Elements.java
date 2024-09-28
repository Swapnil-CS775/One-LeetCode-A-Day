/*
 * 3194. Minimum Average of Smallest and Largest Elements
 * Easy
 * 
 * Runtime - 2 ms | Beats 97.70%
 * Memory - 43.18 MB | Beats 98.38%
 * 
 * Problem:
 * You are given an array nums of n integers, where n is even. 
 * The task is to:
 * 1. Repeatedly remove the smallest (minElement) and largest (maxElement) elements from the array.
 * 2. Add the average of these two numbers, (minElement + maxElement) / 2, to an array called averages.
 * 3. Return the smallest value in the averages array.
 *
 * Example 1:
 * Input: nums = [7, 8, 3, 4, 15, 13, 4, 1]
 * Output: 5.5
 * 
 * Explanation:
 * - Remove (1 and 15), average is (1 + 15) / 2 = 8.0
 * - Remove (3 and 13), average is (3 + 13) / 2 = 8.0
 * - Remove (4 and 8), average is (4 + 8) / 2 = 6.0
 * - Remove (4 and 4), average is (4 + 4) / 2 = 4.0
 * - The averages array is [8.0, 8.0, 6.0, 4.0], and the smallest value is 4.0.
 * 
 * Constraints:
 * n is even (1 <= nums.length <= 10^5)
 * -10^9 <= nums[i] <= 10^9
 */

// Solution
import java.util.Arrays;

class Solution {
    public double minimumAverage(int[] nums) {
        // Sort the array to access the smallest and largest elements easily
        Arrays.sort(nums);
        
        // Initialize pointers for the smallest and largest elements
        int i = 0, j = nums.length - 1;
        
        // Initialize the minimum average with the average of the first and last elements
        double min = (nums[i] + nums[j]) / 2.0;
        
        // Loop through the array, pairing smallest and largest elements
        while (i < j) {
            double average = (nums[i] + nums[j]) / 2.0;
            // Update the minimum if the current average is smaller
            if (average < min) {
                min = average;
            }
            // Move pointers inward
            i++;
            j--;
        }
        
        // Return the smallest average found
        return min;
    }
}

/*
Explanation:

1. **Problem Overview**:
   The goal is to find the minimum average of the smallest and largest elements removed from the array `nums` repeatedly until all elements are processed.

2. **Approach**:
   - The array is sorted to easily find the smallest and largest elements.
   - Using two pointers (`i` and `j`), we access the smallest (`nums[i]`) and largest (`nums[j]`) elements, compute their average, and check if it is less than the previously recorded minimum average.
   - After processing all pairs, we return the smallest average recorded.

3. **Example Walkthroughs**:
   - **Example 1**:
     Input: `nums = [7, 8, 3, 4, 15, 13, 4, 1]`
     - After sorting: `[1, 3, 4, 4, 7, 8, 13, 15]`
     - Averages calculated are: `8.0`, `8.0`, `6.0`, and `4.0`.
     - The smallest average is `4.0`.
     Output: `4.0`

4. **Time Complexity**:
   - The time complexity is **O(n log n)** due to the sorting step, where `n` is the length of the array. The subsequent operations in the loop run in **O(n)** time.

5. **Space Complexity**:
   - The space complexity is **O(1)** for this algorithm, as we are not using any additional data structures that grow with the input size apart from the input array itself.
*/
