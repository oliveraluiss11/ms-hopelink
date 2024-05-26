package com.jayway.mshopelink.modules.donation.domain.dto;

import com.jayway.mshopelink.modules.donation.domain.aggregateroute.Donor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
@AllArgsConstructor
@Builder
public class RegisterDonationRequest {

    @Getter
    private final BigDecimal amountDonation;
    @Getter
    private final BigDecimal contributionPercentage;

    private final RegisterDonor donor;

    public Donor getDonor() {
        if (this.donor == null) {
            return null;
        }
        return this.donor.toDomain();
    }

}
