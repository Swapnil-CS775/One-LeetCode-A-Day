/*
704. Binary Search
Easy
Runtime - 0 ms | Beats 100%
Memory - 45.80 MB | Beats 28.04%

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.

 */


//Solution
class Solution {
    public int search(int[] nums, int target) {
        int start=0,end=nums.length-1,mid;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
}

//Explaination 
// Simple apply binary search
/*
Runtime - 0 ms | Beats 100.00%
Memory - 41.76 MB | Beats 88.19%
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {   
        int outerStart = 0, outerEnd = matrix.length - 1, mid;
        
        // Binary search to find the correct row
        while (outerStart <= outerEnd) {
            mid = outerStart + (outerEnd - outerStart) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                outerStart = mid + 1;
            } else {
                outerEnd = mid - 1;
            }
        }
        
        // At this point, outerEnd should be the index of the row where the target could be
        if (outerEnd < 0) {
            return false;  // Target is smaller than the smallest element in the matrix
        }
        
        int innerStart = 0, innerEnd = matrix[outerEnd].length - 1;
        
        // Binary search within the found row
        while (innerStart <= innerEnd) {
            mid = innerStart + (innerEnd - innerStart) / 2;
            if (matrix[outerEnd][mid] == target) {
                return true;
            } else if (matrix[outerEnd][mid] < target) {
                innerStart = mid + 1;
            } else {
                innerEnd = mid - 1;
            }
        }
        
        return false;  // Target not found
    }
}

//Explaination
/*
Example Matrix:
matrix = [
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 60]
]
Target: 16

Step 1: Binary Search on Rows
--------------------------------
Initial Values:
- outerStart = 0 (first row)
- outerEnd = 2 (last row)

Iteration 1:
- Calculate mid = 0 + (2 - 0) / 2 = 1 (second row)
- Compare matrix[mid][0] = matrix[1][0] = 10 with target = 16.
- Since 10 < 16, move outerStart to mid + 1 = 2.

Iteration 2:
- Calculate mid = 2 + (2 - 2) / 2 = 2 (third row)
- Compare matrix[mid][0] = matrix[2][0] = 23 with target = 16.
- Since 23 > 16, move outerEnd to mid - 1 = 1.

Result:
- The target could be in row with index outerEnd = 1 (second row).

Step 2: Binary Search within the Row
--------------------------------------
Row to Search: [10, 11, 16, 20]
- outerEnd = 1, so search within this row.

Initial Values:
- innerStart = 0 (first element in the row)
- innerEnd = 3 (last element in the row)

Iteration 1:
- Calculate mid = 0 + (3 - 0) / 2 = 1 (second element)
- Compare matrix[outerEnd][mid] = matrix[1][1] = 11 with target = 16.
- Since 11 < 16, move innerStart to mid + 1 = 2.

Iteration 2:
- Calculate mid = 2 + (3 - 2) / 2 = 2 (third element)
- Compare matrix[outerEnd][mid] = matrix[1][2] = 16 with target = 16.
- Since they are equal, return true.

Final Result:
- The target 16 is found in the matrix at position (1, 2).
*/
