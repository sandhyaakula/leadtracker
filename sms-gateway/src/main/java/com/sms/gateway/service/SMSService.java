package com.sms.gateway.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sms.gateway.domain.Campaign;
import com.sms.gateway.domain.Customer;
import com.sms.gateway.domain.SMS;
import com.sms.gateway.repository.SMSRespository;
import com.sms.gateway.util.RandomAlphanumericGenerator;

@Component
public class SMSService {

	@Autowired
	private static SMSRespository repo;
	
	@Value("${segmentation.service.url}")
	private  String  segmentationServiceUrl;
		
	@Autowired
	private RandomAlphanumericGenerator random;
	

	private  static final String APIKEY = "QnIBdGCWBlA-B4TNCCV9tVQ9aju0VoNwhPlEMP0CBF";

	private  static  final int TRACKING_CODE_LEN = 8;

	
	
	public  void sendMessagesFor(Campaign campaign) {
		List<SMS> messages = new ArrayList<SMS>(campaign.getCustomerList().size());
		List<Customer> whiteList = extractWhiteList(campaign.getCustomerList());
		
		for (Customer customer : whiteList) {
			SMS sms = new SMS();
			sms.setDateSent(new Date());
			sms.setFrom(campaign.getCampaignId());
			sms.setTo(customer.getPhoneNumber());
			sms.setCampaignId(campaign.getCampaignId());
			//insert a tracking id in the hyperlink so as to help analytics track the unique user 
			sms.setMessage(campaign.getMeesage().replaceAll("#trackId",random.randomAlpha(TRACKING_CODE_LEN)));
			messages.add(sms);
		}
		
		send(messages);
	}
	
	
	private static List<Customer> extractWhiteList(Set<Customer> customerList) {
		//return whiteListed customers;
		return new ArrayList<Customer>(customerList);
	}


	public static void send(List<SMS> messages) {
		for (SMS sms : messages) {
			repo.save(sms); //log the sms request to storage i.e. database
			send(sms);
		}
	}	

	/*
	 * Temporary arrangment to send sms without a router. Purchased an account with
	 * textlocal.in to send customized messages
	 */
	private static boolean send(SMS sms) {
		boolean smsSent;
		try {
			// Construct sms
			String apiKey = "apikey=" + APIKEY;
			String message = "&message=" + sms.getMessage();
			String sender = "&sender=" + sms.getFrom();
			String numbers = "&numbers=" + sms.getTo();

			// post sms
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			smsSent = true;
		} catch (Exception e) {
			smsSent = false;
		}
		return smsSent;
	}
}
