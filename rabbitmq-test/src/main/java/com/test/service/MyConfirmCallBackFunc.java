/**
*
* @author joker 
* @date 创建时间：2018年9月4日 下午6:31:29
* 
*/
package com.test.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import lombok.extern.slf4j.Slf4j;

/**
* 
* @author joker 
* @date 创建时间：2018年9月4日 下午6:31:29
*/
@Slf4j
public class MyConfirmCallBackFunc implements ConfirmCallback
{
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause)
	{
		if(ack)
		{
			log.info("[消息队列确认服务],确认消息已经发送成功");
		}else {
			log.info("[消息队列确认服务],服务发送失败,原因:{}",cause);
		}
	}

}
