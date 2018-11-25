package com.analyticsai.analytics.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Embeddable
public class TrackingData {
	
	private String location;
	
	private String time;
	
	@Transient
	private String cookie;
	
	private String action;
	
	private String actionSource;
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getCookie() {
		return cookie;
	}
	
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public String getActionSource() {
		return actionSource;
	}
	
	public void setActionSource(String actionSource) {
		this.actionSource = actionSource;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return location+cookie+action+actionSource;
	}
	
}
