package com.ssafy.pjt.model.dto;

public class Betting {
	// 내기 번호
	private int id;
	// 그룹 번호
	private int group_id;
	// 내기 이름
	private String name;
	// 키워드
	private String keyword;
	// 목표
	private String goal;
	// 시상
	private String award;
	// 참가비
	private String fee;
	// 내기 시작일
	private String start;
	// 내기 종료일
	private String end;
	
	public Betting() {
	}

	public Betting(int id, int group_id, String name, String keyword, String goal, String award, String fee,
			String start, String end) {
		super();
		this.id = id;
		this.group_id = group_id;
		this.name = name;
		this.keyword = keyword;
		this.goal = goal;
		this.award = award;
		this.fee = fee;
		this.start = start;
		this.end = end;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Betting [id=" + id + ", group_id=" + group_id + ", name=" + name + ", keyword=" + keyword + ", goal="
				+ goal + ", award=" + award + ", fee=" + fee + ", start=" + start + ", end=" + end + "]";
	}
}
