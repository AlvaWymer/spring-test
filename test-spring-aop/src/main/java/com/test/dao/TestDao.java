/**
*
* @author joker 
* @date 创建时间：2018年9月11日 下午3:28:40
* 
*/
package com.test.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* 
* @author joker 
* @date 创建时间：2018年9月11日 下午3:28:40
*/
@Mapper
public interface TestDao
{
	@Insert("insert into us values (#{id},#{name},#{age})")
	void insert(@Param("id")Integer id,@Param("name")String name,@Param("age")Integer age);
	
	
	@Insert("insert into user values (#{id},#{name}) ")
	void testDoLocal(@Param("id")Integer id,@Param("name")String name);

}
