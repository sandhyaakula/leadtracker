package com.analytics.website.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.analytics.website.domain.Campaign;


@Component
public interface CampaignRepository extends CrudRepository<Campaign,Long>{ }
	

