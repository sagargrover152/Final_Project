package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bean.EmployeeDetails;
import com.ibm.bean.ProjectDetails;
import com.ibm.service.EmployeeService;
import com.ibm.service.ProjectService;


@RestController
public class UserController {

	@Autowired
	ProjectService projService;
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping("/employee")
	Iterable<EmployeeDetails> getCards(){
		return empService.findAllEmployees();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/employee")
	void addEmployee(@RequestBody EmployeeDetails employee) {
		empService.save(employee);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/employee/{employeeName}")
	void updateEmployee(@RequestBody EmployeeDetails employee,@PathVariable String employeeName) {
		empService.updateEmployee(employee,employeeName);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/employee/{employeeName}")
	void delEmployee(@PathVariable String employeeName) {
		empService.delEmployee(employeeName);
	}
	
	@RequestMapping("/availableEmployee")
	Iterable<EmployeeDetails> getAvailableEmployees(){
		return empService.getAvailableEmployees();
	}
	
	@RequestMapping("/employee/{projectName}")
	Iterable<EmployeeDetails> getCards(@PathVariable String projectName){
		return empService.findAllEmployeesInProject(projectName);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/employee/unassign/{empName}")
	void unAssignProject(@RequestBody EmployeeDetails employee,@PathVariable String empName) {
		empService.unAssignProject(employee,empName);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/availableEmployee/{projectName}")
	void assignProject(@RequestBody EmployeeDetails employee,@PathVariable String projectName) {
		empService.assignProject(employee,projectName);
	}
	
	@RequestMapping("/search")
	String doNothing() {
		return "testing api...";
	}
	
	@RequestMapping("/search/{str}")
	List<String> searchData(@PathVariable String str){
		 return projService.findAllProject(str);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/project")
	void addProject(@RequestBody ProjectDetails project) {
		projService.save(project);
	}
	
	@RequestMapping("/project")
	Iterable<ProjectDetails> getProject(){
		return projService.findAllProjects();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/project/{projectName}")
	void updateProject(@RequestBody ProjectDetails proj, @PathVariable String projectName) {
		projService.updateProject(proj,projectName);
	}
	
	@RequestMapping("/project/{projectName}")
	ProjectDetails getProjectDetails(@PathVariable String projectName){
		return projService.getProjectDetails(projectName);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/project/{projectName}")
	void delProject(@PathVariable String projectName) {
		projService.delProject(projectName);
		empService.resetEmployeeWithDeleteProject(projectName);
	}
}
