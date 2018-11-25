package com.analytics.website;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.analytics.website.CamapaignPerformance.ID;

@Component
public class ScheduledReportGenerator {
	
	@Autowired
	CamapaignPerformanceRepo preformanceDataRepo;
	
	
	@Autowired
	CampaignRepository campaignRepo;
	
	
    @Scheduled(cron="0 0 19 * * *") //scheduled every day at 7 pm.
    public void trackCampaignAcitivity() {
    	Iterable<Campaign> allCampaigns = campaignRepo.findAll();
    	for(Campaign c : allCampaigns) {
    		if(c.isLive()) {
    			Date today  = new Date();
    			int dayCount = (int) TimeUnit.DAYS.convert(today.getTime() - c.getStartDate().getTime(),TimeUnit.MILLISECONDS);
    			ID id = new CamapaignPerformance.ID(c.getCampaignId(),dayCount);
				Optional<CamapaignPerformance> data = preformanceDataRepo.findById(id );
				if(data.isPresent()) {
					
				}
    		}
    	}
    }
}
