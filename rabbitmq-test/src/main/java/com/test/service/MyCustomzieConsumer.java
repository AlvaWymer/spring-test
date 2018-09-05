package com.test.service;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyCustomzieConsumer
{
	private Logger logger=LoggerFactory.getLogger(MyCustomzieConsumer.class);
	public void consume(Serializable data)
	{
		logger.info("[自定义consumer]捕获到消息,message:{}",data);
	}
}
