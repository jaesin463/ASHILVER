package com.ssafy.pjt.model.dto;

public class Review {
	// 리뷰 번호
	private int id;
	// 게시판/그룹 번호
	private int post_id;
	// 작성자 아이디
	private String user_id;
	// 내용
	private String content;
	// 게시일
	private String reg_date;
	
	public Review() {
	}

	public Review(int id, int post_id, String user_id, String content, String reg_date) {
		super();
		this.id = id;
		this.post_id = post_id;
		this.user_id = user_id;
		this.content = content;
		this.reg_date = reg_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getuser_id() {
		return user_id;
	}

	public void setuser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", post_id=" + post_id + ", user_id=" + user_id + ", content=" + content
				+ ", reg_date=" + reg_date + "]";
	}

}
