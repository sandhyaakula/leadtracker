package com.analyticsai.segmentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CutomerDataController {

	@Autowired
	CustomerRepository customerRepo;

	@PostMapping("/whitelist")
	private @ResponseBody List<String> extractWhitelist(@RequestBody List<String> phoneNumbers,
			Predicate<Customer> criteria) {
		List<String> whiteList = new ArrayList<String>();
		
		for (String phoneNumber : phoneNumbers) {
			Optional<Customer> customer = customerRepo.findById(phoneNumber);
			if (customer.isPresent()) {
				if (criteria.test(customer.get())) {
					whiteList.add(phoneNumber);
				}
			}
		}

		return whiteList;
	}
}
