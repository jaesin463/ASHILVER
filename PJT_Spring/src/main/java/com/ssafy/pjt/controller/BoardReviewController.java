package com.ssafy.pjt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.model.dto.Review;
import com.ssafy.pjt.model.service.ReviewService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/board/review")
public class BoardReviewController {
	@Autowired
	@Qualifier("BoardReview")
	private ReviewService reviewService;
	
	@GetMapping("/reviewlist/{post_id}")
	public ResponseEntity<?> selectAll(@PathVariable int post_id) {
		List<Review> reviewList = reviewService.selectAll(post_id);
		if (reviewList == null || reviewList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List>(reviewList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> selectOne(@PathVariable int id){
		Review review = reviewService.selectOne(id);
		if (review == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}

	@PostMapping("/write")
	public ResponseEntity<?> insertReview(@RequestBody Review review) {
		int result = reviewService.insertReview(review);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Review>(review, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateReview(@RequestBody Review review) {
		int result = reviewService.updateReview(review);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Review>(review, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteReview(@PathVariable int id) {
		int result = reviewService.deleteReview(id);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
