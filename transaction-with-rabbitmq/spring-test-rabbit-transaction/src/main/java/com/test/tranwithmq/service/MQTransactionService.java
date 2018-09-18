/**
*
* @Description
* @author joker 
* @date 创建时间：2018年9月18日 上午10:19:15
* 
*/
package com.test.tranwithmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.tranwithmq.dao.MessageDao;
import com.test.tranwithmq.spi.IMessageServerFeignServiec;

/**
* 
* @When
* @Description
* @Detail
* @author joker 
* @date 创建时间：2018年9月18日 上午10:19:15
*/
@Service
public class MQTransactionService
{
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private UserService userService;
	@Autowired
	private IMessageServerFeignServiec messageServerFeignServiec;
	
	@Transactional(rollbackFor=Exception.class)
	public String testRabbitMqTransaction(String detail)
	{
		//插入本地消息表
		Integer localMessageValidCount = messageDao.insert(detail);
		if(localMessageValidCount<=0)
		{
			return "fail";
		}
		//通知远程服务,添加消息
		try
		{
			Integer remoteMessageValidCount = messageServerFeignServiec.addMessage(detail);
			if(remoteMessageValidCount<=0)
			{
				throw new RuntimeException("手动抛异常回滚:远程通知服务器失败,插入数据失败");
			}
		} catch (Exception e)
		{
			throw new RuntimeException("手动抛异常回滚:远程通知服务器失败",e);
		}
		//执行本地业务,简单演示demo,所以传入的值和索要解析的值是无关的
		Integer logicValidCount = userService.insert("joker");
		if(logicValidCount<=0)
		{
			throw new RuntimeException("手动抛异常回滚:本地执行业务失败");
		}
		//调用其他服务的接口
		
		
		//通知远程服务器更新状态
		Integer updateStautsValidCount = messageServerFeignServiec.updateMsgStatus((long) detail.hashCode(), 1);
		if(updateStautsValidCount<=0)
		{
			throw new RuntimeException("手动抛异常回滚:远程更新消息状态失败");
		}
		return "succes";
	}

}
