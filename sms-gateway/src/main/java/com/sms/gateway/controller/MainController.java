package com.sms.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.gateway.domain.Campaign;
import com.sms.gateway.domain.SMS;
import com.sms.gateway.service.SMSService;

@RestController
public class MainController {
	
	@Autowired
	private SMSService smsService;
	
	@PostMapping("/bulksms/send")
	public void sendSMS(@RequestBody Campaign campaign) {
		smsService.sendMessagesFor(campaign);
	}
	
}
