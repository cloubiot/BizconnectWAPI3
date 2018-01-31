package com.bizconnect.model.usermgmt;

public class UpdateSearchRequest {

	String phone;
	int serviceCategory;
	int action;
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
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	
	
}
