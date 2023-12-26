package com.ssafy.pjt.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "GroupMembership", description = "그룹멤버십 정보")
public class GroupMembership {
	// 멤버십 번호;
	private int id;
	// 멤버십 번호;
	private String user_id;
	// 멤버십 번호;
	private int group_id;

	public GroupMembership() {
	}

	public GroupMembership(int id, String user_id, int group_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.group_id = group_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	@Override
	public String toString() {
		return "GroupMembership [id=" + id + ", user_id=" + user_id + ", group_id=" + group_id + "]";
	}
}
