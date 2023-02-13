package com.Park.Bo;

public class Vis_bo {
private int id;
private String name,email,phone,pass,age,enq;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getEnq() {
	return enq;
}
public void setEnq(String enq) {
	this.enq = enq;
}
public Vis_bo(String name, String email, String phone, String pass, String age, String enq) {
	super();
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.pass = pass;
	this.age = age;
	this.enq = enq;
}
public Vis_bo() {
	super();
	// TODO Auto-generated constructor stub
}

	
}
