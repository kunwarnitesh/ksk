package com.ksk;

public class SortingArrayQuestions {


    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int size = arr.length;
//        sort012(arr, size);
        sortNegativeToPositive(arr);
        printArray(arr);
    }

    private static void printArray(int[] array) {
        for (int j : array) {
            System.out.println("" + j);
        }
    }

    private static void sort012(int[] arr, int size){

        int l = 0,i=0;
        int h = size-1;

        while (i<=h){
            if (arr[i] ==0){
                swap(arr, l,i);
                l++;
                i++;
            }else if (arr[i]==1){
                i++;
            } else if (arr[i]==2) {
                swap(arr, h,i);
                h--;
            }
        }

    }

    private static void sortNegativeToPositive(int[] arr){

        int l = 0;
        int h = arr.length-1;
        while (l<h){
            if (arr[l]<0 && arr[h]<0){
                l++;
            }else if( arr[l]>=0 && arr[h]>=0){
                h--;
            }else if(arr[l]>=0 && arr[h]<0){
                swap(arr,l,h);
                l++;
                h--;
            }else{
                l++;
                h--;
            }
        }

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
}
