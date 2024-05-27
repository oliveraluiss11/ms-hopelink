package com.jayway.mshopelink.modules.donation.domain.aggregateroute;

import com.jayway.mshopelink.commons.AggregateRoot;
import com.jayway.mshopelink.modules.donation.domain.events.RegisteredDonationEvent;
import com.jayway.mshopelink.modules.donation.domain.exception.AmountRequiredException;
import com.jayway.mshopelink.modules.donation.domain.exception.ContruibutionPercentageRequiredException;
import com.jayway.mshopelink.modules.donation.domain.valueobjects.Amount;
import com.jayway.mshopelink.modules.donation.domain.valueobjects.DocumentId;
import lombok.Getter;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;
import java.util.Optional;

public class Donation extends AggregateRoot {

    private final Amount amountDonation;
    private final Amount contributionPercentage;
    @Getter
    private final LocalDateTime registrationDate;
    @Getter
    private final DocumentId campaignId;
    private final Donor donor;

    private Donation(BigDecimal amountDonation,
                     BigDecimal contributionPercentage,
                     Donor donor, String campaignId,
                     LocalDateTime registrationDate) {
        this.amountDonation = new Amount(amountDonation);
        this.contributionPercentage = new Amount(contributionPercentage);
        this.donor = donor;
        this.campaignId = new DocumentId(campaignId);
        this.registrationDate = Optional.ofNullable(registrationDate).orElse(LocalDateTime.now(ZoneId.systemDefault()));
    }

    public static Donation create(BigDecimal amountDonation, BigDecimal contributionPercentage, String campaignId, Donor donor) {
        ensureDonorIsNullOrEmpty(donor);
        var root = new Donation(
                amountDonation,
                contributionPercentage,
                donor,
                campaignId,
                LocalDateTime.now(ZoneId.systemDefault())
        );
        root.record(new RegisteredDonationEvent(root));
        return root;
    }

    private static void ensureDonorIsNullOrEmpty(Donor donor) {
        if (Objects.isNull(donor)) throw new IllegalArgumentException();
    }

    public BigDecimal getAmountDonation() {
        return this.amountDonation.value();
    }

    public BigDecimal getContributionPercentage() {
        return this.contributionPercentage.value();
    }

    public BigDecimal getContributionAmount() {
        return amountDonation.value()
                .multiply(contributionPercentage.value()).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalDonation() {
        return amountDonation.value()
                .subtract(this.getContributionAmount()).setScale(2, RoundingMode.HALF_UP);
    }

    public String getFirstName() {
        return this.donor.getFirstName();
    }

    public String getLastName() {
        return this.donor.getLastName();
    }

    public String getDocumentNumber() {
        return this.donor.getDocumentNumber();
    }

    public String getEmail() {
        return this.donor.getEmail();
    }

    public Boolean isAnonymous() {
        return this.donor.isAnonymous();
    }

    public Boolean isSubscriptionConsent() {
        return this.donor.isSubscriptionConsent();
    }
    public String getCampaignId(){
        return this.campaignId.value();
    }

}
