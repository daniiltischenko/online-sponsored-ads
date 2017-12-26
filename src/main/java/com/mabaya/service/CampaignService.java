package com.mabaya.service;

import com.mabaya.model.Campaign;
import org.springframework.stereotype.Service;

/**
 * @author Daniil Tyshchenko
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public class CampaignService {

    public Campaign createCampaign(Campaign campaign) {
        //permanent
        return new Campaign();
    }
}
