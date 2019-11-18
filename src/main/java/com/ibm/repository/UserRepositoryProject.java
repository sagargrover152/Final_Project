package com.ibm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.bean.ProjectDetails;

public interface UserRepositoryProject extends CrudRepository<ProjectDetails, String> {
	
	@Modifying
	@Transactional
	@Query(value = "update project_details set city=:city,client_name=:clientName"
			+ ",country=:country,end_date=:endDate,manager=:manager,priority=:priority,"
			+ "project_name=:projectName,start_date=:startDate,team_members=:teamMembers,"
			+ "technologies=:technologies,project_description=:projectDescription WHERE project_name=:givenName",nativeQuery = true)
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
			@Param(value = "givenName")String givenName,
			@Param(value = "projectDescription")String projectDescription);
	
	@Query(value = "select project_name from project_details where project_name LIKE %:un%",nativeQuery = true)
	List<String> findAllNameAndAddress(@Param(value = "un") String un);

	ProjectDetails findByProjectName(String projectName);
		
}
