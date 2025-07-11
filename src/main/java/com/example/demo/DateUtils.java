package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateUtils {
    
    private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public String formatDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(DEFAULT_DATE_FORMATTER);
    }
    
    public String formatDate(LocalDate date, String pattern) {
        if (date == null || pattern == null) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ROOT);
            return date.format(formatter);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
    
    public String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(DEFAULT_DATETIME_FORMATTER);
    }
    
    public long daysBetween(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
    
    public boolean isWeekend(LocalDate date) {
        if (date == null) {
            return false;
        }
        int dayOfWeek = date.getDayOfWeek().getValue();
        return dayOfWeek == 6 || dayOfWeek == 7;
    }
    
    public LocalDate addBusinessDays(LocalDate date, int daysToAdd) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        
        LocalDate result = date;
        int addedDays = 0;
        int increment = daysToAdd > 0 ? 1 : -1;
        
        while (addedDays != daysToAdd) {
            result = result.plusDays(increment);
            if (!isWeekend(result)) {
                addedDays += increment;
            }
        }
        
        return result;
    }
}