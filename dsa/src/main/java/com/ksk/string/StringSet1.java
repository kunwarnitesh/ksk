package com.ksk.string;

import java.util.*;

public class StringSet1 {

    public static void main(String[] args) {
        reverse();
        isPalindrome();
        findDuplicateCharInString();
        isRotation();
        countAndSay();
        longestCommonSubsequenceRecursion();
        longestCommonSubsequenceDP();
        longestPalindromicSubsequence();
        longestRepeatingSubsequence();
        findAllSubsequence();
        permutationOfString();
        splitEqualBinarySubstrings();
        splitEqualBinarySubstringsWithStack();

    }

    private static void splitEqualBinarySubstringsWithStack() {
        String s = "0100110101";
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int length = s.length();
        int count=0, start =1;
        while (start<length){
            while(start<length && !stack.empty() && stack.peek()!=s.charAt(start)){
                stack.pop();
                start++;
            }
            if(stack.empty()){
                count++;
            }
            while(start<length && (stack.empty() || stack.peek()==s.charAt(start))){
                stack.push(s.charAt(start));
                start++;
            }
        }
        if(stack.empty()){
            System.out.println("Equal Substring with Stack : "+ count);
        }else{
            System.out.println("Equal Substring with Stack Not possible");
        }

    }

    public static void splitEqualBinarySubstrings() {
        String s = "0100110101";
        int count = 0;
        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
            if (count0 == count1) {
                count++;
            }
        }
        if (count0 != count1) {
            System.out.println("Equal Binary Not possible");
        } else {
            System.out.println("Equal Binary Substring: " + count);
        }

    }

    /**
     * Find All the permutation of given string
     */
    private static void permutationOfString() {
        String str = "ABC";
        permute(str, 0, str.length());
    }

    private static void permute(String str, int index, int length) {
        if (index == length) {
            System.out.println("Permutation: " + str);
            return;
        }
        for (int i = index; i < str.length(); i++) {
            str = swap(str, index, i);
            permute(str, index + 1, length);
            str = swap(str, index, i); // Backtrack to the original state
        }
    }

    private static String swap(String str, int index, int i) {
        char[] array = str.toCharArray();
        char temp = array[index];
        array[index] = array[i];
        array[i] = temp;
        return new String(array);

    }

    private static void findAllSubsequence() {
        String str = "string";
        subsequence(str, "");
    }

    private static void subsequence(String str, String s) {
        if (str.length() == 0) {
            System.out.println(s);
            return;
        }
        subsequence(str.substring(1), s + str.charAt(0));
        subsequence(str.substring(1), s);
    }

    private static void longestPalindromicSubsequence() {
        String str = "babad";
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }

        System.out.println("Longest Palindromic Subsequence : " + str.substring(start, start + maxLength));
    }


    /**
     * Find length of longest repeating subsequence
     */
    private static void longestRepeatingSubsequence() {
        String str = "axxxzxyyyyyyyy";
        int maxCount = Integer.MIN_VALUE;
        int countSoFar = 1;
        int low = 0, high = str.length() - 1;
        while (low < high) {
            if (str.charAt(low) == str.charAt(low + 1)) {
                countSoFar++;
                maxCount = Math.max(countSoFar, maxCount);
            } else {
                countSoFar = 1;
            }
            low++;
        }

        System.out.println("Longest Repeating Subsequence Count " + maxCount);


    }

    private static void longestCommonSubsequenceDP() {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Longest Common Subsequence " + lcsDP(s1, s2, m - 1, n - 1, dp));
    }

    private static int lcsDP(String s1, String s2, int l1, int l2, int[][] dp) {
        if (l1 == 0 || l2 == 0)
            return 0;
        if (dp[l1][l2] != -1) {
            return dp[l1][l2];
        }
        if (s1.charAt(l1) == s2.charAt(l2)) {
            dp[l1][l2] = 1 + longestCommonSubsequence(s1, s2, l1 - 1, l2 - 1);
        } else {
            dp[l1][l2] = Math.max(longestCommonSubsequence(s1, s2, l1 - 1, l2), longestCommonSubsequence(s1, s2, l1, l2 - 1));
        }

        return dp[l1][l2];
    }

    /**
     * Find Longest common subsequence in 2 String
     */
    private static void longestCommonSubsequenceRecursion() {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println("Longest Common Subsequence" + longestCommonSubsequence(s1, s2, s1.length() - 1, s2.length() - 1));
    }

    private static int longestCommonSubsequence(String s1, String s2, int l1, int l2) {
        if (l1 < 0 || l2 < 0)
            return 0;
        if (s1.charAt(l1) == s2.charAt(l2)) {
            return 1 + longestCommonSubsequence(s1, s2, l1 - 1, l2 - 1);
        } else {
            return Math.max(longestCommonSubsequence(s1, s2, l1 - 1, l2), longestCommonSubsequence(s1, s2, l1, l2 - 1));
        }
    }

    /**
     * Count and Say problem
     */
    public static String countAndSay() {
        int term = 5;
        String result = "1";

        for (int i = 1; i < term; i++) {
            result = generateNext(result);
        }
        System.out.println("Term " + term + " in the Count and Say sequence: " + result);

        return result;
    }

    private static String generateNext(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                result.append(count).append(str.charAt(i));
                count = 1;
            }
        }

        return result.toString();
    }

    public static void isRotation() {
        String str1 = "waterbottle";
        String str2 = "erbottlewat";

        String concatenatedStr = str1 + str1;
        if (concatenatedStr.contains(str2)) {
            System.out.println(str2 + " is a rotation of " + str1);
        } else {
            System.out.println(str2 + " is not a rotation of " + str1);
        }
    }

    /**
     * Find all the duplicate character with frequency in String.
     */
    private static void findDuplicateCharInString() {
        String str = "geeksforgeeks";
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> set : map.entrySet()) {
            if (set.getValue() > 1) {
                System.out.println("Found Duplicate character with Frequency : " + set.getKey() + " " + set.getValue());
            }
        }

    }


    private static void isPalindrome() {

        String str = "adba";
        char[] charArray = str.toCharArray();
        int start = 0;
        int n = charArray.length - 1;

        while (start < n) {
            if (charArray[start] != charArray[n]) {
                System.out.println("String is not Palindrome " + str);
                return;

            }
            start++;
            n--;
        }

        System.out.println("String is Palindrome " + str);
    }

    /**
     * Reverse a given string
     */
    private static void reverse() {

        String str = "reverse";
        char[] charArray = str.toCharArray();
        int start = 0;
        int n = charArray.length - 1;

        while (start < n) {
            char item = charArray[start];
            charArray[start] = charArray[n];
            charArray[n] = item;
            start++;
            n--;
        }

        System.out.println("Reversed String " + new String(charArray));
    }
}
