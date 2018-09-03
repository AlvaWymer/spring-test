package com.tmall.server.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TestParentApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(TestParentApplication.class, args);
	}
}
