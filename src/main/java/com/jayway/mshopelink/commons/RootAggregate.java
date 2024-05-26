package com.jayway.mshopelink.commons;

import com.jayway.mshopelink.modules.donation.domain.events.RegisteredDonationEvent;

import java.util.LinkedList;
import java.util.List;

public class RootAggregate {

    private List<DomainEvent> events = new LinkedList<>();

    protected void record(DomainEvent domainEvent) {
        this.events.add(domainEvent);
    }

    public List<DomainEvent> pullEvents() {
        var events = this.events;
        this.events = new LinkedList<>();
        return events;
    }

}
