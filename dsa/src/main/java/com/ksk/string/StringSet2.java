package com.ksk.string;

import java.util.HashSet;
import java.util.Set;

public class StringSet2 {

    public static void main(String[] args) {
        justifyText();
        editDistanceBetweenString();
        nextPermutation();
        wordBreak();
        longestPrefixSuffix();

    }

    private static void longestPrefixSuffix() {

        String str = "abab";
        int n =1, m = str.length();
        int length = 0;
        int[] lps = new int[m];
        lps[0] = 0;

        while (n<m){
          if (str.charAt(n) == str.charAt(length)){
              length++;
              lps[n] = length;
              n++;
          }else {
              if (length != 0) {
                  lps[n] = lps[length - 1];
              } else {
                  lps[n] = 0;
                  n++;
              }
          }

        }
        for (int value : lps) {
            System.out.print(value + " ");
        }
    }

    public static void wordBreak() {

        String A = "leetcode";
        Set<String> dictionary = new HashSet<>();
        dictionary.add("leet");
        dictionary.add("code");

        int n = A.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // An empty string can always be segmented

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dictionary.contains(A.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        int result = dp[n] ? 1 : 0;
        System.out.println("Can be segmented: " + result);
    }


    public static void nextPermutation() {
        int[] nums = {1, 2, 3, 6, 4, 5};

        // Step 1: Find the first decreasing element
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: Find the smallest element to the right of nums[i] and greater than nums[i]
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: Reverse the sublist to the right of nums[i]
        reverse(nums, i + 1, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    /**
     * This method is used to Edit Distance between Strings
     */
    private static void editDistanceBetweenString() {
        String s1 = "geek", s2 = "gesek";
        int m = s1.length();
        int n= s2.length();
        int[][] dp =new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            for (int j=0;j<n+1;j++){
                if (i==0){
                    dp[i][j] = j;
                }else if (j==0){
                    dp[i][j] = i;
                }else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }

        System.out.println("Min distance for equal String : "+ dp[m][n]);
    }

    private static void justifyText() {
        int[] nums = {3, 2, 2, 5};
        int lineWidth = 6;
        int n = nums.length;

        int[][] extraSpace = new int[n][n];
        for (int i=0;i<n;i++){
            extraSpace[i][i] = lineWidth-nums[i];
            for (int j=i+1;j<n;j++){
                extraSpace[i][j] = extraSpace[i][j - 1] - nums[j] - 1;
            }
        }

        int[][] totalCost = new int[n][n];
        for (int i=0;i< n;i++){
            for (int j=i;j<n;j++){
                if (extraSpace[i][j]<0){
                    totalCost[i][j] = Integer.MAX_VALUE;
                }else if (j==n-1){
                    totalCost[i][j] = 0;
                }else{
                    totalCost[i][j] = extraSpace[i][j]* extraSpace[i][j];
                }
            }
        }

        int[] maxCost = new int[n];
        int[] lineBreak = new int[n];

        for (int i=n-1;i>=0;i--){
            maxCost[i] = totalCost[i][n-1];
            lineBreak[i] = n;
            for (int j=n-1;j>i;j--){
                if (totalCost[i][j] == Integer.MAX_VALUE){
                    continue;
                }
                if ((maxCost[i] > maxCost[j]+totalCost[i][j-1])){
                    maxCost[i] = maxCost[j]+totalCost[i][j-1];
                    lineBreak[i] = j;
                }
            }
        }

        int i = 0;
        while (i < n) {
            int j = lineBreak[i];
            for (int k = i; k < j; k++) {
                System.out.print(nums[k] + " ");
            }
            System.out.println();
            i = j;
        }
    }
}
