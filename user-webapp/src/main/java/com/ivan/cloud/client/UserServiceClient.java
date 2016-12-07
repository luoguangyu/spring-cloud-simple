package com.ivan.cloud.client;

import com.ivan.cloud.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Ivan.Luo
 * Date: 12/7/2016 3:19 PM
 */
@FeignClient(value = "user-service", fallback = UserServiceClientFallBack.class)
public interface UserServiceClient
{
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	List<User> getUsers();
}
