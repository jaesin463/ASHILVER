package com.ssafy.pjt.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.ssafy.pjt.model.dto.Post;
import com.ssafy.pjt.model.service.PostService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/board/post")
public class BoardPostController {
	@Autowired
	@Qualifier("BoardPost")
	private PostService postService;

	@Autowired
	private ResourceLoader resLoader;

	@GetMapping("/postlist")
	public ResponseEntity<?> allPost() {
		List<Post> postList = postService.allPost();
		if (postList == null || postList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List>(postList, HttpStatus.OK);
	}

	@GetMapping("/postlist/{board_id}")
	public ResponseEntity<?> selectAll(@PathVariable int board_id) {
		List<Post> postList;
		if (board_id == 0)
			postList = postService.allPost();
		else
			postList = postService.selectAll(board_id);
		if (postList == null || postList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List>(postList, HttpStatus.OK);
	}

	@GetMapping("/{word}")
	public ResponseEntity<?> selectByWord(@PathVariable String word) {
		List<Post> postList = postService.selectByWord(word);
		if (postList == null || postList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List>(postList, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<?> selectOne(@PathVariable int id) {
		Post post = postService.selectOne(id);
		if (post == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		postService.updateViewCnt(id);
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}

	@PostMapping("/write")
	public ResponseEntity<?> insertPost(@ModelAttribute Post post, @RequestParam(required = false) MultipartFile file)
			throws IllegalStateException, IOException {
		try {
			if (file != null && file.getSize() > 0) {
				Resource res = resLoader.getResource("classpath:/static/upload");
				post.setImage(System.currentTimeMillis() + "_" + file.getOriginalFilename());
				post.setOriginal_image(file.getOriginalFilename());
				file.transferTo(new File(res.getFile().getCanonicalFile() + "/" + post.getImage()));
			}
			int result = postService.insertPost(post);
			if (result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<Post>(post, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updatePost(@RequestBody Post post) {
		int result = postService.updatePost(post);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePost(@PathVariable int id) {
		int result = postService.deletePost(id);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}