package com.jayway.mshopelink.commons.valueobjects;

import java.util.Objects;


public record Name(String value) {
    private static final String NAME_CANNOT_BE_NULL_OR_EMPTY = "Name cannot be null or empty";
    private static final String NAME_CANNOT_CONTAIN_SPECIAL_CHARS = "Name cannot contain special characters or invalid characters";

    public Name {
        ensureNotEmptyOrNull(value);
        ensureValidNameFormat(value);
    }

    private void ensureNotEmptyOrNull(String value) {
        if (Objects.isNull(value) || value.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    private void ensureValidNameFormat(String value) {
        if (!value.matches("[\\p{L} '-]+")) {
            throw new IllegalArgumentException(NAME_CANNOT_CONTAIN_SPECIAL_CHARS);
        }
    }
}
