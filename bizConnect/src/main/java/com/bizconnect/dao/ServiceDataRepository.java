package com.bizconnect.dao;

import org.springframework.data.repository.CrudRepository;

import com.bizconnect.model.dbentity.ServiceData;

public interface ServiceDataRepository extends CrudRepository<ServiceData,Long> {
	
	ServiceData findByPhoneAndServiceCategory(String phone,int serviceCategory);
}
