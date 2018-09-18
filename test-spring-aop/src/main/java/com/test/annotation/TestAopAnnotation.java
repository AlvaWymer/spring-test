/**
*
* @author joker 
* @date 创建时间：2018年9月12日 下午5:41:28
* 
*/
package com.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* 
* @author joker 
* @date 创建时间：2018年9月12日 下午5:41:28
*/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestAopAnnotation
{	
	String test();
	

}
