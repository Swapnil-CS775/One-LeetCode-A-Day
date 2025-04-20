/*
Job Sequencing Problem
Difficulty: MediumAccuracy: 34.51%Submissions: 300K+Points: 4
You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

Your task is to find:

The maximum number of jobs that can be completed within their deadlines.
The total maximum profit earned by completing those jobs.
Examples :

Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
Output: [2, 60]
Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
Output: [2, 127]
Explanation: Job1 and Job3 can be done with maximum profit of 127 (100+27).
Input: deadline[] = [3, 1, 2, 2], profit[] = [50, 10, 20, 30]
Output: [3, 100]
Explanation: Job1, Job3 and Job4 can be completed with a maximum profit of 100 (50 + 20 + 30).
Constraints:
1 ≤ deadline.size() == profit.size() ≤ 105
1 ≤ deadline[i] ≤ deadline.size()
1 ≤ profit[i] ≤ 500


*/

//code -
// o(n x n)
class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n=profit.length;
        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) index[i] = i;

        // Sort indices based on profit descending
        Arrays.sort(index, (i, j) -> profit[j] - profit[i]);

        // Create new arrays for sorted values
        int[] sortedProfit = new int[n];
        int[] sortedDeadline = new int[n];

        for (int i = 0; i < n; i++) {
            sortedProfit[i] = profit[index[i]];
            sortedDeadline[i] = deadline[index[i]];
        }

        // Copy back to original arrays
        for (int i = 0; i < n; i++) {
            profit[i] = sortedProfit[i];
            deadline[i] = sortedDeadline[i];
        }
        
        int max1=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) max1=Integer.max(max1,deadline[i]);
        
        int maxProfit=0;
        int count=0;
        int[] arr=new int[max1+1];
        ArrayList<Integer>list=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(arr[deadline[i]]==0){
                arr[deadline[i]]=1;
                maxProfit=maxProfit+profit[i];
                count++;
            }
            else{
                int k=deadline[i];
                while(k>0 && arr[k]==1){
                    k--;
                }
                if(k!=0){
                    arr[k]=1;
                    maxProfit=maxProfit+profit[i];
                    count++;
                }
            }
        }
        list.add(count);
        list.add(maxProfit);
     return list;  
    }
}

//O(nlogn)
class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n=profit.length;
        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) index[i] = i;

        // Sort indices based on profit descending
        Arrays.sort(index, (i, j) -> profit[j] - profit[i]);

        // Create new arrays for sorted values
        int[] sortedProfit = new int[n];
        int[] sortedDeadline = new int[n];

        for (int i = 0; i < n; i++) {
            sortedProfit[i] = profit[index[i]];
            sortedDeadline[i] = deadline[index[i]];
        }

        // Copy back to original arrays
        for (int i = 0; i < n; i++) {
            profit[i] = sortedProfit[i];
            deadline[i] = sortedDeadline[i];
        }
        
        int max1=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) max1=Integer.max(max1,deadline[i]);
        
        int maxProfit=0;
        int count=0;
        int[] parent=new int[max1+1];
        for(int i=0;i<parent.length;i++) parent[i]=i;
        ArrayList<Integer>list=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int slot=find(deadline[i],parent);
            if(slot>0){
                maxProfit=maxProfit+profit[i];
                count++;
                parent[slot]=slot-1;
            }
        }
        list.add(count);
        list.add(maxProfit);
     return list;  
    }
    
    int find(int deadline,int[] parent){
        if(parent[deadline]==deadline) return deadline;
        
        return parent[deadline]=find(parent[deadline],parent);
    }
}

