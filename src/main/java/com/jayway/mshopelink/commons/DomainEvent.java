package com.jayway.mshopelink.commons;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

public class DomainEvent {

    private String eventId = UUID.randomUUID().toString();
    private LocalDateTime createdAt = LocalDateTime.now(ZoneId.systemDefault());

}
