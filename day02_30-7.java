/*
 * 26. Remove Duplicates from Sorted Array
 * Array
 * Level: Easy
 * Runtime: 1 ms | Beats: 77.45%
 * Memory: 44.31 MB | Beats: 93.47%
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * 
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
 * The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * 
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * 
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10^4
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 */

 // Code:
 class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length-1 && nums[i] == nums[i + 1]) {
                continue;
            }
            else
            {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int nums[] = { 1, 1, 2 };
        int ans = obj.removeDuplicates(nums);
        System.out.println(ans);
    }
}

//EXPLAINATION
/*
 * The `removeDuplicates` method aims to remove duplicate elements from a sorted array `nums` in place and return the count of unique elements.
 *
 * int count = 0;
 * - `count` is initialized to 0. It will track the index of the next unique element in the `nums` array.
 *
 * for (int i = 0; i < nums.length; i++) {
 * - A loop that iterates over each element of the array `nums` from the first element to the last.
 *
 * if (i < nums.length-1 && nums[i] == nums[i + 1]) {
 * - Checks if the current element `nums[i]` is equal to the next element `nums[i + 1]` and ensures that `i` is within bounds to avoid an `ArrayIndexOutOfBoundsException`.
 * - If they are equal, it means there is a duplicate, so the loop continues to the next iteration, effectively skipping the duplicate element.
 *
 * else {
 * - If the elements are not equal, or if it's the last element in the array, this block is executed.
 * 
 * nums[count] = nums[i];
 * - The current element `nums[i]` is placed at the index `count` in the array. This ensures that unique elements are moved to the front of the array.
 *
 * count++;
 * - The `count` is incremented to reflect that another unique element has been found and placed correctly.
 *
 * return count;
 * - After the loop completes, the method returns the value of `count`, which represents the number of unique elements in the array.
 *
 * Example:
 * Consider the array nums = [1, 1, 2].
 *
 * Iteration 1 (i = 0):
 * - nums[i] = 1, nums[i + 1] = 1 (they are equal)
 * - Skip to the next iteration (i = 1)
 *
 * Iteration 2 (i = 1):
 * - nums[i] = 1, nums[i + 1] = 2 (they are not equal)
 * - nums[count] = nums[i] => nums[0] = 1
 * - Increment count => count = 1
 *
 * Iteration 3 (i = 2):
 * - This is the last element.
 * - nums[count] = nums[i] => nums[1] = 2
 * - Increment count => count = 2
 *
 * The final array is [1, 2, _] with `count` = 2, meaning there are 2 unique elements.
 */
