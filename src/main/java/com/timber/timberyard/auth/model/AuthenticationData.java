package com.timber.timberyard.auth.model;

public class AuthenticationData {

	
	@SuppressWarnings("unused")
    private final String username;
    @SuppressWarnings("unused")
    private final Long userId;
    @SuppressWarnings("unused")
    private final String base64EncodedAuthenticationKey;
    
    private final Boolean success;
    
        
	public AuthenticationData(final String username, final Long userId, final String base64EncodedAuthenticationKey, final Boolean success) {
        this.username = username;
        this.userId = userId;
        this.base64EncodedAuthenticationKey = base64EncodedAuthenticationKey;
        this.success = success;
    }
	
	public AuthenticationData(final String base64EncodedAuthenticationKey, final Boolean success) {
		this.userId = null;
		this.username = null;
		this.base64EncodedAuthenticationKey = base64EncodedAuthenticationKey;
		this.success = success;
	}

	public String getUsername() {
		return username;
	}

	public Long getUserId() {
		return userId;
	}

	public String getBase64EncodedAuthenticationKey() {
		return base64EncodedAuthenticationKey;
	}

	public Boolean getSuccess() {
		return success;
	}
	
}
