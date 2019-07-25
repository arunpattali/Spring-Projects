package com.ataccama.dbviewer.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ataccama.dbviewer.model.AddDbDetails;

public class DataSourceConfig {

	AddDbDetails addDbDetails;
	
	
public DataSourceConfig(AddDbDetails addDbDetails) {
		super();
		this.addDbDetails = addDbDetails;
	}

//	@Bean(name="dsCustom")
	public DataSource dataSource() {
		System.out.println(">>>>>>>>>>>>>>>>>>"+"jdbc:postgresql://"+addDbDetails.getHostName()+":"+addDbDetails.getPort()+"/"+addDbDetails.getDatabaseName()+"?useSSL=false");
		return DataSourceBuilder
				.create()
				.username(addDbDetails.getUserName())
				.password(addDbDetails.getPassword())
				.url("jdbc:postgresql://"+addDbDetails.getHostName()+":"+addDbDetails.getPort()+"/"+addDbDetails.getDatabaseName())
				.driverClassName("org.postgresql.Driver")
				.build();
	}

	/*@Bean(name = "jdbcCustom")
	@Autowired*/
	public JdbcTemplate getjdbcTemplate(@Qualifier("dsCustom") DataSource dsCustom) {
		return new JdbcTemplate(dataSource());
	}
	
	/*@Bean(name="dsCustom")
	public DataSource mainDataSource() {
		return DataSourceBuilder
				.create()
				.username("postgres")
				.password("salsa")
				.url("jdbc:postgresql://localhost:5432/DbViewer")
				.driverClassName("org.postgresql.Driver")
				.build();
	}

	@Bean(name = "jdbcCustom")
	@Autowired
	public JdbcTemplate jdbcTemplate(@Qualifier("dsCustom") DataSource dsCustom) {
		return new JdbcTemplate(dsCustom);
	}*/
}
