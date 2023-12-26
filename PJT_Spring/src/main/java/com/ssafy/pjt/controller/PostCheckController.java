package com.ssafy.pjt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.model.dto.PostCheck;
import com.ssafy.pjt.model.service.PostCheckService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/group/post")
public class PostCheckController {

	@Autowired
	private PostCheckService postCheckService;
	
	@PostMapping("/detail/check")
	public ResponseEntity<?> checkPost(@RequestBody PostCheck postCheck) {
		int result = postCheckService.checkPost(postCheck);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<PostCheck> (postCheck, HttpStatus.CREATED);
	}
	
	@GetMapping("/detail/checklist/{post_id}")
	public ResponseEntity<?> selectChecker(@PathVariable int post_id) {
		List<String> userList = postCheckService.selectChecker(post_id);
		if (userList == null || userList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List>(userList, HttpStatus.OK);
	}
}
