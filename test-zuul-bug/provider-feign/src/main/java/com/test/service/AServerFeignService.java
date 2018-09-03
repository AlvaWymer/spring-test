/**
*
* @author joker 
* @date 创建时间：2018年9月2日 上午8:14:55
* 
*/
package com.test.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* 
* @author joker 
* @date 创建时间：2018年9月2日 上午8:14:55
*/
@FeignClient(name="A")
public interface AServerFeignService
{
	@RequestMapping("/auth/baseTestUrl")
	String baseTest();
}
