package com.ibm.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String clientname,projectname,technologies,startdate,enddate,city,country,priority,
			manager,teammembers;
	
	
	public ProjectDetails(String clientname, String projectname, String technologies, String startdate, String enddate,
			String city, String country, String priority, String manager, String teammembers) {
		this.clientname = clientname;
		this.projectname = projectname;
		this.technologies = technologies;
		this.startdate = startdate;
		this.enddate = enddate;
		this.city = city;
		this.country = country;
		this.priority = priority;
		this.manager = manager;
		this.teammembers = teammembers;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getTeammembers() {
		return teammembers;
	}
	public void setTeammembers(String teammembers) {
		this.teammembers = teammembers;
	}
	public int getId() {
		return id;
	}
	
}
