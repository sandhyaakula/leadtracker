package com.analyticsai.analytics.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class CampaignService  {

	@Value("${campaign.service.url}")
	String url;

	public String getLandingPage(String campaignId) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, String.class);
	}

}
