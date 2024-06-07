package com.jayway.mshopelink.commons.valueobjects;

public class OrganizerCampaign {
    private final DocumentId organizerId;
    private final Name firstName;
    private final Name lastName;

    private OrganizerCampaign(String organizerId, String firstName, String lastName){
        this.organizerId = new DocumentId(organizerId);
        this.firstName = new Name(firstName);
        this.lastName = new Name(lastName);
    }

    public static OrganizerCampaign create(String organizerId, String firstName, String lastName){
        return new OrganizerCampaign(organizerId, firstName, lastName);
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
