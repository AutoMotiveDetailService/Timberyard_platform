package com.timber.timberyard.auth.service;

import com.timber.timberyard.auth.model.AuthenticationData;

public interface SecurityService {
    String findLoggedInUsername();

    AuthenticationData autologin(String username, String password);
}
