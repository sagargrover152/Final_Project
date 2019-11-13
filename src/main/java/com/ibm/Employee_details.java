package com.ibm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee_details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String firstname,lastname,fullname,email,designation,phonenumber,technologies;
	public Employee_details() {
		// TODO Auto-generated constructor stub
	}
	public Employee_details(String firstname, String lastname, String email, String designation,
			String phonenumber, String technologies) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.designation = designation;
		this.phonenumber = phonenumber;
		this.technologies = technologies;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	
	
	
}
