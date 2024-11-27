/*
350. Intersection of Two Arrays II
Solved
Easy
Topics
Companies
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

//Code - 

// difference in this and previous question is that there duplicate elements are not allow and here allow means if there is a duplicates in intersection than this also considerd
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> myList = new ArrayList<>();  // list to store ans
        int[] freqArr=new int[1001]; // take one frequency arrya
        for(int num:nums2) // we create frequency array for nums1 we can create for any of above
        {
            freqArr[num]++; // insert frequency of preticular number in that array.. here index represent a number and value at that index represent frequency
        }

        for (int num : nums1) { // now iterate through second arrya
            if (freqArr[num]>0) { //  if that array element contain in frquency array and its frequency is strictly greater than 0 than add it in ans list...if freq = 0 that means no. is absent
                myList.add(num);  
                freqArr[num]--;  // after consider for ans reduce frequency
            }
        }

        int[] ans=new int[myList.size()]; // convert list to array

        for(int i=0;i<ans.length;i++)
        {
            ans[i]=myList.get(i);
        }
    return ans;
    }
}
