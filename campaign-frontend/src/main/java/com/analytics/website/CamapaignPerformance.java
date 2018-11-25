package com.analytics.website;

import javax.persistence.*;

@Entity
public class CamapaignPerformance {

	@Embeddable
	static class ID {
		ID(){}
		
		ID(Long id, int day){
			campaignId = id;
			dayCount = day;
		}
		private Long campaignId;
		private int dayCount;

		public Long getCampaignId() {
			return campaignId;
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
