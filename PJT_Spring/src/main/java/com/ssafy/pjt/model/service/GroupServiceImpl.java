package com.ssafy.pjt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.GroupDao;
import com.ssafy.pjt.model.dto.Group;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupDao groupDao;
	
	@Override
	public List<Group> selectAll() {
		return groupDao.selectAll();
	}

	@Override
	public Group selectOne(int id) {
		return groupDao.selectOne(id);
	}

	@Override
	public List<Group> selectByName(String name) {
		return groupDao.selectByName(name);
	}

	@Override
	public int insertGroup(Group group) {
		return groupDao.insertGroup(group);
	}

	@Override
	public int updateGroup(Group group) {
		return groupDao.updateGroup(group);
	}

	@Override
	public int deleteGroup(int id) {
		return groupDao.deleteGroup(id);
	}

}
