class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int size=nums.length-1;
        if(nums[size]==size-1)
        {
            return size;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==i)
            {
                continue;
            }
            else
                return i;
        }
        return nums[nums.length-1]+1;
    }
}
