package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bean.EmployeeDetails;
import com.ibm.repository.UserRepositoryEmployee;

@Service
public class EmployeeService {

	@Autowired
	UserRepositoryEmployee empRepo;
	
	
	public void save(EmployeeDetails employee) {
		employee.setFullName(employee.getFirstName()+" "+employee.getLastName());
		empRepo.save(employee);
	}

	public Iterable<EmployeeDetails> findAllEmployees() {
		return empRepo.findAll();
	}

	public void updateEmployee(EmployeeDetails employee, String employeeName) {
		// TODO Auto-generated method stub
		String email = employee.getEmail();
		String designation = employee.getDesignation();
		String phoneNumber = employee.getPhoneNumber();
		String technologies = employee.getTechnologies();
		empRepo.updateEmployeeByName(email,designation,phoneNumber,technologies,employeeName);
	}

	public void delEmployee(String employeeName) {
		// TODO Auto-generated method stub
		empRepo.deleteByName(employeeName);
	}

}
