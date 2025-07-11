package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {
    
    private ArrayUtils arrayUtils;
    
    @BeforeEach
    void setUp() {
        arrayUtils = new ArrayUtils();
    }
    
    @Test
    void testReverse() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        assertArrayEquals(expected, arrayUtils.reverse(input));
    }
    
    @Test
    void testReverseNull() {
        assertNull(arrayUtils.reverse(null));
    }
    
    @Test
    void testFindMax() {
        int[] input = {3, 7, 2, 9, 1};
        assertEquals(9, arrayUtils.findMax(input));
    }
    
    @Test
    void testFindMin() {
        int[] input = {3, 7, 2, 9, 1};
        assertEquals(1, arrayUtils.findMin(input));
    }
    
    @Test
    void testAverage() {
        int[] input = {2, 4, 6, 8, 10};
        assertEquals(6.0, arrayUtils.average(input), 0.001);
    }
    
    @Test
    void testRemoveDuplicates() {
        int[] input = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        int[] result = arrayUtils.removeDuplicates(input);
        int[] expected = {1, 2, 3, 4, 5, 6, 9};
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testContains() {
        int[] input = {1, 2, 3, 4, 5};
        assertTrue(arrayUtils.contains(input, 3));
        assertFalse(arrayUtils.contains(input, 6));
    }
    
    @Test
    void testContainsNull() {
        assertFalse(arrayUtils.contains(null, 1));
    }
}