package com.collaboration.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import org.hibernate.annotations.Entity;

//import org.hibernate.annotations.Entity;

@Entity
public class Forum implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int  forumid;
	String ftitle,fdescription;
/*	String comment;
	int upvote,downvote,likes;
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getUpvote() {
		return upvote;
	}

	public void setUpvote(int upvote) {
		this.upvote = upvote;
	}

	public int getDownvote() {
		return downvote;
	}

	public void setDownvote(int downvote) {
		this.downvote = downvote;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}*/
	@ManyToOne
	@JoinColumn(name="commentid")
	//@JsonIgnore
	private ForumComments1234 forumcomments;
	
	public int getForumid() {
		return forumid;
	}
	
	public ForumComments1234 getForumcomments() {
		return forumcomments;
	}

	public void setForumcomments(ForumComments1234 forumcomments) {
		this.forumcomments = forumcomments;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFdescription() {
		return fdescription;
	}
	public void setFdescription(String fdescription) {
		this.fdescription = fdescription;
	}
	

}
