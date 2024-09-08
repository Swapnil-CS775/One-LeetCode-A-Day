class Solution {
    public boolean search(int[] nums, int target) {
        // Handle edge case for empty array or array with one element
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }

        int start = 0, end = nums.length - 1;
        int pivot = findPivot(nums, start, end);

        if (pivot == -1) {
            // Array is not rotated, perform binary search on the entire array
            return binarySearch(nums, target, start, end);
        }

        // Determine which part of the array to search
        if (nums[pivot] == target) {
            return true;
        } else if (nums[start] <= target && target < nums[pivot]) {
            return binarySearch(nums, target, start, pivot - 1);
        } else {
            return binarySearch(nums, target, pivot + 1, end);
        }
    }

    private boolean binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    private int findPivot(int[] nums, int start, int end) {
        while (start <= end) {
            if (start == end) {
                return start;
            }

            int mid = start + (end - start) / 2;

            // Handle edge cases
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;
                if (nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
