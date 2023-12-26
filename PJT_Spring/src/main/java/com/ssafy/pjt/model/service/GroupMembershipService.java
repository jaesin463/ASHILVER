package com.ssafy.pjt.model.service;

import java.util.List;

import com.ssafy.pjt.model.dto.Group;
import com.ssafy.pjt.model.dto.GroupMembership;
import com.ssafy.pjt.model.dto.User;

public interface GroupMembershipService {
	// 사용자별 그룹 목록
	List<Group> selectAllGroup(String user_id);
	
	// 그룹별 사용자 목록
	List<User> selectAllUser(int group_id);
	
	// 그룹 가입
	int insertMembership(GroupMembership groupMembership);
	
	// 그룹 탈퇴
	int deleteMembership(GroupMembership groupMembership);
}
