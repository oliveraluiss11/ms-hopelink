package com.jayway.mshopelink.modules.donation.domain.events;

import com.jayway.mshopelink.modules.donation.domain.aggregateroute.Donation;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class RegisteredDonationEvent extends ApplicationEvent {
    private final Donation donation;
    public RegisteredDonationEvent(Object source, Donation donation) {
        super(source);
        this.donation = donation;
    }

}
