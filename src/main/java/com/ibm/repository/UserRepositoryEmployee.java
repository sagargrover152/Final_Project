package com.ibm.repository;



import org.springframework.data.repository.CrudRepository;
import com.ibm.bean.EmployeeDetails;

public interface UserRepositoryEmployee extends CrudRepository<EmployeeDetails, Long> {
	
	
	

}
