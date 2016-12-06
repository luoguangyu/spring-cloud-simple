package com.ivan.cloud.web;

import com.ivan.cloud.model.User;
import com.ivan.cloud.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Ivan.Luo
 * Date: 12/6/2016 10:30 AM
 */
@RestController
public class UserController
{
	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient client;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add(@RequestParam Integer a, @RequestParam Integer b)
	{
		logger.debug("in add method");
		ServiceInstance instance = client.getLocalServiceInstance();
		Integer r = a + b;
		logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
		return r;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers()
	{
		logger.debug("getting all users");
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.debug("/users, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());

		return userService.getUsers();
	}
}
