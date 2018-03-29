package com.bizconnect.model.usermgmt;

import com.bizconnect.clib.model.BaseResponse;

public class LoginResponse extends BaseResponse{

	String secureToken;

	public String getSecureToken() {
		return secureToken;
	}

	public void setSecureToken(String secureToken) {
		this.secureToken = secureToken;
	}
	
	
}
