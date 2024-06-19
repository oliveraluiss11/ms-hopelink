package com.jayway.mshopelink.modules.register_campaign.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CampaignMongoRepository extends MongoRepository<CampaignDocument, String> {
}
