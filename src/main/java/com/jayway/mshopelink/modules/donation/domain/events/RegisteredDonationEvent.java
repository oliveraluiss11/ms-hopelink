package com.jayway.mshopelink.modules.donation.domain.events;

import com.jayway.mshopelink.commons.DomainEvent;
import com.jayway.mshopelink.modules.donation.domain.aggregateroute.Donation;
import lombok.Getter;

@Getter
public class RegisteredDonationEvent extends DomainEvent {

    private final Donation donation;

    public RegisteredDonationEvent(Donation donation) {
        this.donation = donation;
    }

}
