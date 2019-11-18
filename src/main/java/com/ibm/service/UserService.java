package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bean.EmployeeDetails;
import com.ibm.bean.ProjectDetails;
import com.ibm.repository.UserRepositoryEmployee;
import com.ibm.repository.UserRepositoryProject;

@Service
public class UserService {

	@Autowired
	UserRepositoryEmployee repo;
	
	@Autowired
	UserRepositoryProject repoproject;

	public List<String> findAllNameAndAddress(String str) {
		return repoproject.findAllNameAndAddress(str);
	}

	public Iterable<EmployeeDetails> findAllEmployees() {
		return repo.findAll();
	}

	public void save(ProjectDetails project) {
		// TODO Auto-generated method stub
		repoproject.save(project);
	}
	
	public Iterable<ProjectDetails> findAllProjects() {
		return repoproject.findAll();
	}

	public void updateUser(ProjectDetails proj, String givenName) {
		String clientName = proj.getClientName();
		String projectName = proj.getProjectName();
		String startDate = proj.getStartDate();
		String endDate = proj.getEndDate();
		String city = proj.getCity();
		String country = proj.getCountry();
		String technologies = proj.getTechnologies();
		String teamMembers = proj.getTeamMembers();
		String manager = proj.getManager();
		String priority = proj.getPriority();
		String projectDescription = proj.getProjectDescription();
		repoproject.updatebyname(clientName,projectName,startDate,endDate,city,
				country,technologies,teamMembers,manager,priority,givenName,projectDescription);
		
	}

	public ProjectDetails getProjectDetails(String projectName) {
		// TODO Auto-generated method stub
		return repoproject.findByProjectName(projectName);
	}
	
	
}
