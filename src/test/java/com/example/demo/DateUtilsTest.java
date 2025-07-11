package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {
    
    private DateUtils dateUtils;
    
    @BeforeEach
    void setUp() {
        dateUtils = new DateUtils();
    }
    
    @Test
    void testFormatDate() {
        LocalDate date = LocalDate.of(2025, 7, 11);
        assertEquals("2025-07-11", dateUtils.formatDate(date));
    }
    
    @Test
    void testFormatDateNull() {
        assertNull(dateUtils.formatDate(null));
    }
    
    @Test
    void testFormatDateWithPattern() {
        LocalDate date = LocalDate.of(2025, 7, 11);
        assertEquals("11/07/2025", dateUtils.formatDate(date, "dd/MM/yyyy"));
    }
    
    @Test
    void testFormatDateTime() {
        LocalDateTime dateTime = LocalDateTime.of(2025, 7, 11, 15, 30, 45);
        assertEquals("2025-07-11 15:30:45", dateUtils.formatDateTime(dateTime));
    }
    
    @Test
    void testDaysBetween() {
        LocalDate start = LocalDate.of(2025, 7, 1);
        LocalDate end = LocalDate.of(2025, 7, 11);
        assertEquals(10, dateUtils.daysBetween(start, end));
    }
    
    @Test
    void testIsWeekend() {
        LocalDate saturday = LocalDate.of(2025, 7, 12);
        LocalDate sunday = LocalDate.of(2025, 7, 13);
        LocalDate monday = LocalDate.of(2025, 7, 14);
        
        assertTrue(dateUtils.isWeekend(saturday));
        assertTrue(dateUtils.isWeekend(sunday));
        assertFalse(dateUtils.isWeekend(monday));
    }
    
    @Test
    void testAddBusinessDays() {
        LocalDate friday = LocalDate.of(2025, 7, 11);
        LocalDate result = dateUtils.addBusinessDays(friday, 1);
        assertEquals(LocalDate.of(2025, 7, 14), result); // Monday
    }
}