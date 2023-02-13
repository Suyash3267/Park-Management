package com.Park.Bo;

public class Emp_Bo {

	private int id;
	private String email,password;
	
	public Emp_Bo() {
		super();
		
	}


	public Emp_Bo(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
