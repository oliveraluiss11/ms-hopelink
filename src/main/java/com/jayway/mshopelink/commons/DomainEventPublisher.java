package com.jayway.mshopelink.commons;

import java.util.List;

public interface DomainEventPublisher {

    void publish(List<DomainEvent> events);

    void publish(DomainEvent event);

}
