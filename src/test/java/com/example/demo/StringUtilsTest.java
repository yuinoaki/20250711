package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    
    private StringUtils stringUtils;
    
    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }
    
    @Test
    void testReverse() {
        assertEquals("olleh", stringUtils.reverse("hello"));
        assertEquals("", stringUtils.reverse(""));
        assertNull(stringUtils.reverse(null));
        assertEquals("12345", stringUtils.reverse("54321"));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"radar", "level", "noon", "A man a plan a canal Panama"})
    void testIsPalindrome(String input) {
        assertTrue(stringUtils.isPalindrome(input));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"hello", "world", "java"})
    void testIsNotPalindrome(String input) {
        assertFalse(stringUtils.isPalindrome(input));
    }
    
    @Test
    void testIsPalindromeNull() {
        assertFalse(stringUtils.isPalindrome(null));
    }
    
    @Test
    void testCountVowels() {
        assertEquals(2, stringUtils.countVowels("hello"));
        assertEquals(5, stringUtils.countVowels("aeiou"));
        assertEquals(0, stringUtils.countVowels("xyz"));
        assertEquals(0, stringUtils.countVowels(""));
        assertEquals(0, stringUtils.countVowels(null));
        assertEquals(5, stringUtils.countVowels("AEIOU"));
    }
    
    @Test
    void testCapitalize() {
        assertEquals("Hello", stringUtils.capitalize("hello"));
        assertEquals("Hello", stringUtils.capitalize("HELLO"));
        assertEquals("H", stringUtils.capitalize("h"));
        assertEquals("", stringUtils.capitalize(""));
        assertNull(stringUtils.capitalize(null));
    }
    
    @Test
    void testRemoveWhitespace() {
        assertEquals("helloworld", stringUtils.removeWhitespace("hello world"));
        assertEquals("test", stringUtils.removeWhitespace("  test  "));
        assertEquals("", stringUtils.removeWhitespace("   "));
        assertEquals("abc123", stringUtils.removeWhitespace("a b c 1 2 3"));
        assertNull(stringUtils.removeWhitespace(null));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"123", "0", "999999"})
    void testIsNumeric(String input) {
        assertTrue(stringUtils.isNumeric(input));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"12a3", "abc", "", "12.3", "-123"})
    void testIsNotNumeric(String input) {
        assertFalse(stringUtils.isNumeric(input));
    }
    
    @Test
    void testRepeat() {
        assertEquals("abcabcabc", stringUtils.repeat("abc", 3));
        assertEquals("", stringUtils.repeat("test", 0));
        assertEquals("x", stringUtils.repeat("x", 1));
        assertNull(stringUtils.repeat(null, 5));
    }
    
    @Test
    void testRepeatNegativeTimes() {
        assertThrows(IllegalArgumentException.class, () -> stringUtils.repeat("test", -1));
    }
    
    @Test
    void testTruncate() {
        assertEquals("Hello...", stringUtils.truncate("Hello World", 8));
        assertEquals("Hello World", stringUtils.truncate("Hello World", 20));
        assertEquals("Hel", stringUtils.truncate("Hello", 3));
        assertEquals("", stringUtils.truncate("", 5));
        assertNull(stringUtils.truncate(null, 10));
    }
}