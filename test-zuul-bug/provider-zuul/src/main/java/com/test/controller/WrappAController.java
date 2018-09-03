package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.AServerFeignService;

@RestController
public class WrappAController
{

	@Autowired
	private AServerFeignService aFeignService;

	@RequestMapping("/auth/testWithSameBegin")
	public String testSameBegin()
	{
		return "zuul test with the same url begin :/auth " + "_" + aFeignService.baseTest();
	}

	@RequestMapping("/other/testWithDifferentBegin")
	public String testDiffBegin()
	{
		return "zuul test with DIFF url begin with :/other " + "_res:" + aFeignService.baseTest();
	}
}
