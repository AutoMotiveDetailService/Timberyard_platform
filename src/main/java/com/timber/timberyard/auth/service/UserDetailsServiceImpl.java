package com.timber.timberyard.auth.service;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.timber.timberyard.auth.model.Role;
import com.timber.timberyard.auth.model.User;
import com.timber.timberyard.auth.repository.UserRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

	
	@Autowired
    private UserRepository  userRepository ;

 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	User user = userRepository.findByUsername(userName);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
