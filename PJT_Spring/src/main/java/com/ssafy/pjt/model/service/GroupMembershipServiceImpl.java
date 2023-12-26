package com.ssafy.pjt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.GroupDao;
import com.ssafy.pjt.model.dao.GroupMembershipDao;
import com.ssafy.pjt.model.dto.Group;
import com.ssafy.pjt.model.dto.GroupMembership;
import com.ssafy.pjt.model.dto.User;
@Service
public class GroupMembershipServiceImpl implements GroupMembershipService {

	@Autowired
	private GroupMembershipDao groupMembershipDao;
	@Autowired
	private GroupDao groupDao;
	
	@Override
	public List<Group> selectAllGroup(String user_id) {
		return groupMembershipDao.selectAllGroup(user_id);
	}
	
	@Override
	public List<User> selectAllUser(int group_id) {
		return groupMembershipDao.selectAllUser(group_id);
	}

	@Override
	public int insertMembership(GroupMembership groupMembership) {
		return groupMembershipDao.insertMembership(groupMembership);
	}

	@Override
	public int deleteMembership(GroupMembership groupMembership) {
		groupMembershipDao.deleteMembership(groupMembership);
		if (groupMembershipDao.selectAllUser(groupMembership.getGroup_id()) == null || groupMembershipDao.selectAllUser(groupMembership.getGroup_id()).size() == 0) {
			return groupDao.deleteGroup(groupMembership.getGroup_id());
		}
		return 1;
	}

}
