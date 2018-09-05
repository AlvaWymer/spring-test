/**
*
* @author joker 
* @date 创建时间：2018年9月4日 下午6:33:34
* 
*/
package com.test.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;

import lombok.extern.slf4j.Slf4j;

/**
* 
* @author joker 
* @date 创建时间：2018年9月4日 下午6:33:34
*/
//失败后调用
@Slf4j
public class MyReturnCallBack implements ReturnCallback
{
	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey)
	{
		log.info("[失败时候调用消息],message:{},replyCode:{},replyText:{},exchange:{}",message,replyCode,replyText,exchange);
	}
}
