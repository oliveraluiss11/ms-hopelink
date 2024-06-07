package com.jayway.mshopelink.commons.valueobjects;

import com.jayway.mshopelink.modules.donation.domain.valueobjects.DocumentNumber;

public class Recipient {
    private final Name fullName;
    private final DocumentNumber documentNumber;
    private final Age age;
    private final Media photoUrl;

    private Recipient(String fullName, String documentNumber, Integer age, String photoUrl) {
        this.fullName = new Name(fullName);
        this.documentNumber = new DocumentNumber(documentNumber);
        this.age = new Age(age);
        this.photoUrl = new Media(photoUrl);
    }

    public static Recipient create(String fullName, String documentNumber, Integer age, String photoUrl) {
        return new Recipient(fullName, documentNumber, age, photoUrl);
    }

    public String getFullName() {
        return this.fullName.value();
    }

    public String getDocumentNumber() {
        return this.documentNumber.value();
    }

    public Integer getAge() {
        return this.age.value();
    }

    public String getPhotoUrl() {
        return this.photoUrl.value();
    }
}
