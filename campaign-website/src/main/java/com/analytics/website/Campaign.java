package com.analytics.website;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Campaign {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "campaignSeq")
    @SequenceGenerator(name = "campaignSeq", sequenceName = "CAMPAIGN_SEQ")
	private Long campaignId;	
	
	private String name;
	
	private String url;
	
	private String message;
	
	private Date startDate;
	
	private Date endDate;
	
	private boolean isLive;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isLive() {
		return (isLive || endDate.after(new Date()));
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public Set<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(Set<Customer> customerList) {
		this.customerList = customerList;
	}

	@OneToMany(mappedBy="campaign")
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
	
	
}
