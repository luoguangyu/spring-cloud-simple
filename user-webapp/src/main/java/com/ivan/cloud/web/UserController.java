package com.ivan.cloud.web;

import java.util.List;

import com.ivan.cloud.client.UserServiceClient;
import com.ivan.cloud.model.User;
import com.ivan.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{

	@Value("${serverName}")
	private String serverValue;

	@Autowired
	UserService userService;

	@Autowired
	UserServiceClient userServiceClient;

	// use ribbon(load balancer) for HTTP request
	@RequestMapping(value = "/users")
	public ResponseEntity<List<User>> readUserInfo()
	{
		List<User> users = userService.readUserInfo();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// use Feign(which also implements ribbon) for HTTP request
	@RequestMapping(value = "/users-feign")
	public ResponseEntity readUserInfoFeign()
	{
		List<User> users = userServiceClient.getUsers();
		if(users != null)
		{
			return new ResponseEntity(users, HttpStatus.OK);
		}
		return new ResponseEntity("no available users ", HttpStatus.BAD_REQUEST);
	}

	// test distributed-config
	@RequestMapping(value = "/server-value")
	public String getServerValue()
	{
		return this.serverValue;
	}
}
