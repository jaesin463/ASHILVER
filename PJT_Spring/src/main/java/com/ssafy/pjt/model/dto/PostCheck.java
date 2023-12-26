package com.ssafy.pjt.model.dto;

public class PostCheck {
	private int post_id;
	private String user_id;

	public PostCheck() {
	}

	public PostCheck(int post_id, String user_id) {
		this.post_id = post_id;
		this.user_id = user_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Check [post_id=" + post_id + ", user_id=" + user_id + "]";
	}
}
