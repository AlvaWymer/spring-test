/**
*
* @author joker 
* @date 创建时间：2018年9月5日 上午8:27:51
* 
*/
package com.test.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

/**
* 
* @author joker 
* @date 创建时间：2018年9月5日 上午8:27:51
*/
public class MySimpleMessageConverter implements MessageConverter
{

	@Override
	public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException
	{
		return null;
	}

	@Override
	public Object fromMessage(Message message) throws MessageConversionException
	{
		return null;
	}

}
