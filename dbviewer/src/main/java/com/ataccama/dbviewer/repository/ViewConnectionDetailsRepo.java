package com.ataccama.dbviewer.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ataccama.dbviewer.config.DataSourceConfig;
import com.ataccama.dbviewer.model.AddDbDetails;
import com.ataccama.dbviewer.repository.mapper.TableMapperForConn;
import com.ataccama.dbviewer.service.viewConnectionDetailsService;

@Repository
public class ViewConnectionDetailsRepo implements viewConnectionDetailsService{

	public ViewConnectionDetailsRepo(JdbcTemplate template) {  
		this.template = template;  
	}  
	JdbcTemplate template;
	
	final String SELECT_QUERY = "SELECT * FROM datasource where name = ?";
	final String SELECT_SCHEMA_QUERY = "SELECT TABLE_NAME FROM information_schema.tables WHERE table_schema = 'public'";
	final String SELECT_TABLE_QUERY = "SELECT schema_name FROM information_schema.schemata";
	final String SELECT_COULMN_QUERY = "SELECT 	COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?";
	
	@Override
	public List<String> getSchemaList(String name) {
		List<AddDbDetails> addDbDetails = template.query(SELECT_QUERY, new TableMapperForConn(), name);
		return getConnection(addDbDetails.get(0)).queryForList(SELECT_SCHEMA_QUERY, String.class);
	}
	
	private JdbcTemplate getConnection(AddDbDetails addDbDetails) {
		DataSourceConfig dataSourceConfig = new DataSourceConfig(addDbDetails);
		return dataSourceConfig.getjdbcTemplate(dataSourceConfig.dataSource());

	}

	@Override
	public List<String> getTableList(String name) {
		List<AddDbDetails> addDbDetails = template.query(SELECT_QUERY, new TableMapperForConn(), name);
		return getConnection(addDbDetails.get(0)).queryForList(SELECT_TABLE_QUERY, String.class);
	}
	
	@Override
	public List<String> getCoulmnList(String name,String tableName) {
		List<AddDbDetails> addDbDetails = template.query(SELECT_QUERY, new TableMapperForConn(), name);
		return getConnection(addDbDetails.get(0)).queryForList(SELECT_COULMN_QUERY,String.class,tableName);
	}

}
