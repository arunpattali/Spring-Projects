package com.ataccama.dbviewer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ataccama.dbviewer.model.AddDbDetails;
import com.ataccama.dbviewer.service.DbViewerService;

@RestController
@RequestMapping("/dbConnection")
public class ConnectionDetialsController {
	
	private DbViewerService dbViewerService;
	
	@Autowired
	public void DbViewerService(DbViewerService dbViewerService) {
	    this.dbViewerService = dbViewerService;
	}
	
	@PostMapping("/adddbconnction")
	public ResponseEntity<String> addDbDetails(@Valid @RequestBody AddDbDetails addDbDetails){
		dbViewerService.addDbDetails(addDbDetails);
		return new ResponseEntity<String>("inserted successfully",HttpStatus.OK);
	}
	@PutMapping("/editdbconnction")
	public ResponseEntity<String> editDbDetails(@Valid @RequestBody AddDbDetails addDbDetails){
		dbViewerService.editDetails(addDbDetails);
		return new ResponseEntity<String>("edited successfullt",HttpStatus.OK);
	}
	
	@GetMapping("/getDetails")
	public ResponseEntity<List<AddDbDetails>> getDetails(){
		List<AddDbDetails> addDbDetails = dbViewerService.getDetails();
		return  new ResponseEntity<List<AddDbDetails>>(addDbDetails,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{dbname}")
	public ResponseEntity<String> deleteDbDetails(@PathVariable("dbname") String name ){
		dbViewerService.deleteDbDetails(name);
		return  new ResponseEntity<String>("deleted Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/ping")
	public String ping(){
		return "success";
	}

}
