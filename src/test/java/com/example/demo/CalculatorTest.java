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
    
    @Test
    void testFactorialOverflow() {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(13));
    }
    
    @Test
    void testAddVarargs() {
        assertEquals(10, calculator.add(1, 2, 3, 4));
        assertEquals(15, calculator.add(1, 2, 3, 4, 5));
        assertEquals(0, calculator.add());
        assertEquals(5, calculator.add(5));
    }
    
    @Test
    void testPower() {
        assertEquals(8.0, calculator.power(2, 3), 0.0001);
        assertEquals(1.0, calculator.power(5, 0), 0.0001);
        assertEquals(16.0, calculator.power(4, 2), 0.0001);
        assertEquals(27.0, calculator.power(3, 3), 0.0001);
    }
    
    @Test
    void testPowerNegativeExponent() {
        assertThrows(IllegalArgumentException.class, () -> calculator.power(2, -1));
    }
    
    @Test
    void testGcd() {
        assertEquals(6, calculator.gcd(12, 18));
        assertEquals(1, calculator.gcd(7, 13));
        assertEquals(5, calculator.gcd(15, 25));
        assertEquals(12, calculator.gcd(-12, 24));
    }
    
    @Test
    void testLcm() {
        assertEquals(36, calculator.lcm(12, 18));
        assertEquals(91, calculator.lcm(7, 13));
        assertEquals(0, calculator.lcm(0, 5));
        assertEquals(12, calculator.lcm(4, 6));
    }
}