package com.analyticsai.frontend;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledReportGenerator {

    @Scheduled(cron="0 0 19 * * *") //scheduled every day at 7 pm.
    public void trackCampaignAcitivity() {
        //connect and get Analytics Tracker data for each campaign
    	//
    }
}
