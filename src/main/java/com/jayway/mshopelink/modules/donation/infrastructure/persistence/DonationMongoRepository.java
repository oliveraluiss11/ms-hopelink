package com.jayway.mshopelink.modules.donation.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DonationMongoRepository extends MongoRepository<DonationDocument, String> {
}
