package com.ssafy.pjt.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.pjt.model.dto.Post;

public interface PostService {
	// 전체 게시글
	List<Post> allPost();

	// 게시판/그룹 별 전체 게시글
	List<Post> selectAll(int board_id);
	
	// 이름에 따라 검색
	List<Post> selectByWord(String word);
	
	// 게시글 상세보기
	Post selectOne(int id);
	
	// 게시글 등록
	int insertPost(Post board);
	
	// 게시글 수정
	int updatePost(Post board);
	
	// 게시글 삭제
	int deletePost(int id);
	
	// 조회수 증가
	void updateViewCnt(int id);
}
