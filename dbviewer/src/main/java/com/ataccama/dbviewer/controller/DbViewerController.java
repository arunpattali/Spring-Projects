package com.ataccama.dbviewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ataccama.dbviewer.model.AddDbDetails;
import com.ataccama.dbviewer.service.DbViewerService;

@RestController
public class DbViewerController {
	private DbViewerService dbViewerService;
	
	@Autowired(required = true)
	public void setEmployeeService(DbViewerService dbViewerService) {
	    this.dbViewerService = dbViewerService;
	}
	
	@PostMapping("/adddbconnction")
	public ResponseEntity<AddDbDetails> addDbDetails(@Valid @RequestBody AddDbDetails addDbDetails){
		System.out.println("entered");
		System.out.println("model class" + addDbDetails.getDatabaseName());
		dbViewerService.addDbDetails(addDbDetails);
		return new ResponseEntity<AddDbDetails>(HttpStatus.OK);
	}
	
	@GetMapping("/ping")
	public String ping(){
		return "success";
	}
	
	

}
