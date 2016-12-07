package com.ivan.cloud.client;

import com.ivan.cloud.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan.Luo
 * Date: 12/7/2016 3:34 PM
 */
@Component
public class UserServiceClientFallBack implements UserServiceClient
{
	private final Logger logger = Logger.getLogger(getClass());

	@Override
	public List<User> getUsers()
	{
		logger.debug("Hystrix handling getUsers");
		return null;
	}
}
