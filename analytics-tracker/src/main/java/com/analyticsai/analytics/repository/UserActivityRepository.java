package com.analyticsai.analytics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.analyticsai.analytics.domain.UserActivity;


@Component
public interface UserActivityRepository extends CrudRepository<UserActivity,Long> {}
