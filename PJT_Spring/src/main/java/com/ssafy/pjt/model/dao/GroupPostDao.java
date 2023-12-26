package com.ssafy.pjt.model.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.pjt.model.dto.Post;

public interface GroupPostDao {
	// 그룹 별 게시글
	List<Post> selectAll(int group_id);
	
	// 이름에 따라 검색
	List<Post> selectByWord(String word);
	
	// 게시글 상세보기
	Post selectOne(int id);
	
	// 게시글 등록
	int insertPost(Post post);
	
	// 게시글 수정
	int updatePost(Post post);
	
	// 게시글 삭제
	int deletePost(int id);
	
	// 조회수 증가
	void updateViewCnt(int id);
}
