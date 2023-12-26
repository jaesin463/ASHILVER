package com.ssafy.pjt.model.service;

import java.util.List;

import com.ssafy.pjt.model.dto.Group;

public interface GroupService {
	// 그룹 전체 보기
	List<Group> selectAll();

	// 그룹 상세보기
	Group selectOne(int id);

	// 이름으로 검색
	List<Group> selectByName(String name);

	// 그룹 등록
	int insertGroup(Group group);

	// 그룹 수정
	int updateGroup(Group group);

	// 그룹 삭제
	int deleteGroup(int id);
}
