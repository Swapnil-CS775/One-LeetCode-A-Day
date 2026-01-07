/*
Implement k stacks in an array
Difficulty: HardAccuracy: 36.3%Submissions: 1K+Points: 8
You are given two integers n and k. Your task is to implement a class kStacks that uses a single array of size n to simulate k independent stacks.
The class should support the following operations:

push(x, i) – Push element x into the i-th stack.
pop(i) – Pop the top element from the i-th stack and return it. Return -1 if it is empty.
There will be a sequence of q queries queries[][]. The queries are represented in numeric form:

1 x i: Call push(x, i)
2 i:  Call pop(i)
The driver code will process the queries, call the corresponding functions, and print the outputs of pop(i) operations.
You only need to implement the above two functions.

Examples:

Input: n = 4, k = 2, q = 5,
queries[][] = [[1, 5, 0], [1, 3, 0], [2, 0], [1, 1, 1], [2, 1]]
Output: [3, 1]
Explanation: Queries on stack are as follows:
push(5, 0): push 5 to 0-th stack
push(3, 0): push 3 to 0-th stack
pop(0): pop the top element 3 from the 0-th stack
push(1, 1): push 1 to 1-th stack
pop(1): pop the top element 1 from the 1-th stack
Input: n = 9, k = 3, q = 7,
queries[][] = [[1, 2, 0], [1, 5, 0], [1, 4, 1], [2, 1], [1, 3, 2], [2, 0], [2, 0]]
Output: [4, 5, 2]
Explanation: Queries on stack are as follows:
push(2, 0): push 2 to 0-th stack
push(5, 0): push 5 to 0-th stack
push(4, 1): push 4 to 1-th stack
pop(1): pop the top element 4 from the 1-th stack
push(3, 2): push 3 to 2-th stack
pop(0): pop the top element 5 from the 0-th stack
pop(0): pop the top element 2 from the 0-th stack
Constraints:
1 ≤ q ≤ 105
1 ≤ k ≤ n ≤ 105
0 ≤ values on the stacks ≤ 109


*/

//code - 

class kStacks {

    // main array to store elements
    private int[] arr;
    int[] top;
    int[] next;
    int free;

    public kStacks(int n, int k) {
        // initialize data structures for k stacks
        arr=new int[n];
        top=new int[k];
        next=new int[n];
        
        for(int i=0;i<k;i++){
            top[i]=-1;
        }
        
        for(int i=0;i<n-1;i++){
            next[i]=i+1;
        }
        next[n-1]=-1;
        free=0;
    }

    public void push(int x, int i) {
        // push element x into stack i
        if(free==-1) return;
        
        int insertAt=free;
        free=next[insertAt];
        
        arr[insertAt]=x;
        next[insertAt]=top[i];
        top[i]=insertAt;
    }

    public int pop(int i) {
        // pop element from stack i
        if(top[i]==-1) return -1;
        
        int topIndex=top[i];
        top[i] = next[topIndex];      

        next[topIndex] = free;
        free = topIndex;

        return arr[topIndex];
    }
}



