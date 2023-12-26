package com.ssafy.pjt.model.service;

import java.util.List;

import com.ssafy.pjt.model.dto.PostCheck;

public interface PostCheckService {
	// 인증 확인
	int checkPost(PostCheck postCheck);
	
	// 해당 글에 인증 확인한 유저 목록
	List<String> selectChecker(int post_id);

	PostCheck select(PostCheck postCheck);
}
