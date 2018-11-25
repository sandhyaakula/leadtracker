package com.sms.gateway;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.sms.gateway.domain.SMS;


@Component
public interface SMSRespository extends CrudRepository<SMS,String>{ }