package com.viet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viet.entity.userEntity;

public interface userRepository extends JpaRepository<userEntity,  Integer> {
	userEntity findByusername(String username);
}
