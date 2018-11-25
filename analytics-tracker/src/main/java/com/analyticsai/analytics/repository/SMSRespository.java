package com.analyticsai.analytics.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.analyticsai.analytics.domain.SMS_remove;

@Component
public interface SMSRespository extends CrudRepository<SMS_remove,String>{ }