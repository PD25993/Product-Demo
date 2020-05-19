package com.springboot.productdemo.web.user.repositories;

import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.productdemo.web.user.models.User;

@ComponentScan(basePackages = "com.springboot.productdemo.web")
public interface UserRepository extends JpaRepository<User, Integer>{
	
	//Optional<User> findByUserName(String userName);
	User findByUserName(String userName);
}
