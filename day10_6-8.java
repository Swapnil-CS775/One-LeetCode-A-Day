/*
 * 88. Merge Sorted Array
Easy

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 

Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */

 // Solution 
 // this approch satisfy 43 conditions out of 59
 
 class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int s=m-1,t=n-1,k=nums1.length-1;
        if(s+1==0)
        {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        for(int i=0;i<nums1.length;i++)
        {
            if(s>=0 && t>=0 && k>=0 && nums1[s]<nums2[t] )
            {
                nums1[k]=nums2[t];
                k--;
                t--;
            }
            else
            {
                if(k>=0 && s>=0)
                {
                    nums1[k]=nums1[s];
                    s--;
                    k--;
                }
            }
        }
    }
}


//Explaination
/*
 * Example: nums1 = [1, 2, 3, 0, 0, 0], m = 3
 *          nums2 = [2, 5, 6], n = 3
 * 
 * Initial pointers:
 * s = m - 1 = 2 (points to nums1[2] which is 3)
 * t = n - 1 = 2 (points to nums2[2] which is 6)
 * k = nums1.length - 1 = 5 (points to the last element of nums1)
 * 
 * Step-by-step process:
 * 
 * 1. Compare nums1[s] (3) and nums2[t] (6):
 *    - nums1[s] < nums2[t], so place nums2[t] at nums1[k]
 *    - nums1 becomes [1, 2, 3, 0, 0, 6]
 *    - Decrement t and k: t = 1, k = 4
 * 
 * 2. Compare nums1[s] (3) and nums2[t] (5):
 *    - nums1[s] < nums2[t], so place nums2[t] at nums1[k]
 *    - nums1 becomes [1, 2, 3, 0, 5, 6]
 *    - Decrement t and k: t = 0, k = 3
 * 
 * 3. Compare nums1[s] (3) and nums2[t] (2):
 *    - nums1[s] > nums2[t], so place nums1[s] at nums1[k]
 *    - nums1 becomes [1, 2, 3, 3, 5, 6]
 *    - Decrement s and k: s = 1, k = 2
 * 
 * 4. Compare nums1[s] (2) and nums2[t] (2):
 *    - nums1[s] >= nums2[t], so place nums1[s] at nums1[k]
 *    - nums1 becomes [1, 2, 2, 3, 5, 6]
 *    - Decrement s and k: s = 0, k = 1
 * 
 * 5. Compare nums1[s] (1) and nums2[t] (2):
 *    - nums1[s] < nums2[t], so place nums2[t] at nums1[k]
 *    - nums1 becomes [1, 2, 2, 3, 5, 6]
 *    - Decrement t and k: t = -1, k = 0
 * 
 * 6. At this point, t < 0, so we exit the loop.
 * 
 * Final merged array: [1, 2, 2, 3, 5, 6]
 */


 //Optimized approch
