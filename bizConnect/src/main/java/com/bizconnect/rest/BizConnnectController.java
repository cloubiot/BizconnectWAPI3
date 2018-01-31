package com.bizconnect.rest;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bizconnect.clib.model.SuccessIDResponse;
import com.bizconnect.clib.util.JSONUtil;
import com.bizconnect.model.dbentity.ServiceData;
import com.bizconnect.model.dbentity.UserLocation;
import com.bizconnect.model.usermgmt.ActiveSearchRequest;
import com.bizconnect.model.usermgmt.ActiveSearchResponse;
import com.bizconnect.model.usermgmt.ActiveSearches;
import com.bizconnect.model.usermgmt.ServiceSearches;
import com.bizconnect.model.usermgmt.StatusRequest;
import com.bizconnect.model.usermgmt.StatusResponse;
import com.bizconnect.model.usermgmt.UpdateSearchRequest;
import com.bizconnect.service.BizConnectService;


@RestController
@RequestMapping("/bizconnect")
@CrossOrigin( maxAge = 3600)
public class BizConnnectController {
	
	private static final Logger logger = LoggerFactory.getLogger(BizConnnectController.class);
	
	@Autowired
	private BizConnectService bizconnectService;	
	
	@RequestMapping(method = RequestMethod.POST, value="/activateSearch")
	public SuccessIDResponse saveServiceData(@RequestBody ServiceData request){
		SuccessIDResponse response = new SuccessIDResponse();
		try{
			ServiceData service = new ServiceData();
			BeanUtils.copyProperties(request, service);
			bizconnectService.updateService(service);
			logger.info("new service added");
		}
		catch(Exception e){
			logger.error("service failed",e);
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/updateLocation")
	public SuccessIDResponse updateUserLocation(@RequestBody UserLocation request){
		SuccessIDResponse response = new SuccessIDResponse();
		try{
			System.out.println(JSONUtil.toJson(request)+" "+new Date());
			UserLocation userLocation = new UserLocation();
//			BeanUtils.copyProperties(request, userLocation);
			userLocation.setLastSeen(new Date());
			userLocation.setPhone(request.getPhone());
			userLocation.setLatitude(request.getLatitude());
			userLocation.setLongitude(request.getLongitude());
			bizconnectService.updateUserLocation(userLocation);
			logger.info("update userLocation added");
		}
		catch(Exception e){
			logger.error("userLocation failed",e);
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/getStatus")
	public StatusResponse getStatus(@RequestBody StatusRequest request){
		StatusResponse response = new StatusResponse();
		try{
			
		}
		catch(Exception e){
			
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/getActiveSearches")
	public ActiveSearchResponse getActiveSearches(@RequestBody ActiveSearchRequest request){
		ActiveSearchResponse response = new ActiveSearchResponse();
		try{
		List<ActiveSearches> searches = bizconnectService.getActiveSearches(request.getPhone());
		response.setActiveSearches(searches);
		logger.info("Active Searches");
		}
		catch(Exception e){
			logger.error("Searches failed",e);
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateSearch")
	public SuccessIDResponse updateSearch(@RequestBody UpdateSearchRequest request){
		SuccessIDResponse response = new SuccessIDResponse();
		try{
			ServiceData service = bizconnectService.updateSearch(request.getPhone());
			service.setServiceCategory(request.getServiceCategory());
			service.setAction(request.getAction());
			bizconnectService.updateService(service);
			logger.info("update search");
		}
		catch(Exception e){
			logger.error("Update failed",e);
			response.setSuccess(false);
		}
		return response;
	}
	}