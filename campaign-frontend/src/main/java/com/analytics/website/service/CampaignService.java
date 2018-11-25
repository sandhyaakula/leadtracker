package com.analytics.website.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.analytics.website.domain.Campaign;

@Component
public class CampaignService {
	
	@Value("${sms.service.bulksms}")
	private String smsGatewayUrl;
	
	public boolean begin(Campaign campaign) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Boolean> response = 
				restTemplate.postForEntity(smsGatewayUrl, campaign, Boolean.class);
		//enable the analytics data receiver for this campaign 
		return true;
	}

	public boolean end(Campaign campaign) {
		//shutdown the analytics data receiver for this campaign
		return false;
	}

}
