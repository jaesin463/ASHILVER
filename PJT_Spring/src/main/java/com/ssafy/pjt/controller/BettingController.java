package com.ssafy.pjt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ssafy.pjt.model.dto.Betting;
import com.ssafy.pjt.model.dto.Group;
import com.ssafy.pjt.model.service.BettingService;
import com.ssafy.pjt.model.service.GroupMembershipService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/betting")
public class BettingController {
	
	@Autowired
	private BettingService bettingService;
	
	@Autowired
	private GroupMembershipService groupMembershipService;
	
	@GetMapping("/bettinglist/{group_id}")
	public ResponseEntity<?> selectAll(@PathVariable int group_id) {
		List<Betting> bettingList = bettingService.selectAll(group_id);
		if (bettingList == null || bettingList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List>(bettingList, HttpStatus.OK);
	}
	
    @GetMapping("bettinglist/user/{user_id}")
    public ResponseEntity<?> selectUserAll(@PathVariable String user_id) {
        List<Group> groupList = groupMembershipService.selectAllGroup(user_id);
        List<Betting> bettingList = new ArrayList<Betting>();

        if (groupList == null || groupList.size() == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        for (int i = 0; i < groupList.size(); i++) {
            Group group = groupList.get(i);
            List<Betting> temp = bettingService.selectAll(group.getId());
            for (int j = 0; j < temp.size(); j++) {
                bettingList.add(temp.get(j));
            }
        }

        if (bettingList == null || bettingList.size() == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List>(bettingList, HttpStatus.OK);
    }
	
	@GetMapping("/{keyword}")
	public ResponseEntity<?> selectByKeyword(@PathVariable String keyword) {
		List<Betting> bettingList = bettingService.selectByKeyword(keyword);
		if (bettingList == null || bettingList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List>(bettingList, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> selectOne(@PathVariable int id) {
		Betting betting = bettingService.selectOne(id);
		if (betting == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Betting>(betting, HttpStatus.OK);
	}
	
	@PostMapping("/write")
	public ResponseEntity<?> insertBetting(@RequestBody Betting betting) {
		int result = bettingService.insertBetting(betting);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Betting>(betting, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateBetting(@RequestBody Betting betting) {
		int result = bettingService.updateBetting(betting);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Betting>(betting, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBetting(@PathVariable int id) {
		int result = bettingService.deleteBetting(id);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
