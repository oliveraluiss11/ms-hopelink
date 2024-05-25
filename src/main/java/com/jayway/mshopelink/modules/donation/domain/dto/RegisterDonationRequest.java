package com.jayway.mshopelink.modules.donation.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@AllArgsConstructor
@Getter
public class RegisterDonationRequest {
    private final BigDecimal amountDonation;
    private final BigDecimal contributionPercentage;
    private final RegisterDonor donor;
}
