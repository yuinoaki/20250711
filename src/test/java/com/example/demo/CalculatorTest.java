package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-1, 1));
        assertEquals(-5, calculator.add(-2, -3));
    }
    
    @Test
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-2, calculator.subtract(3, 5));
        assertEquals(0, calculator.subtract(5, 5));
    }
    
    @ParameterizedTest
    @CsvSource({
        "2, 3, 6",
        "0, 5, 0",
        "-2, 3, -6",
        "-2, -3, 6"
    })
    void testMultiply(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b));
    }
    
    @Test
    void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3), 0.0001);
        assertEquals(2.5, calculator.divide(5, 2), 0.0001);
        assertEquals(-2.0, calculator.divide(-6, 3), 0.0001);
    }
    
    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(5, 0));
    }
    
    @ParameterizedTest
    @CsvSource({
        "2, true",
        "3, false",
        "0, true",
        "-2, true",
        "-3, false"
    })
    void testIsEven(int number, boolean expected) {
        assertEquals(expected, calculator.isEven(number));
    }
    
    @Test
    void testFactorial() {
        assertEquals(1, calculator.factorial(0));
        assertEquals(1, calculator.factorial(1));
        assertEquals(6, calculator.factorial(3));
        assertEquals(120, calculator.factorial(5));
    }
    
    @Test
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
    }
}