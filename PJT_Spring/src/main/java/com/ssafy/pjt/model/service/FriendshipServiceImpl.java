package com.ssafy.pjt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.FriendshipDao;
import com.ssafy.pjt.model.dto.Friendship;
@Service
public class FriendshipServiceImpl implements FriendshipService {

	@Autowired
	private FriendshipDao friendshipDao;

	@Override
	public List<Friendship> selectFollower(String user_id) {
		return friendshipDao.selectFollower(user_id);
	}

	@Override
	public List<Friendship> selectFollowing(String user_id) {
		return friendshipDao.selectFollowing(user_id);
	}

	@Override
	public int insertFollowing(Friendship friendship) {
		return friendshipDao.insertFollowing(friendship);
	}

	@Override
	public int deleteFollowing(Friendship friendship) {
		return friendshipDao.deleteFollowing(friendship);
	}
	

}
