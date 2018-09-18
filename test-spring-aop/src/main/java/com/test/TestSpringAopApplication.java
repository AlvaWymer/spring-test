package com.test;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ImportResource("classpath:config/tranasaction.xml")
public class TestSpringAopApplication
{

//	@Bean
//	public DataSourceTransactionManager dataSourceTransactionManager()
//	{
//		DataSourceTransactionManager manager = new DataSourceTransactionManager();
//		manager.setDataSource(dataSource());
//		return manager;
//	}

	@Bean(name="dataSource")
	public DataSource dataSource()
	{
		DruidDataSource dataSource = new DruidDataSource();

		dataSource.setUrl("jdbc:mysql://localhost/test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSource;
	}
	@Bean(name="txManager")
	public DataSourceTransactionManager transactionManager()
	{
		DataSourceTransactionManager manager=new DataSourceTransactionManager();
		manager.setDataSource(dataSource());
		return manager;
	}

	@Bean
	public QueryRunner queryRunner()
	{
		return new QueryRunner(dataSource());
	}

	public static void main(String[] args)
	{
		SpringApplication.run(TestSpringAopApplication.class, args);
	}
}
