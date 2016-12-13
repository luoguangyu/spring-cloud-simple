package com.ivan.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by Ivan.Luo
 * Date: 12/6/2016 10:31 AM
 */
@SpringBootApplication
public class OrderServiceApplication
{
	public static void main(String[] args) {
		new SpringApplicationBuilder(OrderServiceApplication.class).web(true).run(args);
	}
}
