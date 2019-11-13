package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bean.EmployeeDetails;
import com.ibm.bean.ProjectDetails;
import com.ibm.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping("/search")
	void doNothing() {
		
	}
	
	@RequestMapping("/search/{str}")
	List<String> searchData(@PathVariable String str){
		 return service.findAllNameAndAddress(str);
	}
	
	@RequestMapping("/employee")
	Iterable<EmployeeDetails> getCards(){
		return service.findAllEmployees();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/project")
	void addProject(@RequestBody ProjectDetails project) {
		service.save(project);
	}
	
	@RequestMapping("/project")
	Iterable<ProjectDetails> getProject(){
		return service.findAllProjects();
	}
}
