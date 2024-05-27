package com.jayway.mshopelink.modules.donation.domain.dto;

import com.jayway.mshopelink.modules.donation.domain.aggregateroute.Donor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class RegisterDonor {
    private String firstName;
    private String lastName;
    private String email;
    private String documentNumber;
    private Boolean anonymous;
    private Boolean subscriptionConsent;

    public Donor toDomain(){
        return Donor.create(firstName,lastName,documentNumber,email,anonymous,subscriptionConsent);
    }
}
