package com.project.beans;


public class AdminBean {
	 private String name;
	 private String pass;
	 private String email;
	 private Long phone;
	 
	 public String getName() {
		return name;
	}
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	 
	 public AdminBean() {
		super();
	}
	
	 public String getPass() {
		 return pass;
	 }
	 public void setPass(String pass) {
		 this.pass = pass;
	 }
	 public String getEmail() {
		 return email;
	 }
	 public void setEmail(String email) {
		 this.email = email;
	 }
	 public Long getPhone() {
		 return phone;
	 }
	 public void setPhone(Long phone) {
		 this.phone = phone;
	 }
}
