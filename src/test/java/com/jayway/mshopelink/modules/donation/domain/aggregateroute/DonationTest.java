package com.jayway.mshopelink.modules.donation.domain.aggregateroute;

import com.jayway.mshopelink.modules.donation.domain.exception.AmountRequiredException;
import com.jayway.mshopelink.modules.donation.domain.exception.BusinessException;
import com.jayway.mshopelink.modules.donation.domain.exception.ContruibutionPercentageRequiredException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DonationTest {

    @Test
    void shouldNotCreateWhenAmountIsNull() {
        assertThrows(AmountRequiredException.class, () -> {
            Donation.create(null, null, null);
        });
    }

    @Test
    void shouldNotCreateWhenContributionPercentageIsNull() {
        assertThrows(ContruibutionPercentageRequiredException.class, () -> {
            Donation.create(BigDecimal.ONE, null, null);
        });
    }

    @Test
    void shouldCreateWhenDonorIsNull() {
        var donation = Donation.create(BigDecimal.ONE, BigDecimal.TWO, null);
        assertNotNull(donation);
    }

}