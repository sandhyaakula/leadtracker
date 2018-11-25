package com.sms.gateway;

import java.util.Set;

public class Campaign {
	
	private Long campaignId;	
	
	private String name;
	
	private String url;
	
	private String message;
	
	private String criteria;
	
    private Set<Customer> customerList;
	
	public Long getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMeesage() {
		return message;
	}

	public void setMeesage(String meesage) {
		this.message = meesage;
	}

	public Set<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(Set<Customer> customerList) {
		this.customerList = customerList;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	
	
}
