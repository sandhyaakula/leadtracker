package com.analyticsai.analytics.domain;

import javax.persistence.*;

@Entity 
public class UserActivity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "activitySeq")
    @SequenceGenerator(name = "activitySeq", sequenceName = "USER_LOG_SEQ")
	private Long activityId;
	
	private String trackingId;
	
	@Embedded
	private TrackingData data;

	public UserActivity() {}
	
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
}
