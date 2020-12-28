package com.mashibing.juc.c_000;

import java.util.Arrays;
////
public class tt {

    public static void main(String[] args){
        int[] arr = {2,4,5,7,1,6,8,3};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length - 1,temp);
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (left + right) /2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid + 1,right,temp);
            merge(arr,left,mid,right,temp);
        }

    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= right ){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else{
                temp[t] =  arr[j];
                t += 1;
                j += 1;
            }
        }
        while(i <= mid){
            temp[t] = arr[i];
            t += 1;
            i += 1;

        }
        while(j <= right){
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        t = 0;
        int template = left;
        while(template <= right){
            arr[template] = temp[t];
            t += 1;
            template +=  1;
        }
    }
}
