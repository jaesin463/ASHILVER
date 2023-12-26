package com.ssafy.pjt.model.dto;

public class Friendship {
	// 본인 아이디
	private String user1_id;
	// 상대방 아이디
	private String user2_id;
	
	public Friendship() {
	}

	public Friendship(String user1_id, String user2_id) {
		this.user1_id = user1_id;
		this.user2_id = user2_id;
	}

	public String getUser1_id() {
		return user1_id;
	}

	public void setUser1_id(String user1_id) {
		this.user1_id = user1_id;
	}

	public String getUser2_id() {
		return user2_id;
	}

	public void setUser2_id(String user2_id) {
		this.user2_id = user2_id;
	}
}
