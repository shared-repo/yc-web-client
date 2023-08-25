package com.demoweb.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demoweb.dao.DataSourceAccountDao;
import com.demoweb.dao.JdbcAccountDao;
import com.demoweb.dao.JdbcTemplateAccountDao;
import com.demoweb.service.AccountServiceImpl;

@Configuration
public class RootConfiguration {
	
	@Bean
	public BasicDataSource dbcpDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/demoweb");
		dataSource.setUsername("devuserone");
		dataSource.setPassword("devuserone");
		dataSource.setMaxTotal(10);
		dataSource.setMaxIdle(5);
		dataSource.setMaxWaitMillis(-1);
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		// JdbcTemplate jdbcTemplate = new JdbcTemplate(dbcpDataSource()); // 생성자 주입
		JdbcTemplate jdbcTemplate = new JdbcTemplate(); 
		jdbcTemplate.setDataSource(dbcpDataSource()); // 세터주입 ( bean 생성 메서드 호출 -> getBean() 과 같은 의미)
	
		return jdbcTemplate;
	}
	
	@Bean
	public JdbcAccountDao jdbcAccountDao() {
		return new JdbcAccountDao();
	}
	
	@Bean 
	DataSourceAccountDao dataSourceAccountDao() {
		DataSourceAccountDao accountDao = new DataSourceAccountDao();
		accountDao.setDataSource(dbcpDataSource());
		return accountDao;
	}
	
	@Bean
	public JdbcTemplateAccountDao jdbcTemplateAccountDao() {
		JdbcTemplateAccountDao accountDao = new JdbcTemplateAccountDao();
		accountDao.setJdbcTemplate(jdbcTemplate());
		return accountDao;
	}
	
	@Bean
	public AccountServiceImpl accountService() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		// accountService.setAccountDao(jdbcAccountDao());
		// accountService.setAccountDao(dataSourceAccountDao());
		accountService.setAccountDao(jdbcTemplateAccountDao());
		return accountService;
	}

}






