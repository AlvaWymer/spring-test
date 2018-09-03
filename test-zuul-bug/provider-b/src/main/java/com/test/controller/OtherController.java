/**
*
* @author joker 
* @date 创建时间：2018年9月2日 上午8:19:59
* 
*/
package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.AServerFeignService;
import com.test.service.GatewayFeignServiec;

/**
 * different begin url
 * 
 * @author joker
 * @date 创建时间：2018年9月2日 上午8:19:59
 */
@RequestMapping(value = "/other")
@RestController
public class OtherController
{
	@Autowired
	private AServerFeignService aFeignService;
	@Autowired
	private GatewayFeignServiec gatewayService;

	@RequestMapping(value ="/testWithDiffIndex")
	public String testOtherBeginIndex()
	{
		return aFeignService.baseTest();
	}
	@RequestMapping(value="/zuul/testWithDiffIndex")
	public String testWithDiffUrlBeginIndex()
	{
		return gatewayService.urlBeginWithDifferentByZuul();
	}
}
