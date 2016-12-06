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
		User u = new User();
		List<User> users = new ArrayList<>();
		u.setId(1);
		u.setName("user1");
		users.add(u);
		u.setId(2);
		u.setName("user2");
		users.add(u);

		return users;
	}
}
