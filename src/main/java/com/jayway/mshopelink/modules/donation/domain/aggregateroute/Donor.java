package com.jayway.mshopelink.modules.donation.domain.aggregateroute;

import com.jayway.mshopelink.modules.donation.domain.valueobjects.DocumentNumber;
import com.jayway.mshopelink.modules.donation.domain.valueobjects.Email;
import com.jayway.mshopelink.modules.donation.domain.valueobjects.Name;

import java.util.Optional;

public class Donor {
    private final Name firstName;
    private final Name lastName;
    private final DocumentNumber documentNumber;
    private final Email email;
    private final Boolean anonymous;
    private final Boolean subscriptionConsent;

    public Donor(String firstName, String lastName, String documentNumber,
                 String email, Boolean isAnonymous, Boolean subscriptionConsent) {
        this.firstName = new Name(firstName);
        this.lastName = new Name(lastName);
        this.documentNumber = new DocumentNumber(documentNumber);
        this.email = new Email(email);
        this.anonymous = Optional.ofNullable(isAnonymous).orElse(Boolean.FALSE);
        this.subscriptionConsent = Optional.ofNullable(subscriptionConsent).orElse(Boolean.FALSE);
    }
    public String getFirstName() {
        return this.firstName.value();
    }

    public String getLastName() {
        return this.lastName.value();
    }

    public String getDocumentNumber() {
        return this.documentNumber.value();
    }

    public String getEmail() {
        return this.email.value();
    }

    public Boolean isAnonymous(){
        return this.anonymous;
    }

    public Boolean isSubscriptionConsent(){
        return this.subscriptionConsent;
    }
}
