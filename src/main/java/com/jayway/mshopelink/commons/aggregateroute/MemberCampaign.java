package com.jayway.mshopelink.commons.aggregateroute;

import com.jayway.mshopelink.commons.valueobjects.DocumentId;
import com.jayway.mshopelink.commons.valueobjects.Media;
import com.jayway.mshopelink.commons.valueobjects.Name;

public class MemberCampaign {
    private final DocumentId organizerId;
    private final Name firstName;
    private final Name lastName;
    private final Media photoUrl;

    private MemberCampaign(String organizerId, String firstName, String lastName, String photoUrl){
        this.organizerId = new DocumentId(organizerId);
        this.firstName = new Name(firstName);
        this.lastName = new Name(lastName);
        this.photoUrl = new Media(photoUrl);
    }

    public static MemberCampaign create(String organizerId, String firstName, String lastName, String photoUrl){
        return new MemberCampaign(organizerId, firstName, lastName, photoUrl);
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
    public String getPhotoUrl(){return this.photoUrl.value();}

}
