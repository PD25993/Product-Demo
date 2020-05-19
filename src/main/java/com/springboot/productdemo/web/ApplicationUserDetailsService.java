package com.springboot.productdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.productdemo.web.user.models.MyUserDetails;
import com.springboot.productdemo.web.user.models.User;
import com.springboot.productdemo.web.user.repositories.UserRepository;

@Service
public class ApplicationUserDetailsService  implements UserDetailsService{
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User userEntity = userRepository.findByUserName(userName);
		if(null == userEntity)
		{
			throw new UsernameNotFoundException("Not found : "+userName);
		}
		
		MyUserDetails myUserDetails = new MyUserDetails(userEntity);
		
		return myUserDetails;
		//return null;
	}
	
	

}
