package com.timber.timberyard.auth.api;

import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timber.timberyard.auth.model.AuthenticationData;
import com.timber.timberyard.auth.model.DefaultToApiJsonSerializer;
import com.timber.timberyard.auth.model.ToApiJsonSerializer;
import com.timber.timberyard.auth.model.User;
import com.timber.timberyard.auth.service.SecurityService;

@RestController
@RequestMapping(value = "/user")
public class AuthenticationApiResource {
	
	@Autowired
    private SecurityService securityService;
	
	@Autowired
	private DefaultToApiJsonSerializer<User> toApiJsonSerializer;

	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	 public String authenticate(@QueryParam("username") final String username, @QueryParam("password") final String password) {
		 
		 final AuthenticationData authenticationData = securityService.autologin(username, password);
	     
		if(authenticationData.getSuccess()) {
			return this.toApiJsonSerializer.serialize(authenticationData);
			}
		return "false";
		 
	 }
}
