package com.ivan.cloud;

import com.ivan.cloud.com.ivan.cloud.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by Ivan.Luo
 * Date: 12/6/2016 10:31 AM
 */
@SpringCloudApplication
// Zuul also supports Histrix
@EnableZuulProxy
public class APIGatewayApplication
{
	public static void main(String[] args)
	{
		new SpringApplicationBuilder(APIGatewayApplication.class).web(true).run(args);
	}

	@Bean
	public AccessFilter accessFilter()
	{
		return new AccessFilter();
	}
}
