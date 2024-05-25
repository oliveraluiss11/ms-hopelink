package com.jayway.mshopelink.modules.donation.domain.valueobjects;

import java.util.Objects;

public record DocumentNumber(String value) {
    private static final String DOCUMENT_NUMBER_CANNOT_BE_NULL_OR_EMPTY = "Document number cannot be null or empty";
    private static final String INVALID_DOCUMENT_NUMBER_FORMAT = "Invalid document number format";

    public DocumentNumber {
        ensureNotEmptyOrNull(value);
        ensureValidDocumentNumber(value);
    }

    private void ensureNotEmptyOrNull(String value) {
        if (Objects.isNull(value) || value.trim().isEmpty()) {
            throw new IllegalArgumentException(DOCUMENT_NUMBER_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    private void ensureValidDocumentNumber(String value) {
        // Longitud válida para DNI (8 dígitos), RUC10 (11 dígitos) o RUC20 (11 dígitos)
        if (!value.matches("\\d{8}|10\\d{9}|20\\d{9}")) {
            throw new IllegalArgumentException(INVALID_DOCUMENT_NUMBER_FORMAT);
        }
    }
}
