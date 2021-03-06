package com.ataccama.dbviewer.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataConfig {
	
	@Bean(name="dsCustom")
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
	}

}
