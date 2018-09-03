/**
*
* @author joker 
* @date 创建时间：2018年9月2日 上午8:38:46
* 
*/
package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.GatewayFeignServiec;

/**
 * by zuul
 * 
 * @author joker
 * @date 创建时间：2018年9月2日 上午8:38:46
 */
@RestController
public class ZuulController
{
	@Autowired
	private GatewayFeignServiec gatewayFeignService;

	@RequestMapping("/zuul/beginWithSame")
	public String testByThroughZuul()
	{
		return "test by zuul " + "_res:" + gatewayFeignService.urlBeginWithSameByZuul();
	}

	@RequestMapping("/zuul/beginWithDiff")
	public String testDiffThroughZuul()
	{
		return "test by zuul with  and call the diff url begin " + "_res:"
				+ gatewayFeignService.urlBeginWithDifferentByZuul();
	}
}
