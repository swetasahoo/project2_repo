package com.collaboration.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyForum implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int forumId;
	String Username;
	String forumtitle,forumcomments;
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getForumtitle() {
		return forumtitle;
	}
	public void setForumtitle(String forumtitle) {
		this.forumtitle = forumtitle;
	}
	public String getForumcomments() {
		return forumcomments;
	}
	public void setForumcomments(String forumcomments) {
		this.forumcomments = forumcomments;
	}
	

}
