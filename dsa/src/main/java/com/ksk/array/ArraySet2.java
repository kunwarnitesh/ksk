package com.ksk.array;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySet2 {

    public static void main(String[] args) {
        minJumpsToEnd();
        maxDifferenceBetweenHeights();
        inversionCountOfArray();
        stockBuyingWithMaxProfit();
        sumPair();
        subArrayWithZeroSum();
        factorialOfLargeNumber();
        maximumProductSubArray();
        longestConsecutiveSubSequence();

    }

    /**
     * Find the longest consecutive subsequence in an array
     */
    private static void longestConsecutiveSubSequence() {
        int[] array = {100, 4, 200, 1, 3, 2};
        int longestStreak = 0;
        Set<Integer> hasSet = new HashSet<>();
        for (int i : array) {
            hasSet.add(i);
        }

        for (int num : hasSet) {
            if (!hasSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (hasSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        System.out.println("Longest Consecutive Subsequence: " + longestStreak);

    }

    /**
     * Find the SUb Array with Maximum product
     */
    private static void maximumProductSubArray() {
        int[] nums = {6, -3, -10, 0, 2};
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);
            result = Math.max(result, maxProduct);
        }
        System.out.println("Maximum Product : " + result);
    }

    private static void factorialOfLargeNumber() {
        System.out.println("Factorial of 5 " + factorialOfN(5));
        int num = 5;
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        System.out.println("Factorial Result : " + fact);

    }

    private static int factorialOfN(int n) {
        if (n <= 0 || n == 1) {
            return 1;
        } else {
            return n * factorialOfN(n - 1);
        }

    }

    /***
     * Find Sub array whose sum is equal to zero
     */
    private static void subArrayWithZeroSum() {
        int[] array = {4, 2, -3, 1, 6};
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int j : array) {
            sum += j;
            if (sum == 0 || set.contains(sum)) {
                System.out.println("Sum Exist");
            }
            set.add(j);
        }

    }

    private static void sumPair() {
        int[] array = {7, 6, 4, 3, 1};
        int sum = 10;
        Arrays.sort(array);
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            if (array[low] + array[high] > sum) {
                high--;
            } else if (array[low] + array[high] < sum) {
                low++;
            } else {
                System.out.println("Sum Pair Found :" + array[low] + " and " + array[high]);
                low++;
                high--;
            }
        }

    }

    private static void stockBuyingWithMaxProfit() {
        int[] array = {7, 6, 4, 3, 1};
        int buyPrice = array[0];
        int maxProfit = 0;
        for (int i = 0; i < array.length; i++) {
            if (buyPrice > array[i]) {
                buyPrice = array[i];
            } else if (array[i] - buyPrice > maxProfit) {
                maxProfit = array[i] - buyPrice;
            }
        }

        System.out.println("Max Profit " + maxProfit);
    }

    /***
     * Get All inversion Count
     */
    private static void inversionCountOfArray() {
        int[] inversionArray = {8, 4, 2, 1};

        int count = mergeAndCount(inversionArray, 0, inversionArray.length - 1);
        System.out.println("Print Count " + count);
    }

    private static int mergeAndCount(int[] inversionArray, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count += mergeAndCount(inversionArray, low, mid);
            count += mergeAndCount(inversionArray, mid + 1, high);
            count += merge(inversionArray, low, mid, high);

        }
        return count;
    }

    private static int merge(int[] inversionArray, int low, int mid, int high) {
        int count = 0;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = Arrays.copyOfRange(inversionArray, low, mid + 1);
        int[] right = Arrays.copyOfRange(inversionArray, mid + 1, high + 1);
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                inversionArray[k++] = left[i++];
            } else {
                inversionArray[k++] = right[j++];
                count += mid - low + 1;
            }
        }
        while (i < n1) {
            inversionArray[k++] = left[i++];
        }
        while (j < n2) {
            inversionArray[k++] = right[j++];
        }
        return count;
    }

    /***
     *
     * @return
     */
    private static void minJumpsToEnd() {
        int jumps = -1;
        int[] array = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int n = array.length;
        if (n <= 1) {
            jumps = 0;
            return;
        }

        int maxReach = array[0];
        int steps = array[0];
        jumps = 1;

        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                return;
            }
            maxReach = Math.max(maxReach, i + array[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxReach) {
                    jumps = -1;
                    return;
                }
                steps = maxReach - i;
            }
        }
        System.out.println("Minnimum Jumps Required " + jumps);
    }

    /***
     *
     * @return
     */
    private static void maxDifferenceBetweenHeights() {
        int[] array = {7, 4, 8, 8, 8, 9};
        int k = 6;
        Arrays.sort(array);
        int length = array.length;
        int tempMin = array[0];
        int tempMax = array[length - 1];
        int result = tempMax - tempMin;

        for (int i = 1; i < length; i++) {
            if (array[i] - k < 0) {
                continue;
            }
            tempMin = Math.min(array[0] + k, array[i] - k);
            tempMax = Math.max(array[length - 1] - k, array[i - 1] + k);
            result = Math.min(result, tempMax - tempMin);
        }

        System.out.println("Max Difference Between Height " + result);

    }
}
