package com.bizconnect.rest;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bizconnect.clib.model.SuccessIDResponse;
import com.bizconnect.clib.util.DateTimeUtil;
import com.bizconnect.clib.util.SecureData;
import com.bizconnect.model.dbentity.User;
import com.bizconnect.model.dbentity.UserActivity;
import com.bizconnect.model.usermgmt.LoginRequest;
import com.bizconnect.model.usermgmt.LoginResponse;
import com.bizconnect.model.usermgmt.UserSignUpRequest;
import com.bizconnect.service.UserMgmtService;

@RestController
@RequestMapping("/usermgmt")
@CrossOrigin( maxAge = 3600)
public class UserMgmtController {

	private static final Logger logger = LoggerFactory.getLogger(UserMgmtController.class);
	
	@Autowired
	UserMgmtService userMgmtService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/createAccount")
	public SuccessIDResponse createUser(@RequestBody UserSignUpRequest request){
		SuccessIDResponse response = new SuccessIDResponse();
		try{
			User user = new User();
			SecureData secureData = new SecureData();
			String password = secureData.encrypt(request.getPassword());
			user.setUserName(request.getUserName());
			user.setFirstName(request.getFirstName());
			user.setLastName(request.getLastName());
			user.setPassword(password);
			user.setConfirmPassword(password);
			user.setPhoneNumber(request.getPhoneNumber());
			user.setEmailAddress(request.getEmailAddress());
			user.setProfileImageId(request.getProfileImageId());
			userMgmtService.saveUser(user);
			logger.info("User created");
		}
		catch(Exception e){
			logger.error("User creation failed",e);
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public LoginResponse userLogin(@RequestBody LoginRequest request){
		LoginResponse response = new LoginResponse();
		try{
			SecureData secureData = new SecureData();
			UserActivity userActivity = new UserActivity();
			String password = secureData.encrypt(request.getPassword());
			System.out.println("user "+request.getUserName()+" pass "+password);
			User user = userMgmtService.userLogin(request.getUserName(), password);
			String uuid = UUID.randomUUID().toString().replace("-", "");
			if(user != null){
				response.setSecureToken(uuid);
				userActivity.setUserId(user.getId());
				userActivity.setSecureToken(uuid);
				userActivity.setLoginTime(DateTimeUtil.getTodayString());
				userMgmtService.saveUserActivity(userActivity);
				logger.info("login");
			}
		}
		catch(Exception e){
			response.setSuccess(false);
			logger.info("login failed");
		}
		return response;
	}
}
