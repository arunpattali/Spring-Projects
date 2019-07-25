package com.ataccama.dbviewer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ataccama.dbviewer.service.viewConnectionDetailsService;

@RestController
@RequestMapping("/viewConnection")
public class ViewConnectionDetailsController {
	
	private viewConnectionDetailsService viewService;
	
	@Autowired
	public void viewConnectionDetailsService(viewConnectionDetailsService viewService) {
	    this.viewService = viewService;
	}
	
	@GetMapping("{name}/listSchema")
	public ResponseEntity<List<String>> listSchema(@PathVariable("name") String name){
		List<String> schemaList = viewService.getSchemaList(name);
		return  new ResponseEntity<List<String>>(schemaList,HttpStatus.OK);
	}
	
	@GetMapping("{name}/listTables")
	public ResponseEntity<List<String>> listTables(@PathVariable("name") String name){
		List<String> tableList = viewService.getTableList(name);
		return  new ResponseEntity<List<String>>(tableList,HttpStatus.OK);
	}
	
	@GetMapping("{name}/{tableName}/listCoulms")
	public ResponseEntity<List<String>> listCoulmns(@PathVariable("name") String name,@PathVariable("tableName") String tableName){
		List<String> tableList = viewService.getCoulmnList(name,tableName);
		return  new ResponseEntity<List<String>>(tableList,HttpStatus.OK);
	}

}
