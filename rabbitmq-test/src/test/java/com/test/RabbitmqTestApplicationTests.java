package com.test;

import java.util.HashMap;
import java.util.UUID;

import org.apache.logging.log4j.message.SimpleMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.rabbit.support.PublisherCallbackChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.service.MyRabbitMQPubisher;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTestApplicationTests
{
	@Autowired
	private MyRabbitMQPubisher publisher;

	@Test
	public void contextLoads()
	{
	}

	@Test
	public void testSendMsg()
	{
//		SimpleMessage message=new SimpleMessage("simple test");
//		publisher.publish("test", message);
		HashMap<String, Object>data=new HashMap<>();
		data.put("user", "joker");
//		publisher.publishPojo("asdsss", data);
		publisher.publishPojo("test", "ssss",data);
	}
	@Test
	public void testSendToUnknownExchange()
	{
		HashMap<String, Object>data=new HashMap<>();
		data.put("user", "joker");
		publisher.publishPojo("aaaa", "test", data);
	}
	@Test
	public void testSendToUnknowQueue()
	{
		HashMap<String, Object>data=new HashMap<>();
		data.put("user", "joker");
		publisher.publishPojo("aaaa", data);
	}
	@Test
	public void testNormalSendWith()
	{
		HashMap<String, Object>data=new HashMap<>();
		data.put("user", "joker");
		publisher.publishPojo("test", data);
	}
	@Test
	public void testNormalSendWithCorrelateData()
	{
		CorrelationData data=new CorrelationData();
		data.setId(UUID.randomUUID().toString());
		HashMap<String, Object>map=new HashMap<>();
		map.put("user", "joker");
		publisher.publishePojoWithCorrelationData("test", map, data);
	}
	@Test
	public void testNormalSendAndReceive()
	{
		HashMap<String, Object>map=new HashMap<>();
		map.put("user", "joker");
		Object object = publisher.publishAndReceive("test", map);
		System.out.println(object);
	}
}
