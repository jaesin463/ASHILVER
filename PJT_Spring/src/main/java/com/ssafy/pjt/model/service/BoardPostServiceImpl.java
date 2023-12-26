package com.ssafy.pjt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.pjt.model.dao.BoardPostDao;
import com.ssafy.pjt.model.dto.Post;

@Qualifier("BoardPost")
@Service
public class BoardPostServiceImpl implements PostService {

	@Autowired
	BoardPostDao postDao;
	
	@Override
	public List<Post> allPost() {
		return postDao.allPost();
	}
	
	@Override
	public List<Post> selectAll(int board_id) {
		return postDao.selectAll(board_id);
	}

	@Override
	public List<Post> selectByWord(String word) {
		return postDao.selectByWord(word);
	}

	@Override
	public Post selectOne(int id) {
		return postDao.selectOne(id);
	}

	@Override
	public int insertPost(Post board) {
		return postDao.insertPost(board);
	}

	@Override
	public int updatePost(Post board) {
		return postDao.updatePost(board);
	}

	@Override
	public int deletePost(int id) {
		return postDao.deletePost(id);
	}

	@Override
	public void updateViewCnt(int id) {
		postDao.updateViewCnt(id);
	}

}
