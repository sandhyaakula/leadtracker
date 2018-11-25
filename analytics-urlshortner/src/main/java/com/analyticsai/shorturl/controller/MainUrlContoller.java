package com.analyticsai.shorturl.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.analyticsai.shorturl.domain.Campaign;
import com.analyticsai.shorturl.domain.CampaignUrl;
import com.analyticsai.shorturl.domain.UrlRegistry;
import com.analyticsai.shorturl.repository.UrlRepository;
import com.analyticsai.shorturl.util.RandomAlphanumericGenerator;

@Controller
public class MainUrlContoller {
	
	@Value("${url.format}")
	private String urlFormat;
	
	@Autowired
	UrlRepository repo;
	
	@Autowired
	RandomAlphanumericGenerator random;
	
	@PostMapping("/shortUrl")
	public CampaignUrl shortUrl(@RequestBody CampaignUrl campaignUrl) {
		UrlRegistry shortUrl = new UrlRegistry();
		shortUrl.setActive(true);
		shortUrl.setOriginalUrl(campaignUrl.getOriginalUrl());
		shortUrl.setCode(random.randomAlpha(3));
		shortUrl.setShortUrl(urlFormat.replace("#c#", shortUrl.getCode()));
		repo.save(shortUrl);
		return shortUrl.urlView();
	}
		
	@PostMapping("/originalUrl/{camapaignCode}")
	public CampaignUrl originalUrl(@PathVariable String camapaignCode) {
		Optional<UrlRegistry> urlRegistry = repo.findById(camapaignCode);
		return urlRegistry.get().urlView();
	}
	
	
}
