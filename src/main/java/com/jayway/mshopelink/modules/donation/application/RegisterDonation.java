package com.jayway.mshopelink.modules.donation.application;

import com.jayway.mshopelink.modules.donation.domain.aggregateroute.Donation;
import com.jayway.mshopelink.modules.donation.domain.dto.RegisterDonationRequest;
import com.jayway.mshopelink.modules.donation.domain.events.RegisteredDonationEvent;
import com.jayway.mshopelink.modules.donation.domain.repository.DonationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
@Service
@RequiredArgsConstructor
public class RegisterDonation {
    private final ApplicationEventPublisher applicationEventPublisher;
    private final DonationRepository donationRepository;
    public void register(RegisterDonationRequest request){
        Donation donation = new Donation(request.getAmountDonation(),
                request.getContributionPercentage(),
                request.getDonor().toDomain(), LocalDateTime.now(ZoneId.systemDefault()));
        donationRepository.save(donation);
        RegisteredDonationEvent event = new RegisteredDonationEvent(this, donation);
        applicationEventPublisher.publishEvent(event);
    }
}
