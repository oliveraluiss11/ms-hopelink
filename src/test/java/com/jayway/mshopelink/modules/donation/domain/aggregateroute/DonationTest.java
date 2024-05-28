package com.jayway.mshopelink.modules.donation.domain.aggregateroute;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DonationTest {

    @Test
    void shouldNotCreateWhenAmountIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            Donation.create(null, null, null, null);
        });
    }

    @Test
    void shouldNotCreateWhenContributionPercentageIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            Donation.create(BigDecimal.ONE, null, null, null);
        });
    }
    @Test
    void shouldNotCreateWhenCampaignIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            Donation.create(BigDecimal.ONE, BigDecimal.TWO, null, null);
        });
    }

    @Test
    void shouldNotCreateWhenDonorIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            Donation.create(BigDecimal.ONE, BigDecimal.TWO, UUID.randomUUID().toString(), null);
        });
    }

}