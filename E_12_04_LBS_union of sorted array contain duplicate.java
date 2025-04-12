package com.swapnil;

import java.util.ArrayList;

public class UnionOfSortedArrays {
    public static void main(String[] args) {
        //consider both array contain unique elements
        int[] a={1,2,3,4,5};
        int[] b={1,2,3,6,7};
        System.out.println(union(a,b));

        //consider array does not contain unique element but they are sorted
        int[] c={1,1,1,1,4,5};
        int[] d={1,2,2,2,6,6,7,7,9,9};
        System.out.println(union2(c,d));
    }

    public static ArrayList<Integer> union(int[] a, int[] b){
        ArrayList<Integer>list=new ArrayList<>();
        int i=0,j=0;
        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                list.add(a[i]);
                i++;
                j++;
            }
            else if (a[i]<b[j]){
                list.add(a[i]);
                i++;
            }
            else {
                list.add(b[j]);
                j++;
            }
        }
        while(i<a.length){
            list.add(a[i]);
            i++;
        }
        while(j<b.length) {
            list.add(b[j]);
            j++;
        }
            return list;
    }


    public static ArrayList<Integer> union2(int[] a, int[] b) {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int last = Integer.MIN_VALUE;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (a[i] != last) {
                    result.add(a[i]);
                    last = a[i];
                }
                i++;
            } else if (a[i] > b[j]) {
                if (b[j] != last) {
                    result.add(b[j]);
                    last = b[j];
                }
                j++;
            } else { // a[i] == b[j]
                if (a[i] != last) {
                    result.add(a[i]);
                    last = a[i];
                }
                i++;
                j++;
            }
        }

        while (i < a.length) {
            if (a[i] != last) {
                result.add(a[i]);
                last = a[i];
            }
            i++;
        }

        while (j < b.length) {
            if (b[j] != last) {
                result.add(b[j]);
                last = b[j];
            }
            j++;
        }

        return result;
    }

}
