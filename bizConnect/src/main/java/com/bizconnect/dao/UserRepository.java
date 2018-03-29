package com.bizconnect.dao;

import org.springframework.data.repository.CrudRepository;

import com.bizconnect.model.dbentity.User;

public interface UserRepository extends CrudRepository<User,Long>{

	User findByUserNameAndPassword(String userName, String password);
}
