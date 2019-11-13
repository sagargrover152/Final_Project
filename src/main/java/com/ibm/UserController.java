package com.ibm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	@Autowired
	UserRepository repo;
	
	@RequestMapping("/search")
	void doNothing() {
		
	}
	
	@RequestMapping("/search/{str}")
	List<String> searchData(@PathVariable String str){
		 return repo.findAllNameAndAddress(str);
	}
	
	@RequestMapping("/employee")
	Iterable<Employee_details> getCards(){
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/employee")
	void addEmployee(@RequestBody Employee_details emp) {
		emp.setFullname(emp.getFirstname()+" "+emp.getLastname());
		repo.save(emp);
	}
}
