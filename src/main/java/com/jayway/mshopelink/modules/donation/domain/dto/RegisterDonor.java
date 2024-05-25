package com.jayway.mshopelink.modules.donation.domain.dto;

import com.jayway.mshopelink.modules.donation.domain.aggregateroute.Donor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RegisterDonor {
    private String firstName;
    private String lastName;
    private String email;
    private String documentNumber;
    private Boolean anonymous;
    private Boolean subscriptionConsent;

    public Donor toDomain(){
        return new Donor(firstName,lastName,documentNumber,email,anonymous,subscriptionConsent);
    }
}
