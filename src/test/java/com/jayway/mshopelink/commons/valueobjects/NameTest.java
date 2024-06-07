package com.jayway.mshopelink.commons.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameTest {

    @Test
    public void shouldThrowExceptionWhenNameIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Name(null));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenNameIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Name(""));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenNameIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Name("   "));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenNameContainsSpecialChars() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Name("John@Doe"));
        assertEquals("Name cannot contain special characters or invalid characters", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Name("Jane#Doe"));
        assertEquals("Name cannot contain special characters or invalid characters", exception.getMessage());
    }

    @Test
    public void shouldCreateNameWhenValueIsValid() {
        assertDoesNotThrow(() -> {
            new Name("John Doe");
            new Name("Jane-Doe");
            new Name("O'Connor");
        });
    }
}
