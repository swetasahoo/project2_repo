package com.collaboration.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ForumComments1234 implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int commentid;
	String username;
	String mycomment;
	int upvote1,downvote1,likes1,forumid;
	@ManyToOne
	@JoinColumn(name="Username")
	@JsonIgnore
	private Users user;
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getUsername() {
		return username;
	}
	/*public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}*/
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMycomment() {
		return mycomment;
	}
	public void setMycomment(String mycomment) {
		this.mycomment = mycomment;
	}
	public int getUpvote1() {
		return upvote1;
	}
	public void setUpvote1(int upvote1) {
		this.upvote1 = upvote1;
	}
	public int getDownvote1() {
		return downvote1;
	}
	public void setDownvote1(int downvote1) {
		this.downvote1 = downvote1;
	}
	public int getLikes1() {
		return likes1;
	}
	public void setLikes1(int likes1) {
		this.likes1 = likes1;
	}
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	
	
	}
