package com.jayway.mshopelink.commons.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentNumberTest {
    @Test
    public void shouldThrowExceptionWhenDocumentNumberFormatIsInvalid() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new DocumentNumber("12345ABC"));
        assertEquals("Invalid document number format", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new DocumentNumber("1234567890123"));
        assertEquals("Invalid document number format", exception.getMessage());
    }

    @Test
    public void shouldCreateDocumentNumberWhenFormatIsValid() {
        assertDoesNotThrow(() -> {
            new DocumentNumber("12345678");   // DNI
            new DocumentNumber("10123456789"); // RUC10
            new DocumentNumber("20123456789"); // RUC20
        });
    }
}