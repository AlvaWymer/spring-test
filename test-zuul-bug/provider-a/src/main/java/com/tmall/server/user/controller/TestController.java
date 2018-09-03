/**
*
* @author joker 
* @date 创建时间：2018年9月2日 上午8:13:02
* 
*/
package com.tmall.server.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 
* @author joker 
* @date 创建时间：2018年9月2日 上午8:13:02
*/
@RestController
@RequestMapping("/auth")
public class TestController
{
	@RequestMapping("/baseTestUrl")
	public String testSameBeginIndex()
	{
		return "ok";
	}

}
