package com.jayway.mshopelink.modules.register_campaign.infrastructure.persistence;

import com.jayway.mshopelink.commons.aggregateroute.MemberCampaign;
import com.jayway.mshopelink.commons.aggregateroute.Recipient;
import com.jayway.mshopelink.commons.valueobjects.CategoryEnum;
import com.jayway.mshopelink.commons.valueobjects.RecipientEnum;
import com.jayway.mshopelink.modules.register_campaign.domain.aggregate.Campaign;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CampaignDocumentTest {
    @Test
    public void shouldCreateCampaignDocumentFromCampaign() {
        // Crear un objeto Campaign con valores válidos
        Campaign campaign = Campaign.create("12345", new BigDecimal("1000"),
                MemberCampaign.create("98765432", "John", "Doe", "https://subdomain.firebaseapp.com/another-route"  ),
                RecipientEnum.MYSELF,
                createRecipients(),
                "Test Campaign",
                "This is a test campaign",
                CategoryEnum.EDUCATION,
                "https://subdomain.firebaseapp.com/another-route");

        // Crear un objeto CampaignDocument a partir del objeto Campaign
        CampaignDocument campaignDocument = CampaignDocument.from(campaign);

        // Verificar que el objeto CampaignDocument se creó correctamente
        assertNotNull(campaignDocument);
        assertEquals("Test Campaign", campaignDocument.getTitle());
        assertEquals("This is a test campaign", campaignDocument.getDescription());
        assertEquals("12345", campaignDocument.getPostalCode());
        assertEquals(new BigDecimal("1000"), campaignDocument.getTargetAmount());
        assertEquals("MYSELF", campaignDocument.getRecipientType());
        assertEquals("EDUCATION", campaignDocument.getCategory());
        assertEquals("https://subdomain.firebaseapp.com/another-route", campaignDocument.getMedia());
        assertEquals("98765432", campaignDocument.getOrganizerId());
        assertNotNull(campaignDocument.getOrganizer());
        assertEquals("John", campaignDocument.getOrganizer().getFirstName());
        assertEquals("Doe", campaignDocument.getOrganizer().getLastName());
        assertEquals("https://subdomain.firebaseapp.com/another-route", campaignDocument.getOrganizer().getPhotoUrl());
        assertNotNull(campaignDocument.getRecipients());
        assertEquals(2, campaignDocument.getRecipients().size()); // Suponiendo que hay 2 recipientes

    }
    // Método de utilidad para crear una lista de recipientes con photoUrl específico para la prueba
    private List<Recipient> createRecipients() {
        List<Recipient> recipients = new ArrayList<>();
        recipients.add(Recipient.create("Jane Doe", "12345678", 25, "https://subdomain.firebaseapp.com/another-route"));
        recipients.add(Recipient.create("John Smith", "87654321", 30, "https://subdomain.firebaseapp.com/another-route"));
        return recipients;
    }

}