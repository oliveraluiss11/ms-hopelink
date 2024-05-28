package com.jayway.mshopelink.modules.donation.domain.valueobjects;

import com.jayway.mshopelink.modules.donation.domain.exception.InvalidContributionPercentageException;

import java.math.BigDecimal;
import java.util.Objects;

public record ContributionPercentage(BigDecimal value) {
    public ContributionPercentage{
        ensureNotNull(value);
        ensureValidRange(value);
    }
    private static final BigDecimal MIN_AMOUNT = BigDecimal.ZERO;
    private static final BigDecimal MAX_AMOUNT = new BigDecimal("0.30");
    private void ensureNotNull(BigDecimal value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException();
        }
    }

    private void ensureValidRange(BigDecimal value){
        if (value.compareTo(MIN_AMOUNT) < 0 || value.compareTo(MAX_AMOUNT) > 0) {
            throw new InvalidContributionPercentageException();
        }
    }
}
