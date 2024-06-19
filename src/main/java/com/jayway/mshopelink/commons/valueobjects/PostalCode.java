package com.jayway.mshopelink.commons.valueobjects;

import java.util.Optional;

public record PostalCode (String value) {

    private static final String REGEX = "\\d{5}";
    private static final String ERROR_MESSAGE = "El código postal debe tener 5 dígitos numéricos.";

    public PostalCode{
        ensurePostalCodeIsValid(value);
    }
    private void ensurePostalCodeIsValid(String postalCode) {
        Optional.ofNullable(postalCode).filter(value -> value.matches(REGEX))
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE));
    }
}
