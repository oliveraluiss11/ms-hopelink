package com.jayway.mshopelink.commons;

import java.util.LinkedList;
import java.util.List;

public class AggregateRoot {

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
