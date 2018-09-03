package com.tmall.server.user;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
public class ProviderAApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(ProviderAApplication.class, args);
	}
	
	
}
