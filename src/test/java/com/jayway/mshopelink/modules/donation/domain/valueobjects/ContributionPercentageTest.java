package com.jayway.mshopelink.modules.donation.domain.valueobjects;

import com.jayway.mshopelink.modules.donation.domain.exception.InvalidContributionPercentageException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContributionPercentageTest {
    @Test
    void shouldCreateWhenAmountIsZero() {
        var result = new ContributionPercentage(BigDecimal.ZERO);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(BigDecimal.ZERO, result.value());
    }

    @Test
    void shouldCreateWhenAmountIsValid() {
        var result = new ContributionPercentage(new BigDecimal("0.24"));
        Assertions.assertNotNull(result);
        Assertions.assertEquals(new BigDecimal("0.24"), result.value());
    }

    @Test
    void shouldCreateWhenAmountIs030() {
        var result = new ContributionPercentage(new BigDecimal("0.30"));
        Assertions.assertNotNull(result);
        Assertions.assertEquals(new BigDecimal("0.30"), result.value());
    }

    @Test
    void shouldNotCreateWhenAmountIsGreaterThan030() {
        assertThrows(InvalidContributionPercentageException.class, () -> new ContributionPercentage(new BigDecimal("0.31")));
    }

    @Test
    void shouldNotCreateWhenAmountIsLessThanZero() {
        assertThrows(InvalidContributionPercentageException.class, () -> new ContributionPercentage(new BigDecimal("-0.01")));
    }

    @Test
    void shouldNotCreateWhenAmountIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new ContributionPercentage(null));
    }
}
