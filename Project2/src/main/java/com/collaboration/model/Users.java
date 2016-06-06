package com.collaboration.model;


import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Users {
	@Id
	private String	Username;
	private String	Password;
	transient private String Cpassword;
	private String	Name;
	private String	Email;
	private String	Location;
	 

	private boolean active;
	
	public Users()
	{
		
	}
	
	public void setActive(boolean active) {
		this.active = true;
	}
	
	
	public boolean isActive() {
		return active;
	}
	


	public String getUsername() {
		return Username;
	}
	public String getPassword()
	{
		return Password;
	}
	public String getCpassword() {
		return Cpassword;
	}
	public String getName() {
		return Name;
	}
	public String getEmail() {
		return Email;
	}
	public String getLocation() {
		return Location;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setCpassword(String cpassword) {
		Cpassword = cpassword;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setLocation(String location) {
		Location = location;
	}
	
}
