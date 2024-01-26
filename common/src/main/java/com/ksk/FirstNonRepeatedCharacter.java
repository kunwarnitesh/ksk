package com.ksk;

public class FirstNonRepeatedCharacter {

    public static void main(String[] args) {
        String input = "programming";

        char firstNonRepeated = findFirstNonRepeatedCharacter(input);

        if (firstNonRepeated != '\0') {
            System.out.println("The first non-repeated character is: " + firstNonRepeated);
        } else {
            System.out.println("No non-repeated character found");
        }
    }

    static char findFirstNonRepeatedCharacter(String str) {
        int[] charCount = new int[256]; // Assuming ASCII characters

        // Count the frequency of each character in the string
        for (char ch : str.toCharArray()) {
            charCount[ch]++;
        }

        // Find the first non-repeated character
        for (char ch : str.toCharArray()) {
            if (charCount[ch]> 1) {
                return ch;
            }
        }

        // If no non-repeated character is found, return a special character (you can modify as needed)
        return '\0';
    }
}
