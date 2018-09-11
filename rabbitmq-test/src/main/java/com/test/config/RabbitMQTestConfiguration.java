/**
*
* @author joker 
* @date 创建时间：2018年9月4日 下午4:30:51
* 
*/
package com.test.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.service.MyConfirmCallBackFunc;
import com.test.service.MyCustomzieConsumer;
import com.test.service.MyRabbitConsumer;
import com.test.service.MyRabbitMQPubisher;
import com.test.service.MyReturnCallBack;


/**
* 
* @author joker 
* @date 创建时间：2018年9月4日 下午4:30:51
*/
@Configuration
public class RabbitMQTestConfiguration
{
	@Bean
	public ConnectionFactory connectionFactory()
	{
		CachingConnectionFactory cachingConnectionFactory=new CachingConnectionFactory();
		cachingConnectionFactory.setUsername("guest");
		cachingConnectionFactory.setPassword("guest");
		cachingConnectionFactory.setAddresses("localhost");
		cachingConnectionFactory.setPort(5672);
		cachingConnectionFactory.setPublisherConfirms(true);
		cachingConnectionFactory.setPublisherReturns(true);
		return cachingConnectionFactory;
	}
	@Bean
	public ConfirmCallback confirmCallBack()
	{
		return new MyConfirmCallBackFunc();
	}
	@Bean
	public ReturnCallback returnCallBack()
	{
		return new MyReturnCallBack();
	}
	@Bean
	public RabbitTemplate rabbitTemplate()
	{
		RabbitTemplate rabbitTemplate=new RabbitTemplate();
		rabbitTemplate.setConnectionFactory(connectionFactory());
		rabbitTemplate.setConfirmCallback(confirmCallBack());
		rabbitTemplate.setReturnCallback(returnCallBack());
		rabbitTemplate.setMandatory(true);
		return rabbitTemplate;
	}
	@Bean
	public RabbitAdmin rabbitAdmin()
	{
		RabbitAdmin rabbitAdmin=new RabbitAdmin(connectionFactory());
		rabbitAdmin.declareExchange(testExchange());
		return rabbitAdmin;
	}
	@Bean
	public TopicExchange testExchange()
	{
		return new TopicExchange("test");
	}
	@Bean
	public Queue testQueue()
	{
		return new Queue("test");
	}
	@Bean
	public Binding testBinding()
	{
		return BindingBuilder.bind(testQueue()).to(testExchange()).with("test");
	}
	@Bean
	public SimpleMessageListenerContainer container()
	{
		SimpleMessageListenerContainer container=new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setQueues(testQueue());
		container.setMessageListener(consumer());
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//		MessageListenerAdapter adapter=new MessageListenerAdapter();
//		adapter.setDelegate(consumer());
//		adapter.setDefaultListenerMethod("consume");
//		container.setMessageListener(adapter);
		return container;
	}
	@Bean
	public MyRabbitMQPubisher publisher()
	{
		return new MyRabbitMQPubisher();
	}
//	@Bean
//	public MyCustomzieConsumer consumer()
//	{
//		return new MyCustomzieConsumer();
//	}
	@Bean
	public MyRabbitConsumer consumer()
	{
		return new MyRabbitConsumer();
	}
}
