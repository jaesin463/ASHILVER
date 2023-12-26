package com.ssafy.pjt.model.dao;

import java.util.List;

import com.ssafy.pjt.model.dto.User;

public interface UserDao {
	// 사용자 전체 목록
	List<User> selectAll();
	// 사용자 검색
	List<User> searchById(String word);
	// 사용자 한명 선택
	User selectOne(String id);
	// 회원가입
	int insertUser(User user);
	// 회원 탈퇴
	int deleteUser(String id);
}