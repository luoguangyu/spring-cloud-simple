package com.ivan.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Ivan.Luo
 * Date: 12/6/2016 10:25 AM
 */
@EnableEurekaServer
@SpringBootApplication
public class Application
{
	public static void main(String[] args)
	{
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
}
