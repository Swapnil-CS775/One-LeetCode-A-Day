/*
Find pairs with given sum in doubly linked list
Difficulty: EasyAccuracy: 66.01%Submissions: 100K+Points: 2Average Time: 10m
Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.

 

Example 1:

Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs 
(1, 6) and (2,5) with sum 7.
 

Example 2:

Input: 
1 <-> 5 <-> 6
target = 6
Output: (1,5)
Explanation: We can see that there is one pairs  (1, 5) with sum 6.

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findPairsWithGivenSum() which takes head node of the doubly linked list and an integer target as input parameter and returns an array of pairs. If there is no such pair return empty array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
Constraints:
1 <= N <= 105
1 <= target <= 105
*/


//code 
//this is an first apprach using n^2 bcz here i am checking for every current node is any pairnode exist if yes than we adding them in array list else update current node 
class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();

        Node current=head;
        while (current!=null && current.data<target){
            int rem=target-current.data;
            Node temp=current.next;
            while (temp!=null && temp.data<target){
                if(temp.data==rem) {
                    list.add(new ArrayList<>(Arrays.asList(current.data,temp.data)));
                    break;
                }
                temp=temp.next;
            }
            current=current.next;
        }

        return list;
    }
}

//more optimal approach 
//usign hashset

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        HashSet<Integer>set=new HashSet<>();
        Node temp=head;
        while (temp!=null && temp.data<target){
            set.add(temp.data);
            temp=temp.next;
        }
        temp=head;
        while (temp!=null && temp.data<target && !set.isEmpty()){
            int rem=target-temp.data;
            if(set.contains(rem) && rem!=temp.data){
                list.add(new ArrayList<>(Arrays.asList(temp.data,rem)));
                set.remove(temp.data);
                set.remove(rem);
            }
            temp=temp.next;
        }
        return list;
    }
}

//expected apprach using 2 pointer
class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        Node f=head;
        Node l=head;

        while (l!=null && l.data<target){
            if(l.next==null) break;
            l=l.next;
        }
        
        while (f!=l && l.next!=f){
            int sum=f.data+l.data;
            if(sum==target){
                list.add(new ArrayList<>(Arrays.asList(f.data,l.data)));
                f=f.next;
                l=l.prev;
            }else if (sum>target) l=l.prev;
            else f=f.next;
        }

        return list;
    }
}
