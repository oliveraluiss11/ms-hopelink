package com.jayway.mshopelink.commons.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentIdTest {
    @Test
    public void shouldThrowExceptionWhenDocumentIdIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new DocumentId(null));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenDocumentIdIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new DocumentId(""));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenDocumentIdIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new DocumentId("   "));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldCreateDocumentIdWhenValueIsValid() {
        assertDoesNotThrow(() -> {
            new DocumentId("validDocumentId");
        });
    }
}