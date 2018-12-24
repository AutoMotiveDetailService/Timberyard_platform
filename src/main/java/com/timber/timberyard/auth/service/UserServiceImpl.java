package com.timber.timberyard.auth.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.timber.timberyard.auth.model.Office;
import com.timber.timberyard.auth.model.User;
import com.timber.timberyard.auth.repository.OfficeRepository;
import com.timber.timberyard.auth.repository.RoleRepository;
import com.timber.timberyard.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        user.setOfficeId(user.getOfficeId());
       return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public Office saveOffice(Office office) {
		return officeRepository.save(office);
	}

	@Override
	public Office findByOfficeId(Long officeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Office> getOffice(Long officeId) {
		Optional<Office> office = officeRepository.findById(officeId);
		return office;
	}
}