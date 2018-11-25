package com.analytics.website;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface CampaignRepository extends CrudRepository<Campaign,Long>{ }
	

