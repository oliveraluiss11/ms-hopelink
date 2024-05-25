package com.jayway.mshopelink.modules.donation.infrastructure.persistence;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DonorDocument {
    private String firstName;
    private String lastName;
    private String email;
    private String documentNumber;
    private Boolean anonymous;
    private Boolean subscriptionConsent;
}
