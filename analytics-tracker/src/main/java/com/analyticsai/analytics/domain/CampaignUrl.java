package com.analyticsai.analytics.domain;

public class CampaignUrl {
	private String originalUrl;
	private String shortUrl;
	
	public CampaignUrl(String url, String sUrl) {
		originalUrl = url;
		shortUrl = sUrl;
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
	
	
}
