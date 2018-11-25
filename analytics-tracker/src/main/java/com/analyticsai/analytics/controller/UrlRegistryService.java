package com.analyticsai.analytics.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.analyticsai.analytics.domain.CampaignUrl;

@Component
public class UrlRegistryService {

	@Value("${urlregistry.url}")
	private String urlregistry;
	
	public String getLandingPage(String code) {
		RestTemplate restTemplate = new RestTemplate();
		CampaignUrl url = restTemplate.getForObject(urlregistry, CampaignUrl.class);
		return url.getOriginalUrl();
	}

}
