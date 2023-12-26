package com.ssafy.pjt.model.dao;

import java.util.List;

import com.ssafy.pjt.model.dto.Friendship;

public interface FriendshipDao {
	// 사용자의 팔로워 목록
	List<Friendship> selectFollower(String user_id);

	// 사용자의 팔로잉 목록
	List<Friendship> selectFollowing(String user_id);

	// 사용자 팔로우 추가
	// 사용자 입장 팔로잉
	// 상대방 입장 팔로워
	int insertFollowing(Friendship friendship);
	
	// 팔로잉 삭제
	int deleteFollowing(Friendship friendship);
}
