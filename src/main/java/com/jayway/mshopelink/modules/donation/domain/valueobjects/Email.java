package com.jayway.mshopelink.modules.donation.domain.valueobjects;

import java.util.Objects;

public record Email(String value) {
    private static final String EMAIL_CANNOT_BE_NULL_OR_EMPTY = "Email cannot be null or empty";
    private static final String INVALID_EMAIL_FORMAT = "Invalid email format";

    public Email {
        ensureNotEmptyOrNull(value);
        ensureValidEmailFormat(value);
    }

    private void ensureNotEmptyOrNull(String value) {
        if (Objects.isNull(value) || value.trim().isEmpty()) {
            throw new IllegalArgumentException(EMAIL_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    private void ensureValidEmailFormat(String value) {
        if (!value.matches("^[a-zA-Z0-9._%+-]+@(gmail|hotmail|outlook)\\.(com|es|org)$")) {
            throw new IllegalArgumentException(INVALID_EMAIL_FORMAT);
        }
    }
}
