package com.ssafy.pjt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.model.dto.Friendship;
import com.ssafy.pjt.model.service.FriendshipService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/friendship")
public class FriendshipController {
	@Autowired
	private FriendshipService friendshipService;

	@GetMapping("/follower/{user_id}")
	public ResponseEntity<?> selectAllFollower(@PathVariable String user_id) {
		List<Friendship> followerlist = friendshipService.selectFollower(user_id);
		if (followerlist == null || followerlist.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List>(followerlist, HttpStatus.OK);
	}

	@GetMapping("/following/{user_id}")
	public ResponseEntity<?> selectAllFollowing(@PathVariable String user_id) {
		List<Friendship> followinglist = friendshipService.selectFollowing(user_id);
		if (followinglist == null || followinglist.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List>(followinglist, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> insertFriendship(@RequestBody Friendship friendship) {
		int result = friendshipService.insertFollowing(friendship);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Friendship>(friendship, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteFriendship(@RequestBody Friendship friendship) {
		int result = friendshipService.deleteFollowing(friendship);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
