/**
*
* @author joker 
* @date 创建时间：2018年9月2日 上午9:14:13
* 
*/
package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.AServerFeignService;

/**
 * 
 * @author joker
 * @date 创建时间：2018年9月2日 上午9:14:13
 */
@RestController
@RequestMapping("/auth")
public class SameAuthController
{
	@Autowired
	private AServerFeignService aFeignService;

	@RequestMapping("/testSameBeginIndex")
	public String testBySameIndex()
	{
		return aFeignService.baseTest();
	}

}
