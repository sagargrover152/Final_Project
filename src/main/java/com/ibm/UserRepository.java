package com.ibm;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<Employee_details, Long> {
	
	
	@Query(value = "select fullname from user_details where fullname LIKE %:un% or technologies LIKE %:un%",nativeQuery = true)
	List<String> findAllNameAndAddress(@Param(value = "un") String un);

}
