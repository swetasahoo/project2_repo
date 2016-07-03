package com.collaboration.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.web.multipart.commons.CommonsMultipartFile;



@Entity
public class Users implements Serializable {
	@Id
	private String	Username;
	private String	Password;
	transient private String Cpassword;
	transient private String OPassword;
	private String	Name;
	private String	Email;
	private String	Location;
	private boolean active;
	private String Address;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch=FetchType.EAGER )
	private Set<MyBlog> blog=new HashSet<MyBlog>();
	public String getOPassword() {
		return OPassword;
	}

	public void setOPassword(String oPassword) {
		OPassword = oPassword;
	}
	
	public Set<MyBlog> getBlog() {
		return blog;
	}
	



	public void setBlog(Set<MyBlog> blog) {
		this.blog = blog;
	}
	
	public Users()
	{
		
	}
	
	public void setActive(boolean active) {
		this.active = true;
	}
	
	
	public boolean isActive() {
		return  true;
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
