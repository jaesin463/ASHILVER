package com.ssafy.pjt.controller;

import java.io.File;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.pjt.model.dto.User;
import com.ssafy.pjt.model.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ResourceLoader resLoader;

	// 전체 유저 목록
	@GetMapping("/userlist")
	public ResponseEntity<?> selectAll() {
		List<User> userList = userService.selectAll();
		if (userList == null || userList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List>(userList, HttpStatus.OK);
	}

	@GetMapping("/userlist/{word}")
	public ResponseEntity<?> searchById(@PathVariable String word) {
		List<User> userList = userService.searchById(word);
		if (userList == null || userList.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List>(userList, HttpStatus.OK);
	}

	// 유저 선택
	@GetMapping("/detail/{userId}")
	public ResponseEntity<?> selectOne(@PathVariable String userId) {
		User tmp = userService.selectOne(userId);
		if (tmp == null)
			return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
		return new ResponseEntity<User>(tmp, HttpStatus.OK);
	}

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<?> selectOne(@RequestBody User user, HttpSession session) {
		User tmp = userService.selectOne(user.getId());
		// 로그인 실패 (잘못했어)
		if (tmp == null || !tmp.getPassword().equals(user.getPassword())) {
			System.out.println("로그인실패");
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
		session.setAttribute("loginUser", tmp.getName());
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	// 회원가입을 해보자 form 태그 형식으로 넘어왔다.
	@PostMapping("/signup")
	public ResponseEntity<?> insertUser(@ModelAttribute User user, @RequestParam(required = false) MultipartFile file) {
		try {
			if (file != null && file.getSize() > 0) {
				System.out.println(user.getImage());
				Resource res = resLoader.getResource("classpath:/static/upload");
				user.setImage(System.currentTimeMillis() + "_" + file.getOriginalFilename());
				user.setOriginal_image(file.getOriginalFilename());
				file.transferTo(new File(res.getFile().getCanonicalFile() + "/" + user.getImage()));
			}
			int result = userService.insertUser(user);
			if (result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	// *******************로그아웃 수정 필요*********************
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		String str = (String) session.getAttribute("loginUser");
		if (str == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		session.invalidate();
		return ResponseEntity.created(URI.create("/user/logout"))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE + ";charset=" + StandardCharsets.UTF_8)
				.body(str + "님 안녕히가세요.");
	}

	// 회원 탈퇴
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable String id) {
		int result = userService.deleteUser(id);
		if (result == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}