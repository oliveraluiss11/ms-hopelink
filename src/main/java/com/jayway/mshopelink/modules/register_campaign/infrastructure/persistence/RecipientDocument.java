package com.jayway.mshopelink.modules.register_campaign.infrastructure.persistence;

import com.jayway.mshopelink.commons.aggregateroute.Recipient;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RecipientDocument {
    private String fullName;
    private String documentNumber;
    private Integer age;
    private String photoUrl;

    public static RecipientDocument from(Recipient recipient){
        return RecipientDocument
                .builder()
                .fullName(recipient.getFullName())
                .documentNumber(recipient.getDocumentNumber())
                .age(recipient.getAge())
                .photoUrl(recipient.getPhotoUrl())
                .build();
    }
    public static List<RecipientDocument> fromList(List<Recipient> recipients){
        return recipients.stream()
                .map(RecipientDocument::from)
                .toList();
    }
}
