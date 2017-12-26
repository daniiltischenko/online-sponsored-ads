package com.mabaya.repository;

import com.mabaya.model.Campaign;
import com.mabaya.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Daniil Tyshchenko
 * @version 0.0.1
 * @since 0.0.1
 */
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    List<Campaign> findAllByCategory(ProductCategory category);
}
