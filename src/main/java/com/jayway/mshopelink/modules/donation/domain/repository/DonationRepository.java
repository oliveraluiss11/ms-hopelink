package com.jayway.mshopelink.modules.donation.domain.repository;

import com.jayway.mshopelink.modules.donation.domain.aggregateroute.Donation;

public interface DonationRepository {
    void save(Donation donation);
}
