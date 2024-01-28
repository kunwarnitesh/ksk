package com.ksk.array;

import java.util.Arrays;

public class ArraySet3 {

    public static void main(String[] args) {

        maxStockProfitTwiceADay();
        tripletSum();
        trapMaxRainWater();
        minChocolateDifference();
        smallestSumSubArray();
        threeWayPartitioningArray();
        minOperationsToPalindrome();
    }

    /**
     * FInd min operation to find
     */
    private static void minOperationsToPalindrome() {
        int[] arr = {1,9, 4, 5, 1};
        int left=0,right = arr.length-1;
        int minCount =0;
        while (left<right){
            if (arr[left] == arr[right]){
                left++;
                right--;
            }else{
                if (arr[left]<arr[right]){
                    arr[left+1] += arr[left];
                    left++;
                    minCount++;
                }else if(arr[left]>arr[right]){
                    arr[right-1] += arr[right];
                    right--;
                    minCount++;
                }
            }
        }

        System.out.println("Min count for palindrome "+ minCount);

    }

    /**
     * Similar to
     */
    private static void threeWayPartitioningArray() {
        int[] array = {1, 2, 3, 3, 2, 1, 1, 2, 3, 2, 1};
        int lowValue = 2;
        int highValue = 2;
        int low =0, high = array.length-1, i=0;
        while (i<high){
            if (array[i]<lowValue){
                swap(array,i,low);
                i++;
                low++;
            }else if(array[i]>highValue){
                swap(array,i,high);
                high--;
            }else{
                i++;
            }
        }
        printArray(array);

    }

    private static void printArray(int[] array) {
        for (int j: array){
            System.out.println(""+j);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    /**
     * Find Smallest sum sub array
     */
    private static void smallestSumSubArray() {
        int[] array = {1, 4, 45, 6, 0, 19};
        int sum =51;
        int end =0;
        int minLength=Integer.MAX_VALUE;
        int totalSum=0;
        int start=0;
        while (end<array.length){
            totalSum += array[end];
            while (totalSum>sum){
                minLength = Math.min(minLength,end-start+1);
                totalSum -= array[start];
                start++;
            }
            end++;
        }

        System.out.println("Min Length of Sub Array: "+ minLength);


    }

    /**
     * Distribute chocolate among children with min difference
     */
    private static void minChocolateDifference() {
        int[] chocolates = {3, 4, 1, 9, 56, 7, 9, 12};
        Arrays.sort(chocolates);
        int k = 5;
        int n = chocolates.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - k; i++) {
            int minDifference = chocolates[i + k - 1] - chocolates[i];
            min = Math.min(min, minDifference);
        }

        System.out.println("Chocolates Min difference : " + min);
    }

    private static void trapMaxRainWater() {
        int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int length = array.length;
        int left = 0, right = length - 1;
        int leftMax = 0, rightMax = 0;
        int maxRainWater = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, array[left]);
            rightMax = Math.max(rightMax, array[right]);
            if (leftMax < rightMax) {
                maxRainWater += leftMax - array[left];
                left++;
            } else {
                maxRainWater += rightMax - array[right];
                right--;
            }
        }

        System.out.println("Max Rain water: " + maxRainWater);
    }

    private static void tripletSum() {
        int[] array = {12, 3, 4, 1, 6, 9};
        Arrays.sort(array);
        int n = array.length;
        int sum = 24;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == sum) {
                    System.out.println("Found Triplet Sum: " + array[i] + " " + array[left] + " " + array[right]);
                    return;
                } else if (currentSum < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    private static void maxStockProfitTwiceADay() {

    }

}
