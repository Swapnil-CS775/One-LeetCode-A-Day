/*
349. Intersection of Two Arrays
Solved
Easy
Topics
Companies
Given two integer arrays nums1 and nums2, return an array of their 
intersection
. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
*/

//Brut force approch

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer>myList=new ArrayList<>(); //put intesection element in this list
        Set<Integer>mySet=new HashSet<>(); // element should not be checked again 

        for(int i=0;i<nums1.length;i++) //iterate through array 1
        {
            for(int j=0;j<nums2.length;j++) // iterate through array 2
            {
                if(!mySet.contains(nums1[i]) && nums1[i]==nums2[j]) // if no. not already checked and it should be present in array 2 than it will be intersection
                {
                    myList.add(nums1[i]);
                    mySet.add(nums1[i]);
                }
            }
        }
    return myList.stream().mapToInt(Integer::intValue).toArray(); //this is a menthod to convert integer list into integer array
    }  
}


//Second approch

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer>myList=new ArrayList<>(); //Store ans
        Set<Integer>mySet1=new HashSet<>(); //store unique element in nums1
        Set<Integer>mySet2=new HashSet<>(); //store unique element in nums2

        for(int num:nums1)
        {
            mySet1.add(num); //add nums1 element in set
        }
        for(int num:nums2)
        {
            mySet2.add(num);  //add nums1 element in set
        }

        for(int num:mySet1)
        {
            if(mySet2.contains(num)) //check if this num is present in other set than add to list 
            {
                myList.add(num);
            }
        }
        
    return myList.stream().mapToInt(Integer::intValue).toArray();
    }  
}

//third approch using sorting
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer>myList=new ArrayList<>();
        Set<Integer>mySet=new HashSet<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0;
        int j=0;

        while(i<nums1.length && j<nums2.length)
        {
            if(!mySet.contains(nums1[i]) && nums1[i]==nums2[j])
            {
                myList.add(nums1[i]);
                mySet.add(nums1[i]);
                i++;
                j++;
                continue;
            }

            if(nums1[i]>nums2[j])
            {
                j++;
                continue;
            }

            if(mySet.contains(nums1[i]) || nums1[i]<nums2[j])
            {
                i++;
                continue;
            }
        i++;
        j++;
        }

        int[] ans = new int[myList.size()];
        for(int k=0;k<myList.size();k++)
        {
            ans[k]=myList.get(k);
        }
    return ans;
    }  
}

//This is most optimized approch 
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer>myList=new ArrayList<>();
        Set<Integer>mySet=new HashSet<>();  // we use singe hashSet
        
        for(int i=0;i<nums2.length;i++) //put any array element in hashset
        {
            mySet.add(nums2[i]);
        }

        for(int j=0;j<nums1.length;j++) //iterate over an array
        {
            if(mySet.contains(nums1[j]))  //if array element is present in set than simply add it in list and remove form set
            {
                myList.add(nums1[j]);
                mySet.remove(nums1[j]);
            }
        }

        int[] ans = new int[myList.size()];
        for(int k=0;k<myList.size();k++) //convet given list into array
        {
            ans[k]=myList.get(k);
        }
    return ans;
    }  
}

