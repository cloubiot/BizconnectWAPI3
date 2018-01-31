package com.bizconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bizconnect.clib.util.JSONUtil;
import com.bizconnect.dao.ServiceDataQuery;
import com.bizconnect.dao.ServiceDataRepository;
import com.bizconnect.dao.UserLocationRepository;
import com.bizconnect.model.dbentity.ServiceData;
import com.bizconnect.model.dbentity.UserLocation;
import com.bizconnect.model.usermgmt.ActiveSearches;
import com.bizconnect.model.usermgmt.ServiceSearches;


@Service
@Transactional
public class BizConnectService {

	@Autowired
	ServiceDataRepository serviceDataRepository;
	@Autowired
	UserLocationRepository userLocationRepository;
	@Autowired
	ServiceDataQuery serviceDataQuery;
	
	
	public ServiceData updateService(ServiceData serviceData){
		return this.serviceDataRepository.save(serviceData);
	}
	
	public UserLocation updateUserLocation(UserLocation userLocation){
		return this.userLocationRepository.save(userLocation);
	}
	
	public List<ActiveSearches> getActiveSearches(String phone){
		return this.serviceDataQuery.getActiveSearches(phone);
	}
	public ServiceData updateSearch(String phone){
		return this.serviceDataRepository.findByPhone(phone);
	}
	
}
