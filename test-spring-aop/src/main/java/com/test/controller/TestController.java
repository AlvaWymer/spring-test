/**
*
* @author joker 
* @date 创建时间：2018年9月11日 下午1:36:32
* 
*/
package com.test.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.TestService;

/**
* 
* @author joker 
* @date 创建时间：2018年9月11日 下午1:36:32
*/
@RestController
public class TestController
{
//	@Autowired
//	private QueryRunner queryRunner;
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/test")
	public String test() throws SQLException
	{
		
		testService.testLocalBizError();
//		throw new RuntimeException("ttt");
		
		return "ok";
	}
	@RequestMapping(value="/test2")
	public String test2()
	{
		testService.testRemoteError(new Random().nextInt(), "jjjo", new Random().nextInt(10));
		return "ok";
	}

}
