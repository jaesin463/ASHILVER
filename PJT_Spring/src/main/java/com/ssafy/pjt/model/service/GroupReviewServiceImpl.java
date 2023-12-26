package com.ssafy.pjt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.GroupReviewDao;
import com.ssafy.pjt.model.dto.Review;

@Qualifier("GroupReview")
@Service
public class GroupReviewServiceImpl implements ReviewService {

	@Autowired
	GroupReviewDao reviewDao;
	
	@Override
	public List<Review> selectAll(int post_id) {
		return reviewDao.selectAll(post_id);
	}

	@Override
	public int insertReview(Review review) {
		return reviewDao.insertReview(review);
	}

	@Override
	public int updateReview(Review review) {
		return reviewDao.updateReview(review);
	}

	@Override
	public int deleteReview(int id) {
		return reviewDao.deleteReview(id);
	}

	@Override
	public Review selectOne(int id) {
		return reviewDao.selectOne(id);
	}
}
