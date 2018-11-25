package com.analyticsai.analytics.controller;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.analyticsai.analytics.domain.CampaignSummary;
import com.analyticsai.analytics.domain.TrackingData;
import com.analyticsai.analytics.domain.UserActivity;
import com.analyticsai.analytics.repository.CampaignActivityRepository;
import com.analyticsai.analytics.repository.CampaignSummaryRepository;
import com.analyticsai.analytics.repository.UserActivityRepository;
import com.analyticsai.analytics.service.CampaignService;


@Controller
@PropertySource("classpath:/application.properties")
public class AnalyticsController {
	//
	//@Autowired
	//CampaignActivityRepository campaignActivity;
	@Autowired
	CampaignSummaryRepository summaryRepo;
	
	@Autowired
	UserActivityRepository userActivity;
	
	@Autowired
	UrlRegistryService urlRegistry;
	
	@GetMapping("/{code}/{trackingId}")
	public String intecept(@PathVariable String code,@PathVariable String trackingId, HttpServletResponse sResponse) throws IOException {
		UserActivity activity = new UserActivity();
		//activity.setActivityId(generatedValue);
		activity.setTrackingId(trackingId);
		activity.setData(null);
		userActivity.save(activity);
		
		sResponse.addCookie(new Cookie("userId", activity.getActivityId().toString()));
	  
	    return "redirect:"+urlRegistry.getLandingPage(code);
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/track", method = RequestMethod.POST,consumes = "application/json")
	public @ResponseBody void track(@RequestBody TrackingData data) {
		 String trackingId = "anonymous";
		 List<HttpCookie> cookies = HttpCookie.parse(data.getCookie());
		 for(HttpCookie cookie : cookies) {
			 if("userId".equals(cookie.getName())) {
				 trackingId = cookie.getValue();
			 }
		 }
		 UserActivity activity = new UserActivity();
		 activity.setTrackingId(trackingId);
		 activity.setData(data);
		 userActivity.save(activity);
	}
}
