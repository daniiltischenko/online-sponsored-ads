package com.mabaya.service;

import com.mabaya.model.Campaign;
import com.mabaya.model.Product;
import com.mabaya.model.ProductCategory;
import com.mabaya.repository.CampaignRepository;
import com.mabaya.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Daniil Tyshchenko
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public class CampaignService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Campaign createCampaign(String name,
                                   String startDate,
                                   ProductCategory category,
                                   BigDecimal bid) {

        LocalDateTime startDateTime = LocalDateTime.parse(startDate, FORMATTER);
        List<Product> products = productRepository.findAllByCategory(category);

        Campaign campaign = Campaign.createCampaign(name,
                startDateTime,
                bid,
                category,
                products);

        return campaignRepository.save(campaign);
    }

    public Optional<Product> retrieveProductWithHighestBidForCategory(ProductCategory category) {
        List<Campaign> campaigns = campaignRepository.findAllByCategory(category);
        return campaigns.stream()
                .filter(campaign -> campaign.getEndDate().isBefore(LocalDateTime.now()))
                .map(Campaign::getProducts)
                .flatMap(List::stream)
                .max(Comparator.comparing(Product::getPrice));
    }

    public Campaign getCampaignWithMaxBid() {
        List<Campaign> campaigns = campaignRepository.findAll();
        return campaigns.stream()
                .max(Comparator.comparing(Campaign::getBid))
                .get();
    }
}
