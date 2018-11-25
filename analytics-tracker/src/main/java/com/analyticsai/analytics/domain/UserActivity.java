package com.analyticsai.analytics.domain;

import javax.persistence.*;

@Entity 
public class UserActivity {
	
	@Id
	private String activityId;
	
	private String trackingId;
	
	private String code;
	
	@Embedded
	private TrackingData data;

	public UserActivity() {}
	
	
	public String getActivityId() {
		return activityId;
	}


	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}


	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public TrackingData getData() {
		return data;
	}

	public void setData(TrackingData data) {
		this.data = data;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
}
