package com.analyticsai.segmentation.repository;

import org.springframework.data.repository.CrudRepository;

import com.analyticsai.segmentation.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>{}
