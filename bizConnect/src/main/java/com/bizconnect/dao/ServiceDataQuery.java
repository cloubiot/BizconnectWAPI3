package com.bizconnect.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bizconnect.model.usermgmt.ActiveSearches;
import com.bizconnect.model.usermgmt.ServiceSearches;

@Service
@Transactional

public class ServiceDataQuery {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ActiveSearches> getActiveSearches(String phone){
		String query = "select service_data.SERVICE_TYPE,service_category.SERVICE_CATEGORY from service_data "
				+ " inner join service_category on service_category.id = service_data.SERVICE_CATEGORY "
				+ " where service_data.phone ='"+phone+"'";
		List<ActiveSearches> activeSearch = jdbcTemplate.query(query, new  BeanPropertyRowMapper(ActiveSearches.class));
		return activeSearch;
	}
}
