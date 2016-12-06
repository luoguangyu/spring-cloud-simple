package com.ivan.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Ivan.Luo
 * Date: 12/6/2016 10:31 AM
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication
{
	public static void main(String[] args) {
		new SpringApplicationBuilder(UserServiceApplication.class).web(true).run(args);
	}
}
