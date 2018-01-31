package com.bizconnect.model.usermgmt;

public class UpdateSearchRequest {

	String phone;
	int serviceCategory;
	int active;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getServiceCategory() {
		return serviceCategory;
	}
	public void setServiceCategory(int serviceCategory) {
		this.serviceCategory = serviceCategory;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	
}
