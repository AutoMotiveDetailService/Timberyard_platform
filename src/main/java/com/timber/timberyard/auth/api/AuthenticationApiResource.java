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

import com.timber.timberyard.auth.service.SecurityService;

@RestController
@RequestMapping(value = "/user")
public class AuthenticationApiResource {
	
	@Autowired
    private SecurityService securityService;

	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	 public String authenticate(@QueryParam("username") final String username, @QueryParam("password") final String password) {
		 
		 /*final Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
	        final Authentication authenticationCheck = this.customAuthenticationProvider.authenticate(authentication);*/
		 final Boolean success = securityService.autologin(username, password);
	     
		if(success) {
			return "login successfull";
		}
		return "login failed";
		 
	 }
}
