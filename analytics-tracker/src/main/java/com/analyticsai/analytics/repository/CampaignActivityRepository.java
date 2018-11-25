package com.analyticsai.analytics.repository;

import org.springframework.data.repository.CrudRepository;

import com.analyticsai.analytics.domain.CampaignActivity;
import com.analyticsai.analytics.domain.UserActivity;

public interface CampaignActivityRepository extends CrudRepository<CampaignActivity,String> {}
