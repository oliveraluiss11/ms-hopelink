package com.jayway.mshopelink.commons.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeTest {
    @Test
    public void shouldThrowExceptionWhenAgeIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Age(null));
        assertEquals("Age cannot be null", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenAgeIsNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Age(-1));
        assertEquals("Age must be greater than or equal to 0", exception.getMessage());
    }

    @Test
    public void shouldCreateAgeWhenValueIsZero() {
        assertDoesNotThrow(() -> {
            new Age(0);
        });
    }

    @Test
    public void shouldCreateAgeWhenValueIsPositive() {
        assertDoesNotThrow(() -> {
            new Age(25);
        });
    }
}