package com.ibm.repository;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.bean.EmployeeDetails;

@Repository
public interface UserRepositoryEmployee extends CrudRepository<EmployeeDetails, Integer> {

	@Modifying
	@Transactional
	@Query(value = "update employee_details set email=:email, designation=:designation, phone_number=:phoneNumber"
			+ ", technologies=:technologies where full_name=:employeeName",nativeQuery = true)
	void updateEmployeeByName(@Param(value = "email")String email,@Param(value = "designation") String designation,
			@Param(value = "phoneNumber")String phoneNumber,@Param(value = "technologies") String technologies,
			@Param(value = "employeeName")String employeeName);
	
	@Modifying
	@Transactional
	@Query(value = "delete from employee_details where full_name = :employeeName",nativeQuery = true)
	void deleteByName(@Param (value = "employeeName")String employeeName);
	
	
	

}
