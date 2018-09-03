/**
*
* @author joker 
* @date 创建时间：2018年9月2日 上午8:36:46
* 
*/
package com.test.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* 
* @author joker 
* @date 创建时间：2018年9月2日 上午8:36:46
*/
@FeignClient(name="gateway",configuration=FeignErrorConfiguration.class)
public interface GatewayFeignServiec
{
	@RequestMapping("/auth/testSameBeginIndex")
	String urlBeginWithSameByZuul();
	
	@RequestMapping("/other/testOtherIndex")
	String urlBeginWithDifferentByZuul();
}
