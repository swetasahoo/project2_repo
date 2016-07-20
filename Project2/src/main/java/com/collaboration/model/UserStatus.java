package com.collaboration.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserStatus implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int statusid;
	private String mystatus;
	private Date datetime;
	@ManyToOne
	@JoinColumn(name="Username")
	@JsonIgnore
	private Users user1;
	//private String Username;

	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}	
	public String getMystatus() {
		return mystatus;
	}
	public void setMystatus(String mystatus) {
		this.mystatus = mystatus;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
public Users getUser() {
		return user1;
	}
	public void setUser(Users user) {
		this.user1 = user;
	}
	/*public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}*/

}
