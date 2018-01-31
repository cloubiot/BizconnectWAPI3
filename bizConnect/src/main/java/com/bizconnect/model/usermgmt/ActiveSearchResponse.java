package com.bizconnect.model.usermgmt;

import java.util.List;

import com.bizconnect.clib.model.BaseResponse;

public class ActiveSearchResponse extends BaseResponse{

	List<ActiveSearches> activeSearches;

	public List<ActiveSearches> getActiveSearches() {
		return activeSearches;
	}

	public void setActiveSearches(List<ActiveSearches> activeSearches) {
		this.activeSearches = activeSearches;
	}
	
	
}
