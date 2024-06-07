package com.jayway.mshopelink.commons.aggregateroute;

import com.jayway.mshopelink.commons.valueobjects.DocumentId;
import com.jayway.mshopelink.commons.valueobjects.Name;

public class MemberCampaign {
    private final DocumentId organizerId;
    private final Name firstName;
    private final Name lastName;

    private MemberCampaign(String organizerId, String firstName, String lastName){
        this.organizerId = new DocumentId(organizerId);
        this.firstName = new Name(firstName);
        this.lastName = new Name(lastName);
    }

    public static MemberCampaign create(String organizerId, String firstName, String lastName){
        return new MemberCampaign(organizerId, firstName, lastName);
    }

    public String getOrganizerId(){
       return this.organizerId.value();
    }

    public String getFirstName(){
        return this.firstName.value();
    }

    public String getLastName(){
        return this.lastName.value();
    }

}
