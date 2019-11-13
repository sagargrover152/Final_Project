package com.ibm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ibm.bean.EmployeeDetails;

public interface UserRepositoryEmployee extends CrudRepository<EmployeeDetails, Long> {
	
	
	@Query(value = "select fullname from employee_details where fullname LIKE %:un% or technologies LIKE %:un%",nativeQuery = true)
	List<String> findAllNameAndAddress(@Param(value = "un") String un);

}
