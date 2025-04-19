//code 

package com.swapnil;

import java.util.ArrayList;
import java.util.Arrays;

public class G_N_MeetingsInOneRoom {
    public static void main(String[] args) {
        int[] S={1,3,0,5,8,5};
        int[] F={2,4,6,7,9,9};

        for(int i=0;i<F.length-1;i++){
            for(int j=0;j<F.length-i-1;j++){
                if(F[j]>F[j+1]){
                    int temp=F[j];
                    F[j]=F[j+1];
                    F[j+1]=temp;
                    temp=S[j];
                    S[j]=S[j+1];
                    S[j+1]=temp;
                }
            }
        }

        System.out.println(Arrays.toString(S));
        System.out.println(Arrays.toString(F));
        System.out.println(meetings(S,F));
    }

    static ArrayList<Integer> meetings(int[] S,int[] F){
        ArrayList<Integer>list=new ArrayList<>();
        if(S.length==1){
            list.add(S[0]);
            list.add(F[0]);
            return list;
        }

        int endTime=F[0];
        list.add(S[0]);
        list.add(F[0]);
        int j=0;
        for(int i=1;i<S.length;i++){
            if(F[j]<S[i]){
                list.add(S[i]);
                list.add(F[i]);
                j++;
            }
        }

        return list;
    }
}
