package com.jayway.mshopelink.commons.valueobjects;

import java.math.BigDecimal;
import java.util.Objects;

public record Amount(BigDecimal value) {
    private static final String AMOUNT_CANNOT_BE_NULL = "Amount cannot be null";
    private static final String AMOUNT_MUST_BE_NON_NEGATIVE = "Amount must be non-negative";

    public Amount {
        ensureNotNull(value);
        ensureNonNegative(value);
    }

    private void ensureNotNull(BigDecimal value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(AMOUNT_CANNOT_BE_NULL);
        }
    }

    private void ensureNonNegative(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(AMOUNT_MUST_BE_NON_NEGATIVE);
        }
    }
}
