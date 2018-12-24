package com.timber.timberyard.auth.service;

import java.util.Optional;

import com.timber.timberyard.auth.model.Office;
import com.timber.timberyard.auth.model.User;

public interface UserService {
    User save(User user);

    User findByUsername(String username);
    
    Office saveOffice(Office office);
    
    Office findByOfficeId(Long officeId);

	Optional<Office> getOffice(Long officeId);
}
