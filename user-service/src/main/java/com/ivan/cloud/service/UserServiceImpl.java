package com.ivan.cloud.service;

import com.ivan.cloud.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan.Luo
 * Date: 12/6/2016 11:06 AM
 */
@Service
public class UserServiceImpl implements UserService
{
	@Override
	public List<User> getUsers()
	{

		List<User> users = new ArrayList<>();
		User u1 = new User();
		u1.setId(1);
		u1.setName("user1");
		users.add(u1);
		User u2 = new User();
		u2.setId(2);
		u2.setName("user2");
		users.add(u2);

		return users;
	}
}
