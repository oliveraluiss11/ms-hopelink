package com.jayway.mshopelink.commons.valueobjects;

import java.util.Objects;

public record DocumentId (String value) {
    private static final String NAME_CANNOT_BE_NULL_OR_EMPTY = "Name cannot be null or empty";
    public DocumentId{
        ensureNotEmptyOrNull(value);
    }
    private void ensureNotEmptyOrNull(String value) {
        if (Objects.isNull(value) || value.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
    }
}
