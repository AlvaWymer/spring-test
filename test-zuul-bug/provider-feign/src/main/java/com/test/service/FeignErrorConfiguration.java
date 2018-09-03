/**
*
* @author joker 
* @date 创建时间：2018年9月2日 上午9:54:35
* 
*/
package com.test.service;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

/**
 * 
 * @author joker
 * @date 创建时间：2018年9月2日 上午9:54:35
 */
@Configuration
public class FeignErrorConfiguration
{
	@Bean
	public ErrorDecoder errorDecoder()
	{
		return new ErrorDecoder()
		{

			@Override
			public Exception decode(String methodKey, Response response)
			{
				try
				{
					ObjectMapper objectMapper=new ObjectMapper();
					HashMap map = objectMapper.readValue(response.body().asInputStream(), HashMap.class);
					Exception exception=null;
					System.out.println(map);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				return null;
			}
		};
	}

}
