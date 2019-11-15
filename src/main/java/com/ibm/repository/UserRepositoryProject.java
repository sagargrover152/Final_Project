package com.ibm.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.bean.ProjectDetails;

public interface UserRepositoryProject extends CrudRepository<ProjectDetails, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "update project_details set city=:city,clientName=:clientName"
			+ ",country=:country,endDate=:endDate,manager=:manager,priority=:priority,"
			+ "projectName=:projectName,startDate=:startDate,teamMembers=:teamMembers,"
			+ "technologies=:technologies WHERE projectName=:givenName",nativeQuery = true)
	void updatebyname(@Param(value = "clientName") String clientName,
			@Param(value = "projectName")String projectName,
			@Param(value = "startDate")String startDate,
			@Param(value = "endDate")String endDate,
			@Param(value = "city")String city,
			@Param(value = "country")String country,
			@Param(value = "technologies")String technologies,
			@Param(value = "teamMembers")String teamMembers,
			@Param(value = "manager")String manager,
			@Param(value = "priority")String priority,
			@Param(value = "givenName")String givenName);
		
}
