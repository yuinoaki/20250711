package com.example.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayUtils {
    
    public int[] reverse(int[] array) {
        if (array == null) {
            return null;
        }
        
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - 1 - i];
        }
        return result;
    }
    
    public int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    public int findMin(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    
    public double average(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        long sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (double) sum / array.length;
    }
    
    public int[] removeDuplicates(int[] array) {
        if (array == null) {
            return null;
        }
        
        Set<Integer> uniqueSet = new HashSet<>();
        for (int value : array) {
            uniqueSet.add(value);
        }
        
        int[] result = new int[uniqueSet.size()];
        int index = 0;
        for (int value : uniqueSet) {
            result[index++] = value;
        }
        
        Arrays.sort(result);
        return result;
    }
    
    public boolean contains(int[] array, int target) {
        if (array == null) {
            return false;
        }
        
        for (int value : array) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
}