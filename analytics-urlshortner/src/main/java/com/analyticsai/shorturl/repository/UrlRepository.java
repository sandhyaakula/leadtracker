package com.analyticsai.shorturl.repository;

import org.springframework.data.repository.CrudRepository;

import com.analyticsai.shorturl.domain.UrlRegistry;

public interface UrlRepository extends CrudRepository<UrlRegistry, String>{

}
