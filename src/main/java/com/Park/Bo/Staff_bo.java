package com.Park.Bo;

public class Staff_bo {

private int id;
private String name;
private String phone;
private String email;
private String job;
private String doj;
private String doc;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public Staff_bo() {
	super();
	// TODO Auto-generated constructor stub
}
public Staff_bo(String name, String phone, String email, String job, String doj, String doc) {
	super();
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.job = job;
	this.doj = doj;
	this.doc = doc;
}
public void setEmail(String email) {
	this.email = email;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public String getDoj() {
	return doj;
}
public void setDoj(String doj) {
	this.doj = doj;
}
public String getDoc() {
	return doc;
}
public void setDoc(String doc) {
	this.doc = doc;
}


}
