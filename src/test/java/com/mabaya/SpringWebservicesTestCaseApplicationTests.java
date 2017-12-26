package com.mabaya;

import com.mabaya.service.CampaignService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Daniil Tyshchenko
 * @version 0.0.1
 * @since 0.0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringWebservicesTestCaseApplicationTests {

    @Autowired
    CampaignService campaignService;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(campaignService);
    }
}
