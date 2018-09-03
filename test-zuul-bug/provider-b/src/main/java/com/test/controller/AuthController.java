/**
*
* @author joker 
* @date 创建时间：2018年9月2日 上午8:17:56
* 
*/
package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.AServerFeignService;
import com.test.service.GatewayFeignServiec;

/**
 * 
 * @author joker
 * @date 创建时间：2018年9月2日 上午8:17:56
 */
@RestController
@RequestMapping("/auth")
public class AuthController
{
	@Autowired
	private AServerFeignService aFeignService;
	
	@Autowired
	private GatewayFeignServiec gatewayFeignService;
	
	@RequestMapping("/beginWithSame")
	public String bTestWithAuth()
	{
		return aFeignService.baseTest();
	}
	@RequestMapping("/zuul/beginWithSame")
	public String testByZuul()
	{
		return gatewayFeignService.urlBeginWithSameByZuul();
	}

}
