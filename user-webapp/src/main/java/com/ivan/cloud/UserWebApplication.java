package com.ivan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import feign.Feign;
import feign.Logger;
import feign.Request;

@SpringBootApplication
// enable both register and discovery on/from Eureka
@EnableEurekaClient
// enable Hystrix
@EnableCircuitBreaker
// needed by Feign only, for ribbon no need this annotation
@EnableFeignClients
public class UserWebApplication
{

	public static void main(String[] args) throws Exception {
		SpringApplication.run(UserWebApplication.class, args);
	}
	// below used for Ribbon --------------
	// tell spring to use load balance, restTemplate will use Ribbon to get the server address
	// pull server address list from eureka then do the load balance
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	// feign (declarative webservice, use interface defination)also uses ribbon
	// below used for Feign --------------
	/*
	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}

	@Bean
	public Logger.Level feignLogger() {
		return Logger.Level.FULL;
	}

	private static final int FIVE_SECONDS = 5000;

	@Bean
	public Request.Options options() {
		return new Request.Options(FIVE_SECONDS, FIVE_SECONDS);
	}
	*/
}
