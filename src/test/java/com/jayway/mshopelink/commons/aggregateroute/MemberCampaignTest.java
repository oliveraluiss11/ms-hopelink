package com.jayway.mshopelink.commons.aggregateroute;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberCampaignTest {

    @Test
    public void shouldCreateMemberCampaignWithValidValues() {
        MemberCampaign member = MemberCampaign.create("12345678", "John", "Doe", "https://subdomain.firebaseapp.com/another-route");

        assertEquals("12345678", member.getOrganizerId());
        assertEquals("John", member.getFirstName());
        assertEquals("Doe", member.getLastName());
    }

    @Test
    public void shouldThrowExceptionWhenOrganizerIdIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> MemberCampaign.create(null, "John", "Doe", "https://subdomain.firebaseapp.com/another-route"));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenOrganizerIdIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> MemberCampaign.create("", "John", "Doe", "https://subdomain.firebaseapp.com/another-route"));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenFirstNameIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> MemberCampaign.create("12345678", null, "Doe", "https://subdomain.firebaseapp.com/another-route"));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenFirstNameIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> MemberCampaign.create("12345678", "", "Doe", "https://subdomain.firebaseapp.com/another-route"));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenLastNameIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> MemberCampaign.create("12345678", "John", null, "https://subdomain.firebaseapp.com/another-route"));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenLastNameIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> MemberCampaign.create("12345678", "John", "", "https://subdomain.firebaseapp.com/another-route"));
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }
}
