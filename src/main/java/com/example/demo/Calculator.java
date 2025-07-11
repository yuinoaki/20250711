package com.example.demo;

/**
 * A utility class for basic mathematical operations.
 * This class provides methods for arithmetic operations and mathematical functions.
 */
public class Calculator {
    
    /**
     * Adds two integers.
     * @param a the first integer
     * @param b the second integer
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Adds multiple integers.
     * @param numbers the integers to add
     * @return the sum of all numbers
     */
    public int add(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Calculates the power of a number.
     * @param base the base number
     * @param exponent the exponent (must be non-negative)
     * @return base raised to the power of exponent
     * @throws IllegalArgumentException if exponent is negative
     */
    public double power(double base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative");
        }
        if (exponent == 0) {
            return 1;
        }
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
    
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return (double) a / b;
    }
    
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n > 12) {
            throw new IllegalArgumentException("Factorial would cause integer overflow for n > 12");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Calculates the greatest common divisor (GCD) of two numbers.
     * @param a the first number
     * @param b the second number
     * @return the GCD of a and b
     */
    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    /**
     * Calculates the least common multiple (LCM) of two numbers.
     * @param a the first number
     * @param b the second number
     * @return the LCM of a and b
     */
    public int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a * b) / gcd(a, b);
    }
}