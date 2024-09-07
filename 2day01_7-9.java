class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        
        // If no pivot is found, the array is not rotated, just do a normal binary search
        if (pivot == -1) {
            return binarysearch(nums, target, 0, nums.length - 1);
        }

        // If pivot is found, check if it's the target
        if (nums[pivot] == target) {
            return pivot;
        }

        // If the target is greater than or equal to the first element, search in the left side
        if (target >= nums[0]) {
            return binarysearch(nums, target, 0, pivot - 1);
        }

        // Otherwise, search in the right side
        return binarysearch(nums, target, pivot + 1, nums.length - 1);
    }

    public int binarysearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1; // target not found
    }

    public int findPivot(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1: mid is the pivot
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // Case 2: mid-1 is the pivot
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            // Decide which side to go
            if (arr[mid] >= arr[start]) {
                start = mid + 1; // go right
            } else {
                end = mid - 1; // go left
            }
        }
        return -1; // no pivot found, array is not rotated
    }
}
