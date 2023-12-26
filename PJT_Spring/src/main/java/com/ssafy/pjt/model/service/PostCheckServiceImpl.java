package com.ssafy.pjt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.PostCheckDao;
import com.ssafy.pjt.model.dto.PostCheck;

@Service
public class PostCheckServiceImpl implements PostCheckService {
	
	@Autowired
	private PostCheckDao postCheckDao;

	@Override
	public int checkPost(PostCheck postCheck) {
		return postCheckDao.checkPost(postCheck);
	}

	@Override
	public List<String> selectChecker(int post_id) {
		return postCheckDao.selectChecker(post_id);
	}

	@Override
	public PostCheck select(PostCheck postCheck) {
		return postCheckDao.select(postCheck);
	}

}
