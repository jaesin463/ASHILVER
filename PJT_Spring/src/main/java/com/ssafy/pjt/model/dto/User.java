package com.ssafy.pjt.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "User", description = "유저 정보")
public class User {
	// 아이디
	private String id;
	// 비밀번호
	private String password;
	// 이름
	private String name;
	// 이메일
	private String email;
	// 생일
	private String birthday;
	// 성별
	private String gender;
	// 프로필 이미지
	private String image;
	// 원본 이미지
	private String original_image;

	public User() {
	}

	public User(String id, String password, String name, String email, String birthday, String gender, String image,
			String original_image) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.image = image;
		this.original_image = original_image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", birthday="
				+ birthday + ", gender=" + gender + ", image=" + image + ", original_image=" + original_image + "]";
	}
}
