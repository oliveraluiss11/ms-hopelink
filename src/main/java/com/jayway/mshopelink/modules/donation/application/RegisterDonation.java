package com.jayway.mshopelink.modules.donation.application;

import com.jayway.mshopelink.commons.DomainEventPublisher;
import com.jayway.mshopelink.modules.donation.domain.aggregateroute.Donation;
import com.jayway.mshopelink.modules.donation.domain.dto.RegisterDonationRequest;
import com.jayway.mshopelink.modules.donation.domain.events.RegisteredDonationEvent;
import com.jayway.mshopelink.modules.donation.domain.repository.DonationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterDonation {

    private final DomainEventPublisher domainEventPublisher;
    private final DonationRepository donationRepository;

    public void register(RegisterDonationRequest request) {
        Donation donation = Donation.create(
                request.getAmountDonation(),
                request.getContributionPercentage(),
                request.getDonor().toDomain()
        );

        donationRepository.save(donation);
        RegisteredDonationEvent event = new RegisteredDonationEvent(donation);
        domainEventPublisher.publish(event);
    }

}
