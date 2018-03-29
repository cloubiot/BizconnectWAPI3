package com.bizconnect.dao;

import org.springframework.data.repository.CrudRepository;

import com.bizconnect.model.dbentity.UserActivity;

public interface UserActivityRepository extends CrudRepository<UserActivity, Long>{

}
