package com.example.demo;

import java.util.Locale;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Utility class for string manipulation operations.
 * Provides methods for common string transformations and checks.
 */
public class StringUtils {
    
    public String reverse(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }
    
    /**
     * Checks if a string is a palindrome (ignoring case and non-alphanumeric characters).
     * @param input the input string
     * @return true if the string is a palindrome, false otherwise
     */
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ROOT);
        return cleaned.equals(reverse(cleaned));
    }
    
    public int countVowels(String input) {
        if (input == null) {
            return 0;
        }
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : input.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
    
    public String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase(Locale.ROOT) + input.substring(1).toLowerCase(Locale.ROOT);
    }
    
    /**
     * Removes all whitespace from a string.
     * @param input the input string
     * @return the string with all whitespace removed
     */
    public String removeWhitespace(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("\\s+", "");
    }
    
    /**
     * Checks if a string contains only digits.
     * @param input the input string
     * @return true if the string contains only digits, false otherwise
     */
    public boolean isNumeric(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        return input.matches("\\d+");
    }
    
    /**
     * Repeats a string n times.
     * @param input the string to repeat
     * @param times the number of times to repeat
     * @return the repeated string
     * @throws IllegalArgumentException if times is negative
     */
    public String repeat(String input, int times) {
        if (input == null) {
            return null;
        }
        if (times < 0) {
            throw new IllegalArgumentException("Repeat times cannot be negative");
        }
        if (times == 0 || input.isEmpty()) {
            return "";
        }
        return input.repeat(times);
    }
    
    /**
     * Truncates a string to a maximum length and adds ellipsis if truncated.
     * @param input the input string
     * @param maxLength the maximum length
     * @return the truncated string
     */
    public String truncate(String input, int maxLength) {
        if (input == null || maxLength < 0) {
            return input;
        }
        if (input.length() <= maxLength) {
            return input;
        }
        if (maxLength <= 3) {
            return input.substring(0, maxLength);
        }
        return input.substring(0, maxLength - 3) + "...";
    }
}