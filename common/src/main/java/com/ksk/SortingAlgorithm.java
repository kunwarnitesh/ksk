package com.ksk;

public class SortingAlgorithm {

    public static void main(String[] args) {

        int[] array = {1,6,2,90,32,23};
        mergeSort(array,0,array.length-1);
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int i=0;i< array.length;i++){
            System.out.println(""+ array[i]);
        }
    }

    /**
     * Bubble Sort
     * @param array
     * @return
     */
    private static int[] bubbleSort(int[] array) {
        for (int i=0;i< array.length-1;i++){
            for (int j=0;j<array.length-i-1;j++){
                int temp;
                if (array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * Insertion Sort
     * @param array
     * @return
     */
    private static int[] insertionSort(int[] array) {

        int n = array.length;
        for (int i=1;i< array.length-1;i++){
            int key = array[i];
            int j = i-1;
            while (j >=0 && array[j]>key){
                array[j+1] = array[j];
                j=j-1;
            }
            array[j+1] = key;
        }
        return array;
    }

    /**
     * Selection Sort
     * @param array
     * @return
     */
    private static int[] selectionSort(int[] array) {

        int n = array.length;
        for (int i=0;i<n;i++){
            int minIndex =i;
            for (int j=i+1;j<n-1;j++){
                if (array[i]>array[j]){
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * Merge Sort
     * @param array
     * @return
     */
    private static void mergeSort(int[] array, int left, int right) {

        if (left<right){
            int mid = left+(right-left)/2;
            mergeSort(array,left,mid);
            mergeSort(array,mid+1,right);
            sort(array,left,mid,right);
        }

    }

    private static void sort(int[] array, int left, int mid, int right) {

        int n1= mid-left+1;
        int n2= right-mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0;i<n1;i++){
            L[i] = array[left+i];
        }

        for(int j=0;j<n2;j++){
            R[j] = array[mid+1+j];
        }

        int k =left;
        int i=0, j=0;

        while (i<n1 && j <n2){
            if (L[i]<R[j]){
                array[k] = L[i];
                i++;
            }else{
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i<n1){
            array[k] = L[i];
            k++;
            i++;
        }
        while (j<n2){
            array[k] = R[j];
            j++;
            k++;
        }

    }

    private static void quickSort(int[] array, int left, int right) {

        if (left<right){
            int partition = partition(array,left,right);
            quickSort(array,left,partition-1);
            quickSort(array,partition+1,right);
        }

    }

    public static int partition(int[] array, int left, int right){
        int pivot = array[right];
        int i= left-1;

        for (int j= left;j<right;j++){
            if (array[j]<pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;
        return i;
    }
}
