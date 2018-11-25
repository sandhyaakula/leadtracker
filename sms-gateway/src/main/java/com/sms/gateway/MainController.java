package com.sms.gateway;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.gateway.domain.SMS;

@RestController
public class MainController {
	
	@PostMapping("/bulksms/send")
	public void sendSMS(@RequestBody Campaign campaign) {
		SMSService.sendMessagesFor(campaign);
	}
	
}
