package com.jayway.mshopelink.commons.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampaignDescriptionTest {
    @Test
    public void shouldThrowExceptionWhenDescriptionIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new CampaignDescription(null));
        assertEquals("Description cannot be null", exception.getMessage());
    }

    @Test
    public void shouldCreateCampaignDescriptionWhenValueIsNotNull() {
        assertDoesNotThrow(() -> {
            new CampaignDescription("This is a valid campaign description");
        });
    }

}