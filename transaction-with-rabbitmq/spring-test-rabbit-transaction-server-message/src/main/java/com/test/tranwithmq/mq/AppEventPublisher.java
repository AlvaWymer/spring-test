/**
*
* @Description
* @author joker 
* @date 创建时间：2018年9月18日 下午1:18:47
* 
*/
package com.test.tranwithmq.mq;

import java.io.Serializable;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @When
 * @Description
 * @Detail
 * @author joker
 * @date 创建时间：2018年9月18日 下午1:18:47
 */
public class AppEventPublisher
{
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void publishe(AppEvent event)
	{
		this.rabbitTemplate.convertAndSend(event.getType(), event);
	}
	
	public static class AppEvent
	{
		private Serializable data;
		private String id;
		private String type;
		//0 新建 1准备 2发送成功 3发送失败 4消费成功
		private Integer status;
		
		public Serializable getData()
		{
			return data;
		}

		public void setData(Serializable data)
		{
			this.data = data;
		}

		public String getId()
		{
			return id;
		}

		public void setId(String id)
		{
			this.id = id;
		}

		public String getType()
		{
			return type;
		}

		public void setType(String type)
		{
			this.type = type;
		}

		public Integer getStatus()
		{
			return status;
		}

		public void setStatus(Integer status)
		{
			this.status = status;
		}

	}


	
}
