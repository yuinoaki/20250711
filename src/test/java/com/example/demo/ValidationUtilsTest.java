package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {
    
    private ValidationUtils validationUtils;
    
    @BeforeEach
    void setUp() {
        validationUtils = new ValidationUtils();
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        "test@example.com",
        "user.name@domain.co.jp",
        "test123@test-domain.com"
    })
    void testValidEmails(String email) {
        assertTrue(validationUtils.isValidEmail(email));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        "invalid-email",
        "@example.com",
        "test@",
        "test@.com",
        ""
    })
    void testInvalidEmails(String email) {
        assertFalse(validationUtils.isValidEmail(email));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        "+1-234-567-8900",
        "1234567890",
        "+81 90 1234 5678",
        "(123) 456-7890"
    })
    void testValidPhoneNumbers(String phone) {
        assertTrue(validationUtils.isValidPhoneNumber(phone));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        "https://example.com",
        "http://test.com/path",
        "ftp://files.example.com"
    })
    void testValidURLs(String url) {
        assertTrue(validationUtils.isValidURL(url));
    }
    
    @Test
    void testValidPassword() {
        assertTrue(validationUtils.isValidPassword("Test123!"));
        assertTrue(validationUtils.isValidPassword("P@ssw0rd"));
    }
    
    @Test
    void testInvalidPassword() {
        assertFalse(validationUtils.isValidPassword("test"));
        assertFalse(validationUtils.isValidPassword("test1234"));
        assertFalse(validationUtils.isValidPassword("Test1234"));
        assertFalse(validationUtils.isValidPassword(null));
    }
    
    @Test
    void testValidCreditCard() {
        // Test with valid Visa number
        assertTrue(validationUtils.isValidCreditCard("4532015112830366"));
        // Test with spaces
        assertTrue(validationUtils.isValidCreditCard("4532 0151 1283 0366"));
    }
    
    @Test
    void testInvalidCreditCard() {
        assertFalse(validationUtils.isValidCreditCard("1234567890123456"));
        assertFalse(validationUtils.isValidCreditCard("123"));
        assertFalse(validationUtils.isValidCreditCard(null));
    }
}