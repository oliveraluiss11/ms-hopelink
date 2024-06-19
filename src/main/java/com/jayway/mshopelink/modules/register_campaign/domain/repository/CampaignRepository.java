package com.jayway.mshopelink.modules.register_campaign.domain.repository;

import com.jayway.mshopelink.modules.register_campaign.domain.aggregate.Campaign;

public interface CampaignRepository {
    void save(Campaign campaign);
}
