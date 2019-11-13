package com.ibm.repository;

import org.springframework.data.repository.CrudRepository;

import com.ibm.bean.ProjectDetails;

public interface UserRepositoryProject extends CrudRepository<ProjectDetails, Integer> {

}
