/**
*
* @author joker 
* @date 创建时间：2018年9月2日 上午9:15:41
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
 * @date 创建时间：2018年9月2日 上午9:15:41
 */
@RequestMapping("/other")
@RestController
public class OtherController
{
	@Autowired
	private AServerFeignService aFeignService;

	@RequestMapping("/testOtherIndex")
	public String testByOtherBeginIndex()
	{
		return aFeignService.baseTest();
	}
}
