package com.ssafy.pjt.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Board", description = "게시판 정보")
public class Board {
	// 게시판 번호
	private int id;
	// 게시판 이름
	private String name;
	
	public Board() {
	}

	public Board(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Board [id=" + id + ", name=" + name + "]";
	}
}
