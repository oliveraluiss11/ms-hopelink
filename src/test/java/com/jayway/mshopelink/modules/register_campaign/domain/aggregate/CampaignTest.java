package com.jayway.mshopelink.modules.register_campaign.domain.aggregate;

import com.jayway.mshopelink.commons.valueobjects.CategoryEnum;
import com.jayway.mshopelink.commons.aggregateroute.MemberCampaign;
import com.jayway.mshopelink.commons.aggregateroute.Recipient;
import com.jayway.mshopelink.commons.valueobjects.RecipientEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CampaignTest {

    private MemberCampaign organizerCampaign;
    private RecipientEnum recipientType;
    private List<Recipient> recipients;
    private String title;
    private String description;
    private CategoryEnum category;
    private String validYoutubeMedia;
    private String validFirebaseMedia;
    private String invalidMedia;

    @BeforeEach
    void setUp() {
        this.organizerCampaign = MemberCampaign.create("org123", "John", "Doe");
        this.recipientType = RecipientEnum.MYSELF;
        this.recipients = List.of(Recipient.create("John Doe", "12345678", 30, "https://yourapp.firebaseapp.com/media"));
        this.title = "Campaign Title";
        this.description = "Campaign Description";
        this.category = CategoryEnum.EDUCATION;
        this.validYoutubeMedia = "https://youtu.be/dQw4w9WgXcQ";
        this.validFirebaseMedia = "https://yourapp.firebaseapp.com/media";
        this.invalidMedia = "https://invalidmedia.com/media";
    }

    @Test
    void shouldThrowExceptionWhenOrganizerCampaignIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Campaign.create("12345", BigDecimal.TEN, null,
                recipientType, recipients, title, description, category, validYoutubeMedia));
    }

    @Test
    void shouldThrowExceptionWhenRecipientsIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Campaign.create("12345", BigDecimal.TEN, organizerCampaign,
                recipientType, null, title, description, category, validYoutubeMedia));
    }

    @Test
    void shouldThrowExceptionWhenRecipientsIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Campaign.create("12345", BigDecimal.TEN, organizerCampaign,
                recipientType, Collections.emptyList(), title, description, category, validYoutubeMedia));
    }

    @Test
    void shouldThrowExceptionWhenPostalCodeIsInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Campaign.create("1234", BigDecimal.TEN, organizerCampaign,
                recipientType, recipients, title, description, category, validYoutubeMedia));

        Assertions.assertThrows(IllegalArgumentException.class, () -> Campaign.create("123456", BigDecimal.TEN, organizerCampaign,
                recipientType, recipients, title, description, category, validYoutubeMedia));

        Assertions.assertThrows(IllegalArgumentException.class, () -> Campaign.create("abcde", BigDecimal.TEN, organizerCampaign,
                recipientType, recipients, title, description, category, validYoutubeMedia));
    }

    @Test
    void shouldThrowExceptionWhenMediaUrlIsInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Campaign.create("12345", BigDecimal.TEN, organizerCampaign,
                recipientType, recipients, title, description, category, invalidMedia));
    }

    @Test
    void shouldCreateCampaignWhenOrganizerCampaignAndRecipientsAreValid() {
        Campaign campaign = Campaign.create("12345", BigDecimal.TEN, organizerCampaign,
                recipientType, recipients, title, description, category, validYoutubeMedia);

        // Verificar los valores establecidos
        Assertions.assertEquals("12345", campaign.getPostalCode());
        Assertions.assertEquals(BigDecimal.TEN, campaign.getTargetAmount());
        Assertions.assertEquals("org123", campaign.organizerId());
        Assertions.assertEquals("John Doe", campaign.getOrganizerFullName());
        Assertions.assertEquals(recipientType.name(), campaign.getRecipientType());
        Assertions.assertEquals(title, campaign.getTitle());
        Assertions.assertEquals(description, campaign.getDescription());
        Assertions.assertEquals(category.name(), campaign.getCategory());
        Assertions.assertEquals(validYoutubeMedia, campaign.getMedia());

        // Crear campaña con URL de Firebase válida
        campaign = Campaign.create("12345", BigDecimal.TEN, organizerCampaign,
                recipientType, recipients, title, description, category, validFirebaseMedia);

        // Verificar los valores establecidos
        Assertions.assertEquals(validFirebaseMedia, campaign.getMedia());
    }
}