package com.jayway.mshopelink.modules.donation.infrastructure;

import com.jayway.mshopelink.modules.donation.domain.repository.DonationRepository;
import com.jayway.mshopelink.modules.donation.domain.aggregateroute.Donation;
import com.jayway.mshopelink.modules.donation.infrastructure.persistence.DonationDocument;
import com.jayway.mshopelink.modules.donation.infrastructure.persistence.DonationMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DonationMongoRepositoryImpl implements DonationRepository {
    private final DonationMongoRepository donationMongoRepository;
    @Override
    public void save(Donation donation) {
        donationMongoRepository.save(DonationDocument.from(donation));
    }
}
