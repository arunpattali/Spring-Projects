package com.ataccama.dbviewer.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ataccama.dbviewer.model.AddDbDetails;
import com.ataccama.dbviewer.service.DbViewerService;

@Repository
public class DbViewerRepo implements DbViewerService{

	@Override
	public ResponseEntity<AddDbDetails> addDbDetails(AddDbDetails addDbDetails) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
