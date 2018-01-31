package com.bizconnect.model.usermgmt;

import java.util.List;

import com.bizconnect.model.dbentity.ServiceData;

public class ActiveSearches  {
	
	int serviceType;
	String serviceCategory;
	
	public int getServiceType() {
		return serviceType;
	}
	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}
	public String getServiceCategory() {
		return serviceCategory;
	}
	public void setServiceCategory(String serviceCategory) {
		this.serviceCategory = serviceCategory;
	}
	
}
