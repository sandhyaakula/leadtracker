package com.analyticsai.segmentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SegmentationApp 
{
	 public static void main(String[] args) {
	        SpringApplication.run(SegmentationApp.class, args);
	 }
}

/*
 * Segmentation application
 * 
 * extractWhitelist(List<Long> phoneNumbers, Criteria criteria)
 * 	return List<Integers> that got selected base on the given criteria
 * 
 * void feedSummary(String campaignId, Json data) -data fed by Tracker app
 * 
 * 
 */

