package com.sms.gateway.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.regex.Matcher;

@Entity
public class SMS {
	
	@Id
	@GeneratedValue
	private long smsRequestId;
		
	private String message;
	private Long from;
	private String to;
	private Date dateSent;
	private long campaignId;
	
	public SMS() {}
			
	
	public long getSmsRequestId() {
		return smsRequestId;
	}


	public void setSmsRequestId(long smsRequestId) {
		this.smsRequestId = smsRequestId;
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

	public long getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Long id) {
		this.campaignId = id;
	}
	
}
