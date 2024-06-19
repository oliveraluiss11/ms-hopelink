package com.jayway.mshopelink.modules.register_campaign.infrastructure.persistence;

import com.jayway.mshopelink.commons.aggregateroute.Recipient;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RecipientDocumentTest {
    @Test
    public void shouldCreateRecipientDocumentFromRecipient() {
        Recipient recipient = Recipient.create("John Doe", "12345678", 30, "https://subdomain.firebaseapp.com/another-route");
        RecipientDocument recipientDocument = RecipientDocument.from(recipient);

        assertNotNull(recipientDocument);
        assertEquals("John Doe", recipientDocument.getFullName());
        assertEquals("12345678", recipientDocument.getDocumentNumber());
        assertEquals(30, recipientDocument.getAge());
        assertEquals("https://subdomain.firebaseapp.com/another-route", recipientDocument.getPhotoUrl());
    }

    @Test
    public void shouldCreateRecipientDocumentsFromList() {
        List<Recipient> recipients = new ArrayList<>();
        recipients.add(Recipient.create("John Doe", "12345678", 30, "https://subdomain.firebaseapp.com/another-route"));
        recipients.add(Recipient.create("Jane Smith", "87654321", 25, "https://subdomain.firebaseapp.com/another-route"));

        List<RecipientDocument> recipientDocuments = RecipientDocument.fromList(recipients);

        assertNotNull(recipientDocuments);
        assertEquals(2, recipientDocuments.size());
        assertEquals("John Doe", recipientDocuments.getFirst().getFullName());
        assertEquals("12345678", recipientDocuments.getFirst().getDocumentNumber());
        assertEquals(30, recipientDocuments.getFirst().getAge());
        assertEquals("https://subdomain.firebaseapp.com/another-route", recipientDocuments.getFirst().getPhotoUrl());

        assertEquals("Jane Smith", recipientDocuments.get(1).getFullName());
        assertEquals("87654321", recipientDocuments.get(1).getDocumentNumber());
        assertEquals(25, recipientDocuments.get(1).getAge());
        assertEquals("https://subdomain.firebaseapp.com/another-route", recipientDocuments.get(1).getPhotoUrl());
    }
}