/**
*
* @author joker 
* @date 创建时间：2018年9月11日 下午12:26:08
* 
*/
package com.test.aop;

import java.sql.SQLException;
import java.util.Random;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.test.annotation.TestAopAnnotation;
import com.test.dao.TestDao;
import com.test.service.TestService;

/**
 * 
 * @author joker
 * @date 创建时间：2018年9月11日 下午12:26:08
 */
@Aspect
@Component
public class TestAop
{
	@Pointcut(value = "execution(* com.test.controller..*.test(..))")
	public void test1(){}
	
	@Pointcut(value="@annotation(com.test.annotation.TestAopAnnotation)")
	public void test2() {}

	// @Autowired
	// private QueryRunner queryRunner;
	@Autowired
	private TestService testService;

	@Before(value="test2() && @annotation(test)")
	public void test2GetAnnotation(TestAopAnnotation test)
	{
		System.out.println(test.test());
	}
//	@Around(value = "test2()")
	public String test(ProceedingJoinPoint joinpoint) throws SQLException
	{
		System.out.println("before");
		// String sql="insert into us values (?,?,?) ";
		// queryRunner.insert(sql, new ScalarHandler<>(),new Object[] {new
		// Random().nextInt(),"joker",1});
		testService.testRemoteNormal(new Random().nextInt(), "joker", new Random().nextInt(10));
		// TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		// throw new RuntimeException("test");
		try
		{
			joinpoint.proceed();
		} catch (Throwable e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println("after");
		// throw new RuntimeException("ceshi");
		//
		return "aop";
	}

}
