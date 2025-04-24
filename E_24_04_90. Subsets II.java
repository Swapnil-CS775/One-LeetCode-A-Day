/*
90. Subsets II
Solved
Medium
Topics
Companies
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/

// code - 
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        //this is req sorted array bcz we need to identify duplicate element 
        Arrays.sort(nums);
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());

        int start=0;
        int end=0;

        for(int i=0;i<nums.length;i++){
            //by defult start=0
            start=0;
            //if element is equil to previous element than change start
            if(i>0 && nums[i]==nums[i-1]){
                start=end+1;
            }
            end=outer.size()-1;
            int n=outer.size();
            for(int j=start;j<n;j++){
                List<Integer>inner=new ArrayList<>(outer.get(j));
                inner.add(nums[i]);
                outer.add(inner);
            }
        }
    return outer;
    }
}
