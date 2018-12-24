package com.timber.timberyard.auth.api;

import java.util.Optional;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timber.timberyard.auth.model.AppUser;
import com.timber.timberyard.auth.model.DefaultToApiJsonSerializer;
import com.timber.timberyard.auth.model.Office;
import com.timber.timberyard.auth.model.User;
import com.timber.timberyard.auth.service.SecurityService;
import com.timber.timberyard.auth.service.UserService;
import com.timber.timberyard.auth.validator.UserValidator;


@RestController
public class UserController {
	
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private DefaultToApiJsonSerializer<User> toApiJsonSerializer;

    @RequestMapping(value = "/org/registration", method = RequestMethod.POST)
    public String registration(@RequestBody Office officeForm, BindingResult bindingResult, Model model) {

    	Office office = userService.saveOffice(officeForm);
        return this.toApiJsonSerializer.serialize(office);
    }

    @RequestMapping(value = "/org/office", method = RequestMethod.GET)
    public String getOffice(@QueryParam("officeId") final Long officeId) {

    	Optional<Office> office = userService.getOffice(officeId);
        return this.toApiJsonSerializer.serialize(office);
    }
    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public String registration(@RequestBody User userForm, BindingResult bindingResult, Model model) {
        //userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        User user = userService.save(userForm);
        AppUser auser = new AppUser(user.getId(), user.getUsername(),null);
        
        return this.toApiJsonSerializer.serialize(auser);
    }
}

