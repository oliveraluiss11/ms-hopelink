package com.jayway.mshopelink.modules.donation.application;

import com.jayway.mshopelink.commons.DomainEventPublisher;
import com.jayway.mshopelink.modules.donation.domain.aggregateroute.Donation;
import com.jayway.mshopelink.modules.donation.domain.dto.RegisterDonationRequest;
import com.jayway.mshopelink.modules.donation.domain.dto.RegisterDonor;
import com.jayway.mshopelink.modules.donation.domain.repository.DonationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.*;

class RegisterDonationTest {

    private DomainEventPublisher domainEventPublisher;
    private DonationRepository donationRepository;

    @BeforeEach
    void setUp() {
        this.domainEventPublisher = mock(DomainEventPublisher.class);
        this.donationRepository = mock(DonationRepository.class);
    }

    @Test
    void registerTest() {
        RegisterDonation registerDonation = new RegisterDonation(domainEventPublisher, donationRepository);
        RegisterDonor registerDonor = RegisterDonor
                .builder()
                .firstName("Luis Antonio")
                .lastName("Nuñes Rivas")
                .documentNumber("77380599")
                .email("prueba@gmail.com")
                .anonymous(Boolean.FALSE)
                .subscriptionConsent(Boolean.TRUE)
                .build();
        RegisterDonationRequest registerDonationRequest = RegisterDonationRequest
                .builder()
                .campaignId(UUID.randomUUID().toString())
                .amountDonation(BigDecimal.TWO)
                .contributionPercentage(BigDecimal.ONE)
                .donor(registerDonor)
                .build();
        registerDonation.register(registerDonationRequest);

        // Verificar que el repositorio haya guardado la donación
        ArgumentCaptor<Donation> donationCaptor = ArgumentCaptor.forClass(Donation.class);
        verify(donationRepository, times(1)).save(donationCaptor.capture());
        Donation savedDonation = donationCaptor.getValue();

        Assertions.assertEquals(registerDonationRequest.getAmountDonation(), savedDonation.getAmountDonation());
        Assertions.assertEquals(registerDonationRequest.getCampaignId(), savedDonation.getCampaignId());
        Assertions.assertEquals(registerDonationRequest.getDonor().getFirstName(), savedDonation.getFirstName());

        // Verificar que se haya publicado un evento
        verify(domainEventPublisher, times(1)).publish(anyList());
    }

}