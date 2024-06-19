package com.jayway.mshopelink.modules.register_campaign.infrastructure.persistence;

import com.jayway.mshopelink.commons.aggregateroute.MemberCampaign;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDocument {
    private String memberId;
    private String firstName;
    private String lastName;
    private String photoUrl;
    public static MemberDocument from(MemberCampaign memberCampaign){
        return MemberDocument
                .builder()
                .memberId(memberCampaign.getOrganizerId())
                .firstName(memberCampaign.getFirstName())
                .lastName(memberCampaign.getLastName())
                .photoUrl(memberCampaign.getPhotoUrl())
                .build();
    }
}
