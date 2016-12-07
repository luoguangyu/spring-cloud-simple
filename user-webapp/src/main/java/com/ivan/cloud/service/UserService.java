package com.ivan.cloud.service;

import java.util.ArrayList;
import java.util.List;

import com.ivan.cloud.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/*import cloud.simple.service.UserServiceProvider.FeignUserService;*/

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {
	private final Logger logger = Logger.getLogger(getClass());
	 @Autowired	 
	 RestTemplate restTemplate;

	
	// @Autowired
	// FeignUserService feignUserService;
	 
	 private static final String SERVICE_NAME="user-service";
	 
	 @HystrixCommand(fallbackMethod = "fallbackSearchAll")
	 public List<User> readUserInfo() {
	        return restTemplate.getForObject("http://"+SERVICE_NAME+"/users", List.class);
		 //return feignUserService.readUserInfo();
	 }	 
	 private List<User> fallbackSearchAll() {
		 logger.debug("Hystrix handling getUsers");
		 List<User> ls = new ArrayList<User>();
		 User user = new User();
		 user.setName("TestHystrixCommand");
		 user.setId(0);
		 ls.add(user);
		 return ls;
	 }
}
