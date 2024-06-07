package com.jayway.mshopelink.modules.register_campaign.domain.aggregate;

import com.jayway.mshopelink.commons.valueobjects.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class Campaign {
    private static final String ORGANIZER_CAMPAIGN_CANNOT_BE_NULL = "OrganizerCampaign cannot be null";
    private final PostalCode postalCode;
    private final Amount targetAmount;
    private final OrganizerCampaign organizerCampaign;
    private final RecipientEnum recipientType;
    @Getter
    private final List<Recipient> recipients;
    private final Name title;
    private final CampaignDescription description;
    private final CategoryEnum category;
    private final Media media;

    private Campaign(String postalCode, BigDecimal targetAmount, OrganizerCampaign organizerCampaign,
                    RecipientEnum recipientType, List<Recipient> recipients, String title,
                    String description, CategoryEnum category, String media){
        Optional.ofNullable(organizerCampaign)
                .orElseThrow(()-> new IllegalArgumentException(ORGANIZER_CAMPAIGN_CANNOT_BE_NULL));

        Optional.ofNullable(recipients)
                .filter(value -> !Integer.valueOf(0).equals(value.size()))
                .orElseThrow(()->new IllegalArgumentException("Recipients cannot be null or empty"));
        this.postalCode = new PostalCode(postalCode);
        this.targetAmount = new Amount(targetAmount);
        this.organizerCampaign = organizerCampaign;
        this.recipientType = recipientType;
        this.recipients = recipients;
        this.title = new Name(title);
        this.description = new CampaignDescription(description);
        this.category = category;
        this.media = new Media(media);
    }

    public static Campaign create(String postalCode, BigDecimal targetAmount, OrganizerCampaign organizerCampaign,
                           RecipientEnum recipientType, List<Recipient> recipients, String title,
                           String description, CategoryEnum category, String media){
        return new Campaign(postalCode, targetAmount, organizerCampaign, recipientType,
                recipients, title, description, category, media);
    }

    public String getPostalCode(){
        return this.postalCode.value();
    }

    public BigDecimal getTargetAmount(){
        return this.targetAmount.value();
    }

    public String organizerId(){
        return this.organizerCampaign.getOrganizerId();
    }

    public String getOrganizerFullName(){
        return this.organizerCampaign.getFirstName() + " " + this.organizerCampaign.getLastName();
    }

    public String getRecipientType(){
        return this.recipientType.name();
    }

    public String getTitle(){
        return this.title.value();
    }

    public String getDescription(){
        return this.description.value();
    }

    public String getCategory(){
        return this.category.name();
    }

    public String getMedia(){
        return this.media.value();
    }
}
