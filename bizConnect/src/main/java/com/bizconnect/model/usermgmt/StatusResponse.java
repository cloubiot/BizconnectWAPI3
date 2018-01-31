package com.bizconnect.model.usermgmt;

import com.bizconnect.clib.model.BaseResponse;

public class StatusResponse extends BaseResponse{

	boolean matchFound;

	public boolean isMatchFound() {
		return matchFound;
	}

	public void setMatchFound(boolean matchFound) {
		this.matchFound = matchFound;
	}
	
	
}
