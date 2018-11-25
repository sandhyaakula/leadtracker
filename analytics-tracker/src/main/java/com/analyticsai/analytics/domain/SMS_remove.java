package com.analyticsai.analytics.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.regex.Matcher;

@Entity
public class SMS_remove {
	@Id
	private String trackerId;
		
	private String message;
	private Long from;
	private String to;
	private Date dateSent;
	private String campaignId;
	
	public SMS_remove() {}
			
	public String getTrackerId() {
		return trackerId;
	}

	public void setTrackerId(String trackerId) {
		this.trackerId = trackerId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getFrom() {
		return from;
	}

	public void setFrom(Long from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getDateSent() {
		return dateSent;
	}

	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}

	private List<String> extractHyperlinks() {
		List<String> containedUrls = new ArrayList<String>();
	    String urlRegex = "((https?):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
	    Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
	    Matcher urlMatcher = pattern.matcher(message);

	    while (urlMatcher.find())
	    {
	        containedUrls.add(message.substring(urlMatcher.start(0),
	                urlMatcher.end(0)));
	    }

	    return containedUrls;		
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	
}
