/**
*
* @author joker 
* @date 创建时间：2018年9月4日 下午4:40:29
* 
*/
package com.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.rabbitmq.client.Channel;

/**
* 
* @author joker 
* @date 创建时间：2018年9月4日 下午4:40:29
*/
public class MyRabbitConsumer implements ChannelAwareMessageListener
{
	Logger log=LoggerFactory.getLogger(MyRabbitConsumer.class);
	@Override
	public void onMessage(Message message, Channel channel) throws Exception
	{
		log.info("[自定义消息转换器捕获到消息],message:{}",message);
		System.out.println(message.getMessageProperties().getDeliveryTag());
//		throw new RuntimeException("test");
		
//		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		//失败,并且放回队列
		channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
		//拒绝,并且将其重新放回队列中
//		channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
	}
}
