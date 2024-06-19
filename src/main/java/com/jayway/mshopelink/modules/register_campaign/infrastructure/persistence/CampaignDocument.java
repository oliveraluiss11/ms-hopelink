package com.jayway.mshopelink.modules.register_campaign.infrastructure.persistence;

import com.jayway.mshopelink.modules.register_campaign.domain.aggregate.Campaign;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampaignDocument {
    @Id
    private String campaignId;
    private String title;
    private String description;
    private String postalCode;
    private BigDecimal targetAmount;
    private String recipientType;
    private String category;
    private String media;
    private List<RecipientDocument> recipients;
    private MemberDocument organizer;
    private String organizerId;
    private List<MemberDocument> supportTeam;
    public static CampaignDocument from(Campaign campaign){
        return CampaignDocument
                .builder()
                .title(campaign.getTitle())
                .description(campaign.getDescription())
                .postalCode(campaign.getPostalCode())
                .targetAmount(campaign.getTargetAmount())
                .recipientType(campaign.getRecipientType())
                .category(campaign.getCategory())
                .media(campaign.getMedia())
                .organizerId(campaign.organizerId())
                .organizer(MemberDocument.from(campaign.getOrganizerCampaign()))
                .recipients(RecipientDocument.fromList(campaign.getRecipients()))
                .build();
    }
}
