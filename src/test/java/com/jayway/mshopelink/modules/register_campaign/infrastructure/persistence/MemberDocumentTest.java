package com.jayway.mshopelink.modules.register_campaign.infrastructure.persistence;

import com.jayway.mshopelink.commons.aggregateroute.MemberCampaign;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberDocumentTest {
    @Test
    public void shouldCreateMemberDocumentFromMemberCampaign() {
        MemberCampaign memberCampaign = MemberCampaign.create("12345678", "John", "Doe", "https://subdomain.firebaseapp.com/another-route");
        MemberDocument memberDocument = MemberDocument.from(memberCampaign);

        assertNotNull(memberDocument);
        assertEquals("12345678", memberDocument.getMemberId());
        assertEquals("John", memberDocument.getFirstName());
        assertEquals("Doe", memberDocument.getLastName());
        assertEquals("https://subdomain.firebaseapp.com/another-route", memberDocument.getPhotoUrl());
    }

}