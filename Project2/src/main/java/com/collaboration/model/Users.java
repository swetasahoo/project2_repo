package com.collaboration.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Users implements Serializable {
	@Id
	private String	Username;
	private String	Password;
	transient private String Cpassword;
	transient private String OPassword;
	private String	Name;
	private String	Email;
	private String phno;	
	private String	Location;
	private int active;
	private String Address;

	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String address) {
		Address = address;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getPhno() {
		return phno;
	}
	
	//@OneToMany(mappedBy="forumcomments1", cascade=CascadeType.ALL)
	//List<Users> user;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<ForumComments1234> forumcomments1;
	
	
	@OneToMany(mappedBy="user1",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JsonIgnore
	private List<UserStatus> userstatus;
	
	
	
	public List<UserStatus> getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(List<UserStatus> userstatus) {
		this.userstatus = userstatus;
	}
	
	public List<ForumComments1234> getForumcomments1() {
		return forumcomments1;
	}

	public void setForumcomments1(List<ForumComments1234> forumcomments1) {
		this.forumcomments1 = forumcomments1;
	}

	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch=FetchType.EAGER )*/
/*	private Set<MyBlog> blog=new HashSet<MyBlog>();*/
	public String getOPassword() {
		return OPassword;
	}

	public int getActive() {
		return active;
	}
	
	public void setOPassword(String oPassword) {
		OPassword = oPassword;
	}
	
	
	public Users()
	{
		
	}
	
	public void setActive(int i) {
		this.active = i;
	}
	
	
	public int isActive() {
		return  1;
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
