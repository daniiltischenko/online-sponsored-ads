package com.mabaya.controller;

import com.mabaya.model.Campaign;
import com.mabaya.model.ProductCategory;
import com.mabaya.service.CampaignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;

/**
 * @author Daniil Tyshchenko
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
@RequestMapping(value = "/api/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Campaign> createCampaign(@RequestParam String name,
                                                   @RequestParam String startDate,
                                                   @RequestParam ProductCategory category,
                                                   @RequestParam BigDecimal bid) {
        LOGGER.info("Received request to create campaign with name: [{}], starting on: [{}], of category: [{}] and price: [{}]",
                name, startDate, category, bid);
        Campaign createdCampaign = campaignService.createCampaign(new Campaign());

        return new ResponseEntity<>(createdCampaign, HttpStatus.CREATED);
    }

}
