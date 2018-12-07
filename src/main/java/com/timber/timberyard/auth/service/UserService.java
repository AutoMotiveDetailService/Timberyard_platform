package com.timber.timberyard.auth.service;

import com.timber.timberyard.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
