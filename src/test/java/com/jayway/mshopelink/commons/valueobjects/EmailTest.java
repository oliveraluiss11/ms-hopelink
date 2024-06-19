package com.jayway.mshopelink.commons.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
    @Test
    public void shouldThrowExceptionWhenEmailIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertEquals("Email cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenEmailIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertEquals("Email cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenEmailFormatIsInvalid() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Email("invalid-email"));
        assertEquals("Invalid email format", exception.getMessage());
    }
    @Test
    public void shouldThrowExceptionWhenEmailDomainIsInvalid() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Email("test@example.com"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    public void shouldCreateEmailWhenEmailFormatIsValid() {
        assertDoesNotThrow(() -> {
            new Email("test@gmail.com");
            new Email("test@hotmail.com");
            new Email("test@outlook.com");
            new Email("test@gmail.es");
            new Email("test@hotmail.es");
            new Email("test@outlook.es");
            new Email("test@gmail.org");
            new Email("test@hotmail.org");
            new Email("test@outlook.org");
        });
    }
}