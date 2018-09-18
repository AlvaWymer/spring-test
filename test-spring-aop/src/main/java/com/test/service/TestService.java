/**
*
* @author joker 
* @date 创建时间：2018年9月11日 下午3:55:40
* 
*/
package com.test.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.TestDao;

/**
* 
* @author joker 
* @date 创建时间：2018年9月11日 下午3:55:40
*/
@Service
public class TestService
{
	@Autowired
	private TestDao testDao;
	
	
//	@Transactional
	public void testRemoteNormal(Integer id,String name,Integer age)
	{
		testDao.insert(id, name, age);
	}
//	@Transactional
	public void testRemoteError(Integer id,String name,Integer age)
	{
		testDao.insert(id, name, age);
		throw new RuntimeException("ttt");
	}
	
	
//	@Transactional
	public void testLocalBiz()
	{
		testDao.testDoLocal(new Random().nextInt(), "joker");
	}
//	@Transactional
	public void testLocalBizError()
	{
		testDao.testDoLocal(new Random().nextInt(), "joker");
		//模仿本地出错
		throw new RuntimeException("local biz exception");
	}

}
