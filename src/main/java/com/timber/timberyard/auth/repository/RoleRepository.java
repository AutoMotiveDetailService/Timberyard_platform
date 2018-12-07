package com.timber.timberyard.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timber.timberyard.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
