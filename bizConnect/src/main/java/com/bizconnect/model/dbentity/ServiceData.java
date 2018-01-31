package com.bizconnect.model.dbentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ServiceData {

	@Id
	@GeneratedValue
	int id;
	String phone;
	String device;
	int serviceCategory;
	int serviceType;
	int active;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getServiceType() {
		return serviceType;
	}
	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public 	int getActive() {
		return active;
	}
	public void setAction(int active) {
		this.active = active;
	}
	
	
	
}
