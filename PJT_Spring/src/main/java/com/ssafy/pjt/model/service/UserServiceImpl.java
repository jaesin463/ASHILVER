package com.ssafy.pjt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.UserDao;
import com.ssafy.pjt.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}
	
	@Override
	public List<User> searchById(String word) {
		return userDao.searchById(word);
	}
	
	@Override
	public User selectOne(String id) {
		// DB 해당 ID만 넘겨서 데이터를 가지고 오고 가지고온 User 데이터와 내가 현재 가지고 있는 user의 비밀번호를 확인하면
		return userDao.selectOne(id);
	}

	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public int deleteUser(String id) {
		return userDao.deleteUser(id);
	}

}