package com.ssafy.pjt.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Group", description = "그룹 정보")
public class Group {
	// 그룹 번호
	private int id;
	// 그룹 이름
	private String name;
	// 그룹 관리자
	private String leader;
	// 그룹 생성일
	private String reg_date;
	// 그룹 프로필
	private String image;
	// 그룹 프로필 오리지널
	private String original_image;
	// 그룹 소개글
	private String intro;

	public Group() {
	}

	public Group(int id, String name, String leader, String reg_date, String image, String original_image,
			String intro) {
		this.id = id;
		this.name = name;
		this.leader = leader;
		this.reg_date = reg_date;
		this.image = image;
		this.original_image = original_image;
		this.intro = intro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", leader=" + leader + ", reg_date=" + reg_date + ", image="
				+ image + ", original_image=" + original_image + ", intro=" + intro + "]";
	}
}
