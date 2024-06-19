package com.jayway.mshopelink.commons.aggregateroute;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecipientTest {

    @Test
    public void shouldCreateRecipientWithValidValues() {
        Recipient recipient = Recipient.create("John Doe", "12345678", 30, "https://subdomain.firebaseapp.com/another-route");

        assertEquals("John Doe", recipient.getFullName());
        assertEquals("12345678", recipient.getDocumentNumber());
        assertEquals(30, recipient.getAge());
        assertEquals("https://subdomain.firebaseapp.com/another-route", recipient.getPhotoUrl());
    }

    @Test
    public void shouldThrowExceptionWhenFullNameIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Recipient.create(null, "12345678", 30, "https://subdomain.firebaseapp.com/another-route"));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenDocumentNumberIsInvalid() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Recipient.create("John Doe", "12345ABC", 30, "https://subdomain.firebaseapp.com/another-route"));
        assertEquals("Invalid document number format", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenAgeIsNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Recipient.create("John Doe", "12345678", -5, "https://subdomain.firebaseapp.com/another-route"));
        assertEquals("Age must be greater than or equal to 0", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenPhotoUrlIsNull() {
        assertThrows(IllegalArgumentException.class, () -> Recipient.create("John Doe", "12345678", 30, null));
    }

    @Test
    public void shouldThrowExceptionWhenPhotoUrlIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Recipient.create("John Doe", "12345678", 30, "invalid-url"));
    }
}
