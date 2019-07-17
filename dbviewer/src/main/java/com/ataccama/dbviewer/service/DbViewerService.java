package com.ataccama.dbviewer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ataccama.dbviewer.model.AddDbDetails;

@Service
public interface DbViewerService {
	public ResponseEntity<AddDbDetails> addDbDetails(AddDbDetails addDbDetails);

}
