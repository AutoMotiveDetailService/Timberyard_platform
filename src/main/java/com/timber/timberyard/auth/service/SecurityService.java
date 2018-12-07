package com.timber.timberyard.auth.service;

public interface SecurityService {
    String findLoggedInUsername();

    Boolean autologin(String username, String password);
}
