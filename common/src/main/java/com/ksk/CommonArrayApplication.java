package com.ksk;

import java.util.*;

public class CommonArrayApplication {
    public static void main(String[] args) {

     int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
//     array = reverseArray(array);
//
//     print(array);

        System.out.println(""+largestContiguousSum(array));
    }

    private static void print(int[] array) {

        for (int i=0;i<array.length;i++){
            System.out.println(""+array[i]);
        }
    }

    private static int[] sortArray(int[] array) {
        int size = array.length;
        for (int i=0;i<size-1;i++){
            for (int j=0;j<size-i-1;j++){
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] =temp;
                }
            }
        }

        return array;
    }

    private static int[] reverseArray(int[] array) {
        int i=0;
        int j = array.length-1;
        while (i<j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }


        return array;
    }

    private static int kthSmallestElement(int[] array, int k) {
        int low=Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i=0;i< array.length; i++){
            low = Math.min(low,array[i]);
            high = Math.max(high, array[i]);
        }
        while (low<high){
            int mid = low +(high-low)/2;
            if (count(array,mid)<k){
                low =mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    private static int count(int[] array, int mid) {
        int count = 0;
        for(int i =0 ;i<array.length;i++){
            if (array[i]<mid){
                count++;
            }
        }
        return count;
    }

    private static int kthLargestElement(int[] array, int k) {
        int low=Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int j : array) {
            low = Math.min(low, j);
            high = Math.max(high, j);
        }
        while (low<high){
            int mid = low +(high-low)/2;
            if (countGreater(array,mid)<k){
                high =mid;
            }else{
                low = mid+1;
            }
        }
        return high;
    }

    private static int countGreater(int[] array, int mid) {
        int count = 0;
        for(int i =0 ;i<array.length;i++){
            if (array[i]>mid){
                count++;
            }
        }
        return count;
    }


    private static List<Integer> kthFrequentElement(int k){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(7);
        list.add(8);
        list.add(8);
        list.add(8);
        list.add(8);
        list.add(8);
        list.add(8);
        list.add(8);
        list.add(8);
        list.add(8);

        Map<Integer,Integer> map = new HashMap<>();
        for (Integer item: list){
            map.put(item,map.getOrDefault(item,0)+1);
        }

        HashMap<Integer,
                ArrayList<Integer>> occu = new HashMap<Integer,
                ArrayList<Integer>>();


        for(Map.Entry<Integer, Integer> mapEntrySet : map.entrySet()){
            if (!occu.containsKey(mapEntrySet.getValue())){
                occu.put(mapEntrySet.getValue(),new ArrayList<>());
                occu.get(mapEntrySet.getValue()).add(mapEntrySet.getKey());
            }else{
                occu.get(mapEntrySet.getValue()).add(mapEntrySet.getKey());
            }
        }

        k= occu.size()-k;

        for (Map.Entry<Integer, ArrayList<Integer>>  x : occu.entrySet()){
            if (k==0){
                return x.getValue();
            }
            k--;
        }

        return new ArrayList<>();

    }

    private static int largestContiguousSum(int[] array){
        int max_so_far = Integer.MIN_VALUE;
        int max_end_here = 0;
        int start=0, end=0,s=0;
        for (int i=0;i< array.length;i++){
            max_end_here = max_end_here+ array[i];
            if (max_so_far<max_end_here){
                max_so_far =max_end_here;
                start=s;
                end =i;
            }
            if(max_end_here<0){
                max_end_here=0;
                s=i+1;
            }
        }
        return max_so_far;
    }
}