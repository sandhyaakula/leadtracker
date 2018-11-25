package com.analyticsai.shorturl.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UrlRegistry {
	@Id
	private String urlCode;
	private String originalUrl;
	private String shortUrl;
	private boolean isActive;
	
	public UrlRegistry() {}
	
	
	public CampaignUrl urlView() {
		return new CampaignUrl(originalUrl, shortUrl);
	}
	
	public String getCode() {
		return urlCode;
	}

	public void setCode(String id) {
		this.urlCode = id;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
