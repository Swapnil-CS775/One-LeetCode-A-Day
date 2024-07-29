/*
 * 1. Two Sum
 * ARRAY
 * Level: Easy
 * Runtime: 44 ms | Beats: 40.20%
 * Memory: 44.93 MB | Beats: 25.23%
 * 
 * Given an array of integers `nums` and an integer `target`, return the indices of the two numbers 
 * such that they add up to the target. You may assume that each input will have exactly one solution, 
 * and you may not use the same element twice. You can return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2:
 * Input: nums = [3, 2, 4], target = 6
 * Output: [1, 2]
 * 
 * Example 3:
 * Input: nums = [3, 3], target = 6
 * Output: [0, 1]
 * 
 * Constraints:
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 * 
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 */


// Ans:

import java.util.Arrays;//no need of these statement in LEETCODE environment
class Solution {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] arr = {i, j};
                    return arr;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();// Object of solution class
        int nums[] = {2, 7, 11, 15}; // Example input array
        int target = 9; // Example target sum
        
        int[] ans = solution.twoSum(nums, target);// calling twoSum function by passing 2 parameter
        System.out.println(Arrays.toString(ans));// printing array return by twoSum function in which ////contain index of that two places/number
    }
}

/*
 * Explanation:
 * 
 * Name: twoSum (Using Array)
 * - Finds two indices in the array such that their values add up to the target.
 * - @param nums The input array of integers.
 * - @param target The target sum for the pair of numbers.
 * - @return An array of two indices whose values add up to the target, or null if no such pair exists.
 * 
 * For Loop:
 * - Outer loop iterates over the array with the first pointer (i).
 * - Inner loop iterates over the array with the second pointer (j), starting from the next element (i + 1).
 * 
 * Conditional Check:
 * - If the sum of elements at indices i and j equals the target, it returns the indices in an array.
 * 
 * Return Statement:
 * - Returns the indices in an array if a valid pair is found.
 * - Returns null if no such pair is found.
 * 
 * Main Method:
 * - Defines an example input array and target value.
 * - Calls the twoSum method and stores the result.
 * - Prints the result as a string representation of the array.
 * 
 * The Arrays.toString(ans) method is used to convert the integer array ans into a human-readable string format. This allows you to print the array in a readable form, displaying the elements enclosed in square brackets, separated by commas.
 * 
 * In this repository, we focus on solving selected DSA problems and providing clear explanations for each solution. As we progress, we will delve into more advanced features and concepts, including analyzing the time complexity of our solutions, optimizing performance, and exploring alternative algorithms. Stay tuned for upcoming series where we will discuss these advanced topics in detail, offering insights into improving efficiency and understanding the underlying principles of algorithm design.
 * 
 * THANKS
 */
