//Move All Negative Elements To One Side Of The Array

//soln-->
package com.swapnil;

import java.util.Arrays;

public class A_MovePositiveAndNegativeAtDifferentSide {
    public static void main(String[] args) {
        int[] arr={-12,11,-13,-5,6,-7,5,-3,-6};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void solution(int[] arr){
        int s=0,e=arr.length-1;
        while(s<=e){
            if(arr[s]>0){
                int temp=arr[e];
                arr[e]=arr[s];
                arr[s]=temp;
                e--;
            }
            else {
                s++;
            }
        }
    }
}
