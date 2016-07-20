package com.collaboration.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import oracle.sql.DATE;

@Entity
public class MyBlog implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogid;
	private String blogtitle;
	private String blogcontent;
	String Username;
	private int approve;
	
	@Transient
	private MultipartFile doc;
	
	/*@ManyToOne
	@JoinColumn(name = "blogid")
	private Users user;*/
	
	
	/*public void setUser(Users user) {
		this.user = user;
	}
	*/
	

	public MultipartFile getDoc() {
		return doc;
	}



	public void setDoc(MultipartFile doc) {
		this.doc = doc;
	}
	
	public int getApprove() {
		return approve;
	}



	public void setApprove(int approve) {
		this.approve = approve;
	}



	public int getId() {
		return blogid;
	}
	public void setId(int id) {
		this.blogid = id;
	}
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getBlogtitle() {
		return blogtitle;
	}
	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}
	public String getBlogcontent() {
		return blogcontent;
	}
	public void setBlogcontent(String blogcontent) {
		this.blogcontent = blogcontent;
	}



	public String getUsername() {
		return Username;
	}



	public void setUsername(String username) {
		Username = username;
	}



	
	

}
