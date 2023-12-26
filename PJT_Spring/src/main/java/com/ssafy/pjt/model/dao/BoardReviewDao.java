package com.ssafy.pjt.model.dao;

import java.util.List;

import com.ssafy.pjt.model.dto.Review;

public interface BoardReviewDao {
	// 게시글 별 리뷰
	List<Review> selectAll(int post_id);
	
	// 리뷰 등록
	int insertReview(Review review);
	
	// 리뷰 수정
	int updateReview(Review review);
	
	// 리뷰 삭제
	int deleteReview(int id);
	
	Review selectOne(int id);
}
