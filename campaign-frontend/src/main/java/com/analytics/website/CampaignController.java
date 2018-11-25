package com.analytics.website;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CampaignController {
	
	@Autowired
	CampaignRepository respository;
	
	@Autowired
	private CampaignService campaignService;
	
	@GetMapping("/campaign/url/{id}")
    public String campaignURL(@PathVariable Long id) {
        Optional<Campaign> campaign = respository.findById(id);
        if(campaign.isPresent()) {
        	return campaign.get().getUrl();
        }
        return null;
    }
	
	@PostMapping("campaign/{id}")
	public void createCampaign(@PathVariable Long id, @RequestBody Campaign campaign) {
		respository.save(campaign);
	}
	
	@PostMapping("campaign/{id}/start")
	public boolean startCampaign(@PathVariable Long id) {
		Optional<Campaign> campaign = respository.findById(id);
		if(campaign.isPresent()) {
        	return campaignService.begin(campaign.get());
        }
		return false;
	}
	
	
	@PostMapping("campaign/{id}/end")
	public boolean endCampaign(@PathVariable Long id) {
		Optional<Campaign> campaign = respository.findById(id);
		if(campaign.isPresent()) {
        	return campaignService.end(campaign.get());
        }
		return false;
	}

}
