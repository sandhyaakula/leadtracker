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

import com.analyticsai.analytics.domain.TrackingData;
import com.analyticsai.analytics.domain.UserActivity;
import com.analyticsai.analytics.repository.CampaignActivityRepository;
import com.analyticsai.analytics.repository.UserActivityRepository;
import com.analyticsai.analytics.service.CampaignService;


@Controller
@PropertySource("classpath:/application.properties")
public class AnalyticsController {
	
	@Autowired
	CampaignActivityRepository campaignActivity;
	
	@Autowired
	UserActivityRepository userActivity;
	
	@Autowired
	CampaignService campaignService;
	
	@GetMapping("/{campaignId}/{trackingId}")
	public String intecept(@PathVariable String campaignId,@PathVariable String trackingId, HttpServletResponse sResponse) throws IOException {
	    sResponse.addCookie(new Cookie("trackingId", trackingId));
	    return "redirect:"+campaignService.getLandingPage(campaignId);
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/track", method = RequestMethod.POST,consumes = "application/json")
	public @ResponseBody void track(@RequestBody TrackingData data) {
		 String trackingId = "anonymous";
		 List<HttpCookie> cookies = HttpCookie.parse(data.getCookie());
		 for(HttpCookie cookie : cookies) {
			 if("trackingId".equals(cookie.getName())) {
				 trackingId = cookie.getValue();
			 }
		 }
		 UserActivity activity = new UserActivity();
		 activity.setTrackingId(trackingId);
		 activity.setData(data);
		 userActivity.save(activity);
		 System.out.println(data);
	}
}
