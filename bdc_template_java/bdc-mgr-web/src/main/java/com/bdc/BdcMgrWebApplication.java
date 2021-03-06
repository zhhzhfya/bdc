package com.bdc;

import java.util.concurrent.CountDownLatch;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @description System Manager main Application
 * @author lishanwei
 * @date 2018年4月6日
 */
@Configuration
@EnableAutoConfiguration
public class BdcMgrWebApplication {

 	private static final Logger logger = Logger.getLogger(BdcMgrWebApplication.class);

	public static void main(String[] args){
		try {
			ApplicationContext ctx = new SpringApplicationBuilder().sources(BdcMgrWebApplication.class).web(true).run(args);
			logger.info("service started!");
			CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
			closeLatch.await();
		} catch (InterruptedException e) {
			logger.info(e.getMessage());
			System.exit(1);
		}
	}

	@Bean
	public CountDownLatch closeLatch() {
		return new CountDownLatch(1);
	}

	@Bean
	@ConfigurationProperties("bdc.druid")
	DataSource dataSource() {
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}
}
