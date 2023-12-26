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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.model.dto.Group;
import com.ssafy.pjt.model.dto.GroupMembership;
import com.ssafy.pjt.model.dto.User;
import com.ssafy.pjt.model.service.GroupMembershipService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/groupmembership")
public class GroupMembershipController {
	@Autowired
	private GroupMembershipService groupMembershipService;
	
	@GetMapping("/grouplist/{user_id}")
	public ResponseEntity<?> selectAllGroup(@PathVariable String user_id) {
		List<Group> grouplist = groupMembershipService.selectAllGroup(user_id);
		if (grouplist == null || grouplist.size() == 0) 
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List>(grouplist, HttpStatus.OK);
	}

	@GetMapping("/userlist/{group_id}")
	public ResponseEntity<?> selectAllUser(@PathVariable int group_id) {
		List<User> userlist = groupMembershipService.selectAllUser(group_id);
		if (userlist == null || userlist.size() == 0) 
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List>(userlist, HttpStatus.OK);
	}
	
	@PostMapping("/write")
	public ResponseEntity<?> insertMembership(@RequestBody GroupMembership groupMembership) {
		int result = groupMembershipService.insertMembership(groupMembership);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<GroupMembership>(groupMembership, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteMembership(@RequestParam("group_id") int groupId, @RequestParam("user_id") String userId) {
	    GroupMembership groupMembership = new GroupMembership();
	    groupMembership.setGroup_id(groupId);
	    groupMembership.setUser_id(userId);
	    
		int result = groupMembershipService.deleteMembership(groupMembership);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
