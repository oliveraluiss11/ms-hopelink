package com.jayway.mshopelink.modules.donation.application;

import com.jayway.mshopelink.commons.DomainEvent;
import com.jayway.mshopelink.commons.DomainEventPublisher;
import com.jayway.mshopelink.modules.donation.domain.aggregateroute.Donation;
import com.jayway.mshopelink.modules.donation.domain.dto.RegisterDonationRequest;
import com.jayway.mshopelink.modules.donation.domain.events.RegisteredDonationEvent;
import com.jayway.mshopelink.modules.donation.domain.repository.DonationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class RegisterDonationTest {

    private DomainEventPublisher domainEventPublisher;
    private DonationRepository donationRepository;

    @BeforeEach
    void setUp() {
        this.domainEventPublisher = mock(DomainEventPublisher.class);
        this.donationRepository = mock(DonationRepository.class);
    }

    @Test
    void registerWhenDonorIsAnonymous() {
        var donationRepositorySpy = spy(donationRepository);
        donationRepositorySpy.save(Donation.create(BigDecimal.valueOf(1L), BigDecimal.valueOf(1L), null));

        var domainEventPublisherSpy = spy(domainEventPublisher);
        domainEventPublisherSpy.publish(new LinkedList<>());

        RegisterDonation registerDonation = new RegisterDonation(domainEventPublisher, donationRepository);
        registerDonation.register(RegisterDonationRequest
                .builder()
                        .amountDonation(BigDecimal.ONE)
                        .contributionPercentage(BigDecimal.TWO)
                .build());

        verify(donationRepositorySpy,
                times(1)
        ).save(any());

        verify(domainEventPublisherSpy,
                times(1)
        ).publish(anyList());
    }

}