/*
Longest Subarray with Sum K

Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

Examples:

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.
Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].
Constraints:
1 ≤ arr.size() ≤ 105
-104 ≤ arr[i] ≤ 104
-109 ≤ k ≤ 109
*/

//code - 
class Solution {
    public int longestSubarray(int[] arr, int k) {
       Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        int prefSum = 0;

        for (int i = 0; i < arr.length; ++i) {
            prefSum += arr[i];
            if (prefSum == k) 
                res = i + 1;

            else if (mp.containsKey(prefSum - k)) 
                res = Math.max(res, i - mp.get(prefSum - k));

            if (!mp.containsKey(prefSum))
                mp.put(prefSum, i);
        }

        return res;
    }
}

/*
purpose of this code --
else if (mp.containsKey(prefSum - k)) 
                res = Math.max(res, i - mp.get(prefSum - k));



arr = [10, 5, 2, 7, 1, -1], k = 15
Prefix sums:

Index 0 → 10

Index 1 → 15 ✅ (direct match)

Index 2 → 17

Index 3 → 24

Index 4 → 25

Index 5 → 24

At index 4:

prefSum = 25

prefSum - k = 10, which was seen at index 0

So subarray from index 1 to 4 (i.e., [5, 2, 7, 1]) has sum = 15

Its length = 4

So update res = 4.
*/
