package com.analyticsai.analytics.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.analyticsai.analytics.domain.UserActivity;
import com.analyticsai.analytics.repository.CampaignSummaryRepository;
import com.analyticsai.analytics.repository.UserActivityRepository;

@Component
public class AnalyticsSheduler {

	@Autowired
	private CampaignSummaryRepository summary;
	
	@Autowired
	private UserActivityRepository userActivity;
	
    @Scheduled(cron="0 0 19 * * *") //scheduled every day at 7 pm.
    public void summarizeCampaignAcitivity() {
        Iterable<UserActivity> allActivity =  userActivity.findAll();
       //update summary objects
    }
}