package com.bizconnect.model.dbentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Finder {

	@Id
	@GeneratedValue
	int id;
	int serviceCategory;
	String providerPhone;
	String consumerPhone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getServiceCategory() {
		return serviceCategory;
	}
	public void setServiceCategory(int serviceCategory) {
		this.serviceCategory = serviceCategory;
	}
	public String getProviderPhone() {
		return providerPhone;
	}
	public void setProviderPhone(String providerPhone) {
		this.providerPhone = providerPhone;
	}
	public String getConsumerPhone() {
		return consumerPhone;
	}
	public void setConsumerPhone(String consumerPhone) {
		this.consumerPhone = consumerPhone;
	}
	
	
}
