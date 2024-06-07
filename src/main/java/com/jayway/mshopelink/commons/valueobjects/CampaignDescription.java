package com.jayway.mshopelink.commons.valueobjects;

import java.util.Optional;

public record CampaignDescription(String value) {
    private static final String DESCRIPTION_CANNOT_BE_NULL = "Description cannot be null";

    public CampaignDescription {
        ensureIsNotNull(value);
    }

    private void ensureIsNotNull(String value) {
        Optional.ofNullable(value).orElseThrow(() -> new IllegalArgumentException(DESCRIPTION_CANNOT_BE_NULL));
    }
}
