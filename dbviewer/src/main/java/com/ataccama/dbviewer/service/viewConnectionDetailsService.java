package com.ataccama.dbviewer.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface viewConnectionDetailsService {

	List<String> getSchemaList(String name);

	List<String> getTableList(String name);
	List<String> getCoulmnList(String name,String tableName);

}
