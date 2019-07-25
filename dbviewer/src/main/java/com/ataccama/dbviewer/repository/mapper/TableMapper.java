package com.ataccama.dbviewer.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ataccama.dbviewer.model.AddDbDetails;

public class TableMapper implements RowMapper<AddDbDetails>{

	@Override
	public AddDbDetails mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		TableResultSetExtracter Extracter = new TableResultSetExtracter();
		return Extracter.extractData(rs);
	}

}
