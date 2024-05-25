package com.jayway.mshopelink.modules.donation.domain.aggregateroute;

import com.jayway.mshopelink.modules.donation.domain.valueobjects.Amount;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

public class Donation {
    private final Amount amountDonation;
    private final Amount contributionPercentage;
    @Getter
    private final LocalDateTime registrationDate;
    private final Donor donor;

    public Donation(BigDecimal amountDonation, BigDecimal contributionPercentage, Donor donor, LocalDateTime registrationDate){
        this.amountDonation = new Amount(amountDonation);
        this.contributionPercentage = new Amount(contributionPercentage);
        this.donor = donor;
        this.registrationDate = Optional.ofNullable(registrationDate).orElse(LocalDateTime.now(ZoneId.systemDefault()));
    }
    public BigDecimal getAmountDonation(){
        return this.amountDonation.value();
    }

    public BigDecimal getContributionPercentage(){
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
    public String getFirstName(){
        return this.donor.getFirstName();
    }

    public String getLastName(){
        return this.donor.getLastName();
    }

    public String getDocumentNumber(){
        return this.donor.getDocumentNumber();
    }

    public String getEmail(){
        return this.donor.getEmail();
    }

    public Boolean isAnonymous(){
        return this.donor.isAnonymous();
    }

    public Boolean isSubscriptionConsent(){
        return this.donor.isSubscriptionConsent();
    }

}
