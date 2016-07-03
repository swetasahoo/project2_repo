package com.collaboration.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OnlineUsers implements Serializable {
	@Id
String username;
boolean onlinestatus;



public OnlineUsers() {
	//super();
	// TODO Auto-generated constructor stub
}

public boolean isOnlinestatus() {
	return onlinestatus;
}

public void setOnlinestatus(boolean onlinestatus) {
	this.onlinestatus = onlinestatus;
}

public OnlineUsers(String nm, boolean i) {

this.username=nm;
this.onlinestatus=i;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}


}
