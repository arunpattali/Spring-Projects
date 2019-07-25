package com.ataccama.dbviewer.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ataccama.dbviewer.model.AddDbDetails;

@Service
public interface DbViewerService {
	public ResponseEntity<String> addDbDetails(AddDbDetails addDbDetails);
	public List<AddDbDetails> getDetails();
	public void deleteDbDetails(String name);
	public void editDetails(@Valid AddDbDetails addDbDetails);

}
