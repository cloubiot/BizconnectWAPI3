package com.bizconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bizconnect.dao.UserActivityRepository;
import com.bizconnect.dao.UserProfileImageRepository;
import com.bizconnect.dao.UserRepository;
import com.bizconnect.model.dbentity.User;
import com.bizconnect.model.dbentity.UserActivity;
import com.bizconnect.model.dbentity.UserProfileImage;

@Service
@Transactional
public class UserMgmtService {

	@Autowired
	UserRepository userRespository;
	
	@Autowired
	UserActivityRepository userActivityRepository;
	
	@Autowired
	UserProfileImageRepository userProfileImageRespository;
	
	public User saveUser(User user){
		return this.userRespository.save(user);
	}
	
	public User userLogin(String userName, String password){
		return this.userRespository.findByUserNameAndPassword(userName, password);
	}
	
	public UserActivity saveUserActivity(UserActivity activity){
		return this.userActivityRepository.save(activity);
	}
	
	public UserProfileImage saveProfileImage(UserProfileImage userProfileImage){
		return this.userProfileImageRespository.save(userProfileImage);
	}
}
