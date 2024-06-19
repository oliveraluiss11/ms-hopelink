package com.jayway.mshopelink.commons.valueobjects;

import java.util.Optional;

public record Age(Integer value) {
    private static final String AGE_CANNOT_BE_NULL = "Age cannot be null";
    private static final String AGE_MUST_BE_GREATER_OR_EQUALS_0 = "Age must be greater than or equal to 0";

    public Age {
        ensureIsNotNull(value);
        ensureIsGreaterThanOrEquals0(value);
    }

    private void ensureIsNotNull(Integer value) {
        Optional.ofNullable(value)
                .orElseThrow(()->new IllegalArgumentException(AGE_CANNOT_BE_NULL));
    }

    private void ensureIsGreaterThanOrEquals0(Integer value) {
        Optional.ofNullable(value)
                .filter(age -> age >= 0)
                .orElseThrow(() -> new IllegalArgumentException(AGE_MUST_BE_GREATER_OR_EQUALS_0));
    }
}
