/*
Merge Without Extra Space
Difficulty: MediumAccuracy: 32.01%Submissions: 297K+Points: 4Average Time: 20m
Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.

Examples:

Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
Output:
2 2 3 4
7 10
Explanation: After merging the two non-decreasing arrays, we get, 2 2 3 4 7 10
Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
Output:
1 2 3 5 8 9
10 13 15 20
Explanation: After merging two sorted arrays we get 1 2 3 5 8 9 10 13 15 20.
Input: a[] = [0, 1], b[] = [2, 3]
Output:
0 1
2 3
Explanation: After merging two sorted arrays we get 0 1 2 3.
Constraints:
1 <= a.size(), b.size() <= 105
0 <= a[i], b[i] <= 107


*/

//for first approach we used extra space
class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here
        if(a[a.length-1]<=b[0]) return;
        
        int[] sorted=uCanUseExtraSpace(a,b);
        //now u need to put that elements seperately
        int k=0;
        for(int i=0;i<a.length;i++){
            a[k]=sorted[i];
            k++;
        }

        for(int i=0;i<b.length;i++){
            b[i]=sorted[k];
            k++;
        }
    }
    
    int[] uCanUseExtraSpace(int[] a,int[] b){
        int[] merged=new int[a.length+b.length];
        int i=0,j=0,k=0;

        while (i<a.length && j<b.length){
            if(a[i]<b[j]){
                merged[k]=a[i];
                i++;
            }else {
                merged[k]=b[j];
                j++;
            }
            k++;
        }

        while (i<a.length){
            merged[k]=a[i];
            k++;
            i++;
        }
        while (j<b.length){
            merged[k]=b[j];
            k++;
            j++;
        }
        return merged;
    }
}

//second approach - withoud using extra space
//but here time limit excced bcz we are adjusting second array for each value of i
public static void uCantUseExtraSpace(int[] p,int[] q){
        int i=0,j=0;
        while(i<p.length){
            if(p[i]>q[j]){
                int temp=p[i];
                p[i]=q[j];
                q[j]=temp;
                abjustQ(q);
            }
            i++;
        }
    }

    public static void abjustQ(int[] q){
        for(int i=0;i<q.length-1;i++){
            if(q[i]>q[i+1]){
                int temp=q[i];
                q[i]=q[i+1];
                q[i+1]=temp;
            }
        }
    }


//third approach - 
class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here
        uCantUseExtraSpace1(a,b);
    }
    void uCantUseExtraSpace1(int[] a,int[] b){
        int i=a.length-1;
        int j=0;
        while(i!=-1 && j!=b.length && (a[i]>b[j])){
            int temp=a[i];
            a[i]=b[j];
            b[j]=temp;
            i--;
            j++;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}



