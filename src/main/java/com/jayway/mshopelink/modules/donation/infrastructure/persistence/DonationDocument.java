package com.jayway.mshopelink.modules.donation.infrastructure.persistence;

import com.jayway.mshopelink.modules.donation.domain.aggregateroute.Donation;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Document(collection = "donations")
public class DonationDocument {
    @Id
    private String donationId;
    private BigDecimal amountDonation;
    private BigDecimal contributionPercentage;
    private BigDecimal contributionAmount;
    private BigDecimal totalDonation;
    private DonorDocument donor;
    private LocalDateTime registrationDate;

    public static DonationDocument from(Donation donation) {
        var donor = DonorDocument
                .builder()
                .documentNumber(donation.getDocumentNumber())
                .anonymous(donation.isAnonymous())
                .subscriptionConsent(donation.isSubscriptionConsent())
                .firstName(donation.getFirstName())
                .lastName(donation.getLastName())
                .email(donation.getEmail())
                .build();
        return DonationDocument
                .builder()
                .amountDonation(donation.getAmountDonation())
                .contributionPercentage(donation.getContributionPercentage())
                .contributionAmount(donation.getContributionAmount())
                .totalDonation(donation.getTotalDonation())
                .donor(donor)
                .build();
    }
}
