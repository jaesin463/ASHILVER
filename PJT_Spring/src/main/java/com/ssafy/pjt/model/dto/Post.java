package com.ssafy.pjt.model.dto;

public class Post {
	// 게시글 번호
	private int id;
	// 게시판/그룹 번호
	private int board_id;
	// 작성자 아이디
	private String user_id;
	// 게시글 제목
	private String title;
	// 이미지 이름
	private String image;
	// 이미지 경로
	private String original_image;
	// 내용
	private String content;
	// 게시일
	private String reg_date;
	// 조회수
	private int view_cnt;
	
	public Post() {
	}

	public Post(int id, int board_id, String user_id, String title, String image, String original_image,
			String content, String reg_date, int view_cnt) {
		super();
		this.id = id;
		this.board_id = board_id;
		this.user_id = user_id;
		this.title = title;
		this.image = image;
		this.original_image = original_image;
		this.content = content;
		this.reg_date = reg_date;
		this.view_cnt = view_cnt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOriginal_image() {
		return original_image;
	}

	public void setOriginal_image(String original_image) {
		this.original_image = original_image;
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

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", board_id=" + board_id + ", user_id=" + user_id + ", title=" + title
				+ ", image=" + image + ", original_image=" + original_image + ", content=" + content + ", reg_date="
				+ reg_date + ", view_cnt=" + view_cnt + "]";
	}
}
