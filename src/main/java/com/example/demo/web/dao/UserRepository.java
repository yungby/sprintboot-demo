package com.example.demo.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.web.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);

	User findByUserNameOrEmail(String username, String email);
}