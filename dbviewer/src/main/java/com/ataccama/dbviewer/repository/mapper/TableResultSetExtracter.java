package com.ataccama.dbviewer.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.ataccama.dbviewer.model.AddDbDetails;

public class TableResultSetExtracter implements ResultSetExtractor<Object> {

	@Override
	public AddDbDetails extractData(ResultSet rs) throws SQLException {
		AddDbDetails tableDetails = new AddDbDetails();
		tableDetails.setDatabaseName(rs.getString(1));
		tableDetails.setUserName(rs.getString(2));
		tableDetails.setPassword(rs.getString(3));
		tableDetails.setName(rs.getString(4));
		tableDetails.setHostName(rs.getString(5));
		tableDetails.setPort(rs.getInt(6));
		System.out.println("inside TableResultSetExtracter :- extractData()"+rs.getString(1));
		return tableDetails;
	}

}
