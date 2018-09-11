/**
*
* @author joker 
* @date 创建时间：2018年9月4日 下午4:29:42
* 
*/
package com.test.service;

import java.io.Serializable;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.rabbit.support.RabbitExceptionTranslator;
import org.springframework.beans.factory.annotation.Autowired;

/**
* 
* @author joker 
* @date 创建时间：2018年9月4日 下午4:29:42
*/
public class MyRabbitMQPubisher
{
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void publish(String routingKey,Serializable data)
	{
		rabbitTemplate.convertAndSend("test", "test", data);
	}
	
	public void publishPojo(String routingKey,Serializable data)
	{
		rabbitTemplate.convertAndSend("test", routingKey,data);
	}
	
	
	public void publishPojo(String exchange,String routingKey,Serializable data)
	{
		rabbitTemplate.convertAndSend(exchange, routingKey,data);
	}
	
	public void publishePojoWithCorrelationData(String routingKey,Object obj,CorrelationData data)
	{
		rabbitTemplate.convertAndSend("test","test",obj,data);
	}
	
	public Object publishAndReceive(String routingKey,Object ob)
	{
		return rabbitTemplate.convertSendAndReceive(routingKey, ob);
	}
}
