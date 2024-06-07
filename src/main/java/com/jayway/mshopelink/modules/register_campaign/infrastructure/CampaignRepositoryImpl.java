package com.jayway.mshopelink.modules.register_campaign.infrastructure;

import com.jayway.mshopelink.modules.register_campaign.domain.aggregate.Campaign;
import com.jayway.mshopelink.modules.register_campaign.domain.aggregate.CampaignRepository;
import com.jayway.mshopelink.modules.register_campaign.infrastructure.persistence.CampaignDocument;
import com.jayway.mshopelink.modules.register_campaign.infrastructure.persistence.CampaignMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CampaignRepositoryImpl implements CampaignRepository {
    private final CampaignMongoRepository campaignMongoRepository;
    @Override
    public void save(Campaign campaign) {
        campaignMongoRepository.save(CampaignDocument.from(campaign));
    }
}
