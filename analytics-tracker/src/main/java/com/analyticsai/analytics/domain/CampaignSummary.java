package com.analyticsai.analytics.domain;

import javax.persistence.Embeddable;
import javax.persistence.Id;

public class CampaignSummary {
	@Embeddable
	public
	static class ID {
		ID(){}
		
		ID(String id, int day){
			campaignCode = id;
			dayCount = day;
		}
		private String campaignCode;
		private int dayCount;

		public String getCampaignId() {
			return campaignCode;
		}

		public int getDayCount() {
			return dayCount;
		}
	}

	@Id
	private ID id;

	private int responseCount;

	private int leadCount;

	public ID getId() {
		return id;
	}

	public int getResponseCount() {
		return responseCount;
	}

	public int getLeadCount() {
		return leadCount;
	}

}


