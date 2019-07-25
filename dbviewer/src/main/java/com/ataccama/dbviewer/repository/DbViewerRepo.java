package com.ataccama.dbviewer.repository;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ataccama.dbviewer.config.DataSourceConfig;
import com.ataccama.dbviewer.model.AddDbDetails;
import com.ataccama.dbviewer.repository.mapper.TableMapper;
import com.ataccama.dbviewer.service.DbViewerService;

@Repository
public class DbViewerRepo implements DbViewerService {

	public DbViewerRepo(JdbcTemplate template) {  
		this.template = template;  
	}  
	JdbcTemplate template;

	final String INSERT_QUERY = "INSERT INTO datasource(databaseName, username,password,name,hostName,port) VALUES(?,?,?,?,?,?)";
	final String DELETE_QUERY = "DELETE FROM datasource WHERE name = ?";
	final String UPDATE_QUERY = "UPDATE datasource set databaseName= ? ,username=?,password=?,hostName=?,port=? WHERE name = ?";
	@Override
	public ResponseEntity<String> addDbDetails(AddDbDetails addDbDetails) {
		template.update(INSERT_QUERY, addDbDetails.getDatabaseName(), addDbDetails.getUserName(),
				addDbDetails.getPassword(), addDbDetails.getName(), addDbDetails.getHostName(), addDbDetails.getPort());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public List<AddDbDetails> getDetails() {

		String sql = "SELECT * FROM datasource";
		return template.query(sql, new TableMapper());

	}

	@Override
	public void deleteDbDetails(String name) {
		template.update(DELETE_QUERY, name);		
	}

	@Override
	public void editDetails(@Valid AddDbDetails addDbDetails) {
		template.update(UPDATE_QUERY,addDbDetails.getDatabaseName(), addDbDetails.getUserName(),
				addDbDetails.getPassword(),addDbDetails.getHostName(), addDbDetails.getPort(), addDbDetails.getName());
	}

}
