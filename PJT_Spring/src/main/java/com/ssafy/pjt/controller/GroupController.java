package com.ssafy.pjt.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.pjt.model.dto.Group;
import com.ssafy.pjt.model.service.GroupService;

@RestController
@RequestMapping("/group")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private ResourceLoader g_resLoader;
	
	@GetMapping("/grouplist")
	public ResponseEntity<?> selectAll() {
		List<Group> groupList = groupService.selectAll();
		if (groupList == null || groupList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Group>>(groupList, HttpStatus.OK);
	}
	
	@GetMapping("/grouplist/{name}")
	public ResponseEntity<?> selectByName(@PathVariable String name) {
		List<Group> groupList = groupService.selectByName(name);
		if (groupList == null || groupList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List>(groupList, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> selectOne(@PathVariable int id) {
		Group group = groupService.selectOne(id);
		if (group == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Group>(group, HttpStatus.OK);
	}
	
	@PostMapping("/write")
	public ResponseEntity<?> insertGroup(@ModelAttribute Group group, @RequestParam(required = false) MultipartFile file)
			throws IllegalStateException, IOException {
		try {
			if (file != null && file.getSize() > 0) {
				Resource res = g_resLoader.getResource("classpath:/static/upload");
				group.setImage(System.currentTimeMillis() + "_" + file.getOriginalFilename());
				group.setOriginal_image(file.getOriginalFilename());
				file.transferTo(new File(res.getFile().getCanonicalFile() + "/" + group.getImage()));
			}
			int result = groupService.insertGroup(group);
			if (result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<Group>(group, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateGroup(@RequestBody Group group) {
		int result = groupService.updateGroup(group);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Group>(group, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteGroup(@PathVariable int id) {
		int result = groupService.deleteGroup(id);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
