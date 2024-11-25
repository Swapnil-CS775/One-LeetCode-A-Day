/*
2956. Find Common Elements Between Two Arrays
Solved
Easy
Topics
Companies
Hint
You are given two integer arrays nums1 and nums2 of sizes n and m, respectively. Calculate the following values:

answer1 : the number of indices i such that nums1[i] exists in nums2.
answer2 : the number of indices i such that nums2[i] exists in nums1.
Return [answer1,answer2].

 

Example 1:

Input: nums1 = [2,3,2], nums2 = [1,2]

Output: [2,1]

Explanation:



Example 2:

Input: nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]

Output: [3,4]

Explanation:

The elements at indices 1, 2, and 3 in nums1 exist in nums2 as well. So answer1 is 3.

The elements at indices 0, 1, 3, and 4 in nums2 exist in nums1. So answer2 is 4.

Example 3:

Input: nums1 = [3,4,2,3], nums2 = [1,5]

Output: [0,0]

Explanation:

No numbers are common between nums1 and nums2, so answer is [0,0].

 

Constraints:

n == nums1.length
m == nums2.length
1 <= n, m <= 100
1 <= nums1[i], nums2[i] <= 100
*/

//Code Bruitforce approch - 
class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int countA=0,countB=0;
        int[] ans=new int[2];
        
        for(int i=0;i<nums1.length;i++) // once iterate through num1 and 
        {
            for(int j=0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j]) //if num1 number is present in num2 than count++ and brek.. means no need to search again bcz it is found 
                {
                    countA++;
                    break;
                }
            }
        }
        for(int k=0;k<nums2.length;k++) //then through num2 
        {
            for(int l=0;l<nums1.length;l++)
            {
                if(nums2[k]==nums1[l]) //same hare //if num1 number is present in num2 than count++ and brek.. means no need to search again bcz it is found 
                {
                    countB++;
                    break;
                }
            }
        }
        ans[0]=countA;
        ans[1]=countB;
    return ans;
    }
}

